package glory.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component("tv")
public class LgTV implements TV{
	
		
		@Autowired
		//@Qualifier("apple")
		//@Resource(name="apple")
		private Speaker speaker;
	
		public LgTV() {
			System.out.println("LgTV 객체 생성");
		}
		
		@Override
		public void powerOn() {
			System.out.println("LgTV 전원을 켠다.");
		}
		@Override
		public void powerOff() {
			System.out.println("LgTV 전원을 끈다.");
		}
		@Override
		public void volumeUp() {
			//System.out.println("LgTV 볼륨을 올린다.");
			speaker.volumeUp();
		}
		@Override
		public void volumeDown() {
			//System.out.println("LgTV 볼륨을 내린다.");
			speaker.volumeDown();
		}
}
