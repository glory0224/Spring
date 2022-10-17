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

		// List Ÿ������ ���� ��
//		List<String> addressList =  bean.getAddressList();
//		for(String address : addressList) {
//			System.out.println(address.toString());
//		}
		
		// Map Ÿ������ ���� ��
		
//		Map<String, String> addressList = bean.getAddressList2();
//		for( String key : addressList.keySet() ){
//		System.out.println(String.format("Ű : %s, �� : %s", key, addressList.get(key)) );
//		}
		
		// Properties Ÿ������ ���� ��
		// java.util.Properties Ŭ������ Ư���� Ÿ������ Ű�� ���� ��� String ������ Map�̴�.
		
//		Properties addressList = bean.getAddressList3();
//		for( String key : addressList.stringPropertyNames() ){
//		System.out.println(String.format("Ű : %s, �� : %s", key, addressList.get(key)) );
//		}
		
		// Set Ÿ������ ���� ��
		// �ߺ��� ������� �ʱ� ������ ���� value�� �ѹ��� ��µȴ�.
		
		Set<String> addressList = bean.getAddressList4();
		for (String key : addressList) {
		System.out.println(key);
		
		}

		
		factory.close();
	}

}
