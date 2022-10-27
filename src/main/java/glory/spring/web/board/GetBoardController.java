package glory.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import glory.spring.web.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �� ���� ó��");
		// 1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		// 2. �����ͺ��̽� ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. ���� ȭ�� ���� (������ request ���� ��ü�� �̿��ϴ°� �´�.)
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		//mav.setViewName("getBoard.jsp");
		mav.setViewName("getBoard"); //ViewResolver�� �����ϱ� ���� ��� ���
		return mav;
	}

}