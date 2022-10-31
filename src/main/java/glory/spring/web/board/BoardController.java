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
@SessionAttributes("board") // ModelAttritbute�� ������ ���ǿ� ����Ѵ�. 
public class BoardController {
	
	// ��Ʈ�ѷ����� DAO�� ���� DI �ؼ� ����ϸ� ���������� ������ �ֱ� ������ service �������̽��� ����Ѵ�.
	@Autowired
	private BoardService boardService;
	
	// ������ ��ȯ
	@RequestMapping("/dataTransformJSON.do")
	@ResponseBody
	public List<BoardVO>  dataTransformJSON(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
		
	}
	
	@RequestMapping("/dataTransformXML.do")
	@ResponseBody
	//public List<BoardVO> dataTransform(BoardVO vo){
	public BoardListVO dataTransformXML(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		//return boardList;
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
		
	}
	
	// ������ CRUD ����� ���� ��Ʈ�ѷ��� ����, ��Ʈ�ѷ� ������ �ƹ����� �ϴ� ���� �ƴϰ� �������� �緮���� �����Ѵ�.
	
	// �˻� ��� ��Ʈ�ѷ� 
	// ModelAttribute�� ���ؼ� ��Ʈ�ѷ� ����, �� ������̼��� ��ϵ� �޼���� RequestMapping ������̼� ���� �޼��庸�� ���� ȣ��ȴ�. 
	// ���� �޼����� ���� ����� ���ϵ� ��ü�� �ڵ����� Model�� ����ȴ�. 
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	// �Խñ� ���
	@RequestMapping("/insertBoard.do")
	public String inserBoard(BoardVO vo) throws IOException {
		System.out.println("�� ��� ó��");
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			// ������ ���� �̸� 
			String fileName = uploadFile.getOriginalFilename();
			// �ش� ��ο� ������ ����
			uploadFile.transferTo(new File("D:/Spring/" + fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// �Խñ� ���� 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�� ���� ��� ó��");
//		System.out.println("��ȣ : " + vo.getSeq());
//		System.out.println("���� : " + vo.getTitle());
//		System.out.println("�ۼ��� �̸� : " + vo.getWriter());
//		System.out.println("���� : " + vo.getContent());
//		System.out.println("����� : " + vo.getRegDate());
//		System.out.println("��ȸ�� : " + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// �Խñ� ���� 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// �Խñ� �󼼺��� 
	
//	@RequestMapping("/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		System.out.println("�� �� ���� ó��");
//		mav.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");
//		return mav;
//	}

	
	// �Խñ� ���
	
//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		
//		System.out.println("�� ��� �˻� ó��");
//		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ���� ����
//		mav.setViewName("getBoardList.jsp"); // View ���� ���� 
//		return mav;
//	}
	
	
	
	
	// �ϰ��� �ִ� �ڵ带 ���� ModelAndView�� �ƴ� String���� ��ȯ
	// �̶� �Բ� ������ �� �����ʹ� Model class�� ��Ƽ� ����
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ���� ó��");
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
//	@RequestMapping("/getBoardList.do")
//	// RequestParam���� VO�� ���� ���� ���� �޾ƿ��� 
//	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required=false) String condition ,
//			@RequestParam(value="searchKeyword", defaultValue = "", required = false) String keyword ,
//			BoardVO vo, BoardDAO boardDAO, Model model) {
//		
//		System.out.println("�� ��� �˻� ó��");
//		System.out.println("�˻� ���� : " + condition);
//		System.out.println("�˻� �ܾ� : " + keyword);
//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
//		return "getBoardList.jsp";
//	}
	
	@RequestMapping("/getBoardList.do")
	//VO ��ü�� �߰��ؼ� vo�� �޾ƿ��� 
	public String getBoardList(BoardVO vo, Model model) {
		
		System.out.println("�� ��� �˻� ó��");
		System.out.println("�˻� ���� : " + vo.getSearchCondition());
		System.out.println("�˻� �ܾ� : " + vo.getSearchKeyword());
		//null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	
}
