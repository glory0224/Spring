package glory.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import glory.spring.web.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		// 1. ����� �Է� ���� ���� : �˻� ����� ���߿� ���� 
		
		// 2. �����ͺ��̽� ���� ó�� 
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. ���� ȭ�� ���� (������ request ���� ��ü�� �̿��ϴ°� �´�.)
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); //Model ���� ����
		//mav.setViewName("getBoardList.jsp"); //View ���� ����
		mav.setViewName("getBoardList"); //ViewResolver�� �����ϱ� ���� ��� ���
		return mav;
	}

}