package glory.spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// 스프링 시큐리티 컨트롤러 
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@GetMapping("/all.do")
	public String doAll() {
		
		System.out.println("all 경로");
		
		return "all.jsp";
	}
	
	@GetMapping("/member.do")
	public String doMember() {
		System.out.println("member 경로");
		
		return "member.jsp";
	}
	
	@GetMapping("/admin.do")
	public String doAdmin() {
		System.out.println("admin 경로");
		
		return "admin.jsp";
	}
	
}
