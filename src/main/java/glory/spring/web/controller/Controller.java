package glory.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 각 컨트롤러를 같은 타입으로 관리해주기 위한 Controller 인터페이스 
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
