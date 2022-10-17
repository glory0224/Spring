package glory.spring.polymorphism;

public class SamsungTV implements TV {
	// speaker 객체 사용을 위해 private으로 생성
	//private SonySpeaker speaker;
	private Speaker speaker;
	
	private int price;
	
	// 생성자
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
		
	}
	
	// 생성자 인젝션
//	public SamsungTV(SonySpeaker speaker) {
//		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션");
//		this.speaker = speaker;
//	}
	
	// 다수 변수 매핑 
//	public SamsungTV(SonySpeaker speaker, int price) {
//		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션 - 다중 매핑");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	// 인터페이스 Speaker로 변경
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션 - 다중 매핑");
		this.speaker = speaker;
		this.price = price;
	}
	
	// getter setter 생성
//	public SonySpeaker getSpeaker() {
//		return speaker;
//	}
	
	// 인터페이스 Speaker로 변경
	public Speaker getSpeaker() {
		return speaker;
	}



//	public void setSpeaker(SonySpeaker speaker) {
//		this.speaker = speaker;
//	}
	
	// 인터페이스 Speaker로 변경
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	// setter 인젝션
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 메서드 호출");
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}

//	public void setPrice(int price) {
//		this.price = price;
//	}
	
	
	// setter 인젝션
	public void setPrice(int price) {
		System.out.println("setPrice() 메서드 호출");
		this.price = price;
	}
	
	
	// init-method
//	public void start() {
//		System.out.println("객체 초기화 작업 처리");
//	}
	
	// destroy-method
//	public void stop() {
//		System.out.println("객체 삭제 전에 처리할 로직 처리");
//	}
	
	





//	public void powerOn() {
//		System.out.println("SamsungTV 전원을 켠다.");
//	}
	


	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다.(가격 : " + price + ")");
	}



	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}

	public void volumeUp() {
		//System.out.println("SamsungTV 볼륨을 올린다.");
		// sonyspeaker 사용
		//speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
		//System.out.println("SamsungTV 볼륨을 내린다.");
		
		// 객체를 두번 생성하는 중복이 발생, 다른 클래스를 사용시 두가지 메서드를 모두 수정해야하는 번거로움 발생
		// 생성자 인젝션을 이용하여 해결한다.
		//speaker = new SonySpeaker(); 
		
		speaker.volumeDown();
	}
}
