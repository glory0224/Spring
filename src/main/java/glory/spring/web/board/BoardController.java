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
@SessionAttributes("board") // ModelAttritbute�� ������ ���ǿ� ����Ѵ�. 
public class BoardController {
	
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
	public String inserBoard(BoardVO vo , BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// �Խñ� ���� 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ��� ó��");
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� �̸� : " + vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// �Խñ� ���� 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		boardDAO.deleteBoard(vo);
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
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�� �� ���� ó��");
		model.addAttribute("board", boardDAO.getBoard(vo));
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
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		System.out.println("�� ��� �˻� ó��");
		System.out.println("�˻� ���� : " + vo.getSearchCondition());
		System.out.println("�˻� �ܾ� : " + vo.getSearchKeyword());
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	
}
