package glory.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//TV tv = new LgTV();
		//BeanFactory factory = new BeanFactory();
		//TV tv = (TV) factory.getBean(args[0]); // run as -> run configuration으로 인자 전달
		
		// spring 컨테이너 구동
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		// spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV) factory.getBean("tv");
		
		// bean 태그 scope = sigleton 옵션 확인
		// TV tv1 = (TV) factory.getBean("tv");
		// TV tv2 = (TV) factory.getBean("tv");
		// TV tv3 = (TV) factory.getBean("tv");
		// 객체는 3개를 만들었지만 sigleton 설정으로 하나만 생성됨
		// option을 scope = prototype인 경우는 개수만큼 생성됨
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// Spring 컨테이너 종료 
		factory.close();
	}

}
