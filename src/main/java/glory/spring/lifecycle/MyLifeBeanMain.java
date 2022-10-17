package glory.spring.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MyLifeBeanMain {

	public static void main(String[] args) {
		// BeanPostProcessor 사용 
//		FileSystemResource resource = 
//				new FileSystemResource("src/main/resources/applicationContext.xml");
//		XmlBeanFactory factory = new XmlBeanFactory(resource);
//		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		
		// BeanPostProcessor를 자동 생성해주는 ApplicationContext를 사용
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		MyLifeBean bean = (MyLifeBean) factory.getBean("myLifeBean");
		bean.sayHello();
		//factory.destroyBean("myLifeBean", bean); // BeanPostProcessor를 사용할 때 닫는 방식
		factory.close();
	}

}
