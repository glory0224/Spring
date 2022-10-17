package glory.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
				
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");

		// List 타입으로 받을 때
//		List<String> addressList =  bean.getAddressList();
//		for(String address : addressList) {
//			System.out.println(address.toString());
//		}
		
		// Map 타입으로 받을 때
		
//		Map<String, String> addressList = bean.getAddressList2();
//		for( String key : addressList.keySet() ){
//		System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)) );
//		}
		
		// Properties 타입으로 받을 때
		// java.util.Properties 클래스는 특별한 타입으로 키와 값이 모두 String 형태의 Map이다.
		
//		Properties addressList = bean.getAddressList3();
//		for( String key : addressList.stringPropertyNames() ){
//		System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)) );
//		}
		
		// Set 타입으로 받을 때
		// 중복을 허용하지 않기 때문에 같은 value는 한번만 출력된다.
		
		Set<String> addressList = bean.getAddressList4();
		for (String key : addressList) {
		System.out.println(key);
		
		}

		
		factory.close();
	}

}
