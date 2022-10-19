package glory.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
//	public void printLog() {
//		System.out.println("[로그] : 비지니스 로직 수행 전 동작");
//	}
	
	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* glory.spring.web..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void printLog() {
	System.out.println("[로그] : 비지니스 로직 수행 전 동작");
	}
}
