package glory.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �� ��Ʈ�ѷ��� ���� Ÿ������ �������ֱ� ���� Controller �������̽� 
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
