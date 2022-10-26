package glory.spring.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import glory.spring.web.board.BoardVO;
import glory.spring.web.board.impl.BoardDAO;
import glory.spring.web.user.UserVO;
import glory.spring.web.user.impl.UserDAO;

@WebServlet(name="action", urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1.클라이언트 정보를 추출한다. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		// LoginController이지만 부모 객체로 받아준다. 
		Controller controller = handlerMapping.getController(path);
		// 3. 검색된 Controller를 실행한다. 
		String viewName = controller.handleRequest(request, response);
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")) {
			// do 형식이 아닌경우 viewResolver에서 prefix와 suffix를 붙여서 반환 
			view = viewResolver.getView(viewName);
		} else {
			// do 형태인 경우 그냥 바로 넣어서 반환
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동한다. 
		response.sendRedirect(view);
		
		
		//이전에 있던 분기문을 각각의 controller가 수행한다. 
		
				
	}

}
