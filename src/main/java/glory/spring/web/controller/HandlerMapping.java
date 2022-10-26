package glory.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import glory.spring.web.board.DeleteBoardController;
import glory.spring.web.board.GetBoardController;
import glory.spring.web.board.GetBoardListController;
import glory.spring.web.board.InsertBoardController;
import glory.spring.web.board.UpdateBoardController;
import glory.spring.web.user.LoginController;
import glory.spring.web.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	//�����Ǹ鼭 �ʱ�ȭ 
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		// ���߿� �̺κп� ��ɾ�(path)�� Controller ��ü�� �߰��ȴ�. 
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
