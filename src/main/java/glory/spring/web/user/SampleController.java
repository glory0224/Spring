package glory.spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// ������ ��ť��Ƽ ��Ʈ�ѷ� 
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@GetMapping("/all.do")
	public String doAll() {
		
		System.out.println("all ���");
		
		return "all.jsp";
	}
	
	@GetMapping("/member.do")
	public String doMember() {
		System.out.println("member ���");
		
		return "member.jsp";
	}
	
	@GetMapping("/admin.do")
	public String doAdmin() {
		System.out.println("admin ���");
		
		return "admin.jsp";
	}
	
}
