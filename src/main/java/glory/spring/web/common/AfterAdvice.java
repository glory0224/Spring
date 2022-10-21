package glory.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
//	public void finallyLog() {
//		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ������ ����");
//	}
	
//	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ������ ����");
	}
}