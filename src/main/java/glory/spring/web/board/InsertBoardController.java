package glory.spring.web.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import glory.spring.web.board.impl.BoardDAO;
import glory.spring.web.controller.Controller;

public class InsertBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� ��� ó��");
		// 1.����� �Է� ���� ����
		// filter ������� �ѹ��� ó���Ϸ��� �ߴµ� ������ �ȵǴ� ���� �߻� 
		// �켱 try catch�� ��Ҵ�. 
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. �����ͺ��̽� ���� ó�� 
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		// 3. ȭ�� �׺���̼� 
		return "getBoardList.do";
	
	}

}
