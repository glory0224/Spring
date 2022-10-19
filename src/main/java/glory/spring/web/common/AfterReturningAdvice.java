package glory.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import glory.spring.web.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
//	public void afterLog() {
//		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ó��");
//	}
	
	
//	@Pointcut("execution(* glory.spring.web..*Impl.get*(..))")
//	public void getPointcut() {
//		
//	}
	
	// returning�� �޼ҵ��� ���ε� ������ �̸��� ��ġ�ؾ��Ѵ�.
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	// JoinPoint�� �Ű������� �����ö� �׻� ������ �� ������ �����;� ������ ���� �ʴ´�. �� �ڿ� ���� �Ű������� ���ε� ������� �θ���.
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + "�α���[Admin]");
			}
		}
		System.out.println("[����ó��] : " + method + "() �޼��� ���ϰ� : " + 
				returnObj.toString());
	}
}
