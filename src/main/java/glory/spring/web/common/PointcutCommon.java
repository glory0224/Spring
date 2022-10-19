package glory.spring.web.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {
	@Pointcut("execution(* glory.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* glory.spring.web..*Impl.get*(..))")
	public void getPointcut() {
	}
}
