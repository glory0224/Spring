package glory.spring.web.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import glory.spring.web.user.impl.UserDAO;

@Controller
public class LoginController{
	
	
	// GET/POST ��Ŀ� ���� ������ �޼��带 �ٸ��� ó�� (�ӵ� ���鿡�� �̷��� ������ ���� ����)
	
	//GET ���
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ�� �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	
	//POST ���
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("�α��� ó��");
		
		// 1. ����� �Է� ���� ����
		// String id = request.getParameter("id");
		// String password = request.getParameter("password");
		
		// 2. �����ͺ��̽� ���� ó��
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼� 
//		ModelAndView mav = new ModelAndView();
		
		// ���̵� null ���� 
		if(vo.getId() == null || vo.getId().equals("")) {
			// throw�� ������ �߻� 
			throw new IllegalAccessError("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		
		UserVO user = userDAO.getUser(vo);
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
		
	}

}
