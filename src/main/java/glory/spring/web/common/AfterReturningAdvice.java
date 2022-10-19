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
//		System.out.println("[사후처리] : 비즈니스 로직 수행 후 처리");
//	}
	
	
//	@Pointcut("execution(* glory.spring.web..*Impl.get*(..))")
//	public void getPointcut() {
//		
//	}
	
	// returning은 메소드의 바인딩 변수와 이름이 일치해야한다.
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	// JoinPoint를 매개변수로 가져올때 항상 순서를 맨 앞으로 가져와야 에러가 나지 않는다. 그 뒤에 오는 매개변수는 바인딩 변수라고 부른다.
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + "로그인[Admin]");
			}
		}
		System.out.println("[사후처리] : " + method + "() 메서드 리턴값 : " + 
				returnObj.toString());
	}
}
