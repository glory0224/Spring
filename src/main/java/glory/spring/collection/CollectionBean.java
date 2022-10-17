package glory.spring.collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	
	private List<String> addressList;
	private Map<String, String> addressList2;
	private Properties addressList3;
	private Set<String> addressList4;
	
	
	public List<String> getAddressList() {
	return addressList;
	}
	public void setAddressList(List<String> addressList) {
	this.addressList = addressList;
	}
	
	public Map<String, String> getAddressList2() {
		return addressList2;
	}
	public void setAddressList2(Map<String, String> addressList2) {
		this.addressList2 = addressList2;
	}
	public Properties getAddressList3() {
		return addressList3;
	}
	public void setAddressList3(Properties addressList3) {
		this.addressList3 = addressList3;
	}
	public Set<String> getAddressList4() {
		return addressList4;
	}
	public void setAddressList4(Set<String> addressList4) {
		this.addressList4 = addressList4;
	}
	
	
	
	
	
}
