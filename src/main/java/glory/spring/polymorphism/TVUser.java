package glory.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//TV tv = new LgTV();
		//BeanFactory factory = new BeanFactory();
		//TV tv = (TV) factory.getBean(args[0]); // run as -> run configuration���� ���� ����
		
		// spring �����̳� ����
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		// spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup) �Ѵ�.
		TV tv = (TV) factory.getBean("tv");
		
		// bean �±� scope = sigleton �ɼ� Ȯ��
		// TV tv1 = (TV) factory.getBean("tv");
		// TV tv2 = (TV) factory.getBean("tv");
		// TV tv3 = (TV) factory.getBean("tv");
		// ��ü�� 3���� ��������� sigleton �������� �ϳ��� ������
		// option�� scope = prototype�� ���� ������ŭ ������
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// Spring �����̳� ���� 
		factory.close();
	}

}
