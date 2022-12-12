package glory.spring.web.common.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	@GetMapping("/accessError.do")
	public String accessDenied(Authentication auth, Model model) {
		System.out.println("access denied : " + auth);
		model.addAttribute("msg", "Access Denied");
		return "accessError.jsp";
	}
	
	@GetMapping("/customLogin.do")
	public String loginInput(String error, String logout, Model model) {
		System.out.println("error : " + error);
		System.out.println("logout : " + logout);
		
		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
			
		}
		
		if (logout != null) {
			model.addAttribute("logout", "logout!!");
		}
		return "customLogin.jsp";
	}
	
	@GetMapping("/customLogout.do")
	public String logoutGet() {
		return "customLogout.jsp";
		
	}
}
