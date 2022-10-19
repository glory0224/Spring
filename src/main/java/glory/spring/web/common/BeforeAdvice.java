package glory.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ����");
//	}
	
//	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		// method�� �̸��� ��ȯ�ɶ� ()�� ���� ��ȯ�Ѵ�. 
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("[����ó��] : " + method + 
				"() �޼����� ARGS ���� : " + args[0].toString());
	}
}
