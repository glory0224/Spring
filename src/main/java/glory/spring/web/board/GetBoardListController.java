package glory.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import glory.spring.web.board.impl.BoardDAO;
import glory.spring.web.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� �˻� ó��");
		// 1. ����� �Է� ���� ���� : �˻� ����� ���߿� ���� 
		
		// 2. �����ͺ��̽� ���� ó�� 
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. ���� ȭ�� ���� (������ request ���� ��ü�� �̿��ϴ°� �´�.)
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}

}
