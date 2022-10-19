package glory.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	// 어떤 형태의 데이터 타입이 반환될지 모르기 때문에 Object 데이터 타입 사용
//	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("[BEFORE] : 비즈니스 메서드 수행 전에 처리할 내용 ...");
//		Object returnObj = joinPoint.proceed();
//		System.out.println("[AFTER] 비즈니스 메서드 수행 후에 처리할 내용 ...");
//		return returnObj;
//	}
	
//	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//		
//	}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().getName();
		// spring에만 존재하는 내장 객체 stopwatch
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		// 실행할 로직 
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(method + "() 메서드 수행에 걸린 시간 : " +
				stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}
