package glory.spring.polymorphism;

public class SamsungTV implements TV {
	// speaker ��ü ����� ���� private���� ����
	//private SonySpeaker speaker;
	private Speaker speaker;
	
	private int price;
	
	// ������
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
		
	}
	
	// ������ ������
//	public SamsungTV(SonySpeaker speaker) {
//		System.out.println("SamsungTV ��ü ���� : ������ ������");
//		this.speaker = speaker;
//	}
	
	// �ټ� ���� ���� 
//	public SamsungTV(SonySpeaker speaker, int price) {
//		System.out.println("SamsungTV ��ü ���� : ������ ������ - ���� ����");
//		this.speaker = speaker;
//		this.price = price;
//	}
	
	// �������̽� Speaker�� ����
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV ��ü ���� : ������ ������ - ���� ����");
		this.speaker = speaker;
		this.price = price;
	}
	
	// getter setter ����
//	public SonySpeaker getSpeaker() {
//		return speaker;
//	}
	
	// �������̽� Speaker�� ����
	public Speaker getSpeaker() {
		return speaker;
	}



//	public void setSpeaker(SonySpeaker speaker) {
//		this.speaker = speaker;
//	}
	
	// �������̽� Speaker�� ����
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	// setter ������
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() �޼��� ȣ��");
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}

//	public void setPrice(int price) {
//		this.price = price;
//	}
	
	
	// setter ������
	public void setPrice(int price) {
		System.out.println("setPrice() �޼��� ȣ��");
		this.price = price;
	}
	
	
	// init-method
//	public void start() {
//		System.out.println("��ü �ʱ�ȭ �۾� ó��");
//	}
	
	// destroy-method
//	public void stop() {
//		System.out.println("��ü ���� ���� ó���� ���� ó��");
//	}
	
	





//	public void powerOn() {
//		System.out.println("SamsungTV ������ �Ҵ�.");
//	}
	


	public void powerOn() {
		System.out.println("SamsungTV ������ �Ҵ�.(���� : " + price + ")");
	}



	public void powerOff() {
		System.out.println("SamsungTV ������ ����.");
	}

	public void volumeUp() {
		//System.out.println("SamsungTV ������ �ø���.");
		// sonyspeaker ���
		//speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	public void volumeDown() {
		//System.out.println("SamsungTV ������ ������.");
		
		// ��ü�� �ι� �����ϴ� �ߺ��� �߻�, �ٸ� Ŭ������ ���� �ΰ��� �޼��带 ��� �����ؾ��ϴ� ���ŷο� �߻�
		// ������ �������� �̿��Ͽ� �ذ��Ѵ�.
		//speaker = new SonySpeaker(); 
		
		speaker.volumeDown();
	}
}
