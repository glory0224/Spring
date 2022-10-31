package glory.spring.web.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("board") // ModelAttritbute의 정보를 세션에 등록한다. 
public class BoardController {
	
	// 컨트롤러에서 DAO를 직접 DI 해서 사용하면 유지보수의 문제가 있기 때문에 service 인터페이스를 사용한다.
	@Autowired
	private BoardService boardService;
	
	// 데이터 변환
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	//public List<BoardVO> dataTransform(BoardVO vo){
	public BoardListVO dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		//return boardList;
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
		
	}
	
	// 간단한 CRUD 기능을 통합 컨트롤러로 관리, 컨트롤러 통합은 아무때나 하는 것이 아니고 개발자의 재량으로 통합한다.
	
	// 검색 기능 컨트롤러 
	// ModelAttribute를 통해서 컨트롤러 제어, 이 어노테이션이 등록된 메서드는 RequestMapping 어노테이션 적용 메서드보다 먼저 호출된다. 
	// 또한 메서드의 실행 결과로 리턴된 객체는 자동으로 Model에 저장된다. 
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	// 게시글 등록
	@RequestMapping("/insertBoard.do")
	public String inserBoard(BoardVO vo) throws IOException {
		System.out.println("글 등록 처리");
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			// 파일의 원래 이름 
			String fileName = uploadFile.getOriginalFilename();
			// 해당 경로에 파일을 저장
			uploadFile.transferTo(new File("D:/Spring/" + fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 게시글 수정 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 기능 처리");
//		System.out.println("번호 : " + vo.getSeq());
//		System.out.println("제목 : " + vo.getTitle());
//		System.out.println("작성자 이름 : " + vo.getWriter());
//		System.out.println("내용 : " + vo.getContent());
//		System.out.println("등록일 : " + vo.getRegDate());
//		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 게시글 삭제 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 게시글 상세보기 
	
//	@RequestMapping("/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		System.out.println("글 상세 보기 처리");
//		mav.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");
//		return mav;
//	}

	
	// 게시글 목록
	
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		
//		System.out.println("글 목록 검색 처리");
//		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
//		mav.setViewName("getBoardList.jsp"); // View 정보 저장 
//		return mav;
//	}
	
	
	
	
	// 일관성 있는 코드를 위해 ModelAndView가 아닌 String으로 반환
	// 이때 함께 가지고 갈 데이터는 Model class에 담아서 전달
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 보기 처리");
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
//	@RequestMapping("/getBoardList.do")
//	// RequestParam으로 VO에 없는 값을 직접 받아오기 
//	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required=false) String condition ,
//			@RequestParam(value="searchKeyword", defaultValue = "", required = false) String keyword ,
//			BoardVO vo, BoardDAO boardDAO, Model model) {
//		
//		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건 : " + condition);
//		System.out.println("검색 단어 : " + keyword);
//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
//		return "getBoardList.jsp";
//	}
	
	@RequestMapping("/getBoardList.do")
	//VO 객체에 추가해서 vo로 받아오기 
	public String getBoardList(BoardVO vo, Model model) {
		
		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		//null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	
}
