package glory.spring.web.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import glory.spring.web.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") // ModelAttritbute의 정보를 세션에 등록한다. 
public class BoardController {
	
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
	public String inserBoard(BoardVO vo , BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 게시글 수정 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 기능 처리");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 이름 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 게시글 삭제 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
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
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 보기 처리");
		model.addAttribute("board", boardDAO.getBoard(vo));
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
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	
}
