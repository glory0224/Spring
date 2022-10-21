package glory.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
//	public void printLog() {
//		System.out.println("[�α�] : �����Ͻ� ���� ���� �� ����");
//	}
	
	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* glory.spring.web..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void printLog() {
	System.out.println("[�α�] : �����Ͻ� ���� ���� �� ����");
	}
}