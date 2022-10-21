package glory.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
//	public void exceptionLog() {
//		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ���� �߻�");
//	}
	
//	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "e")
	public void exceptionLog(JoinPoint joinPoint, Exception e) {
		String method = joinPoint.getSignature().getName();
		System.out.println("[����ó��] : " + method + 
				"() �޼��� ���� �� �߻��� ���� �޼��� : " + e.getMessage());
	}
}