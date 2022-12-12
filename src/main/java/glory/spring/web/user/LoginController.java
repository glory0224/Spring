package glory.spring.web.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import glory.spring.web.user.impl.UserDAO;

@Controller
public class LoginController{
	
	
	// GET/POST 방식에 따라 수행할 메서드를 다르게 처리 (속도 측면에서 이렇게 나누는 것이 좋다)
	
	//GET 방식
	@RequestMapping(value="/login.do", method= RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	
	//POST 방식
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 처리");
		System.out.println("커밋 확인용 프린트");
		// 1. 사용자 입력 정보 추출
		// String id = request.getParameter("id");
		// String password = request.getParameter("password");
		
		// 2. 데이터베이스 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션 
//		ModelAndView mav = new ModelAndView();
		
		// 아이디 null 에러 
		if(vo.getId() == null || vo.getId().equals("")) {
			// throw로 에러가 발생 
			throw new IllegalAccessError("아이디는 반드시 입력해야 합니다.");
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
