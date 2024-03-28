package day0325;

public class Phone {
	public String model;
	public String color;
	
	public void bell() {
		System.out.println("벨이 울립니다");
		
	}
	
	public void sendVoice(String messge) {
		System.out.println("자기 : "+messge);
	}
	public void receiveVoice(String messge) {
		System.out.println("상대방 : "+messge);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
