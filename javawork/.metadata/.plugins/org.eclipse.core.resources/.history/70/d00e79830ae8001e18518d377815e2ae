package day0322;

class Myshop{
	
	private String sangpum;
	private int su,dan;
	private static String messge;  //static 이기때무에 공유되는값
	
	public static final String SHOP="24시간 이마트";
	
	//setter method
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	static public void setMessge(String messge) {
		//static 멤버변수는 같은 구역에 같은 이름의 변수가 있을 경우 앞에 클래스명을 생략하지 말고 써준다.
		Myshop.messge = messge;
	}
	
	//상품, 수량, 단가를 한번에 변경하고 싶을경우
	public void setData(String sangpum, int su, int dan) {
		//메소드안에서 같은 멤버 메소드는 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		
	}
	//overloding method (중복함수) : 메소드명은 같으나 인자가 달라야한다.
	public void setData(String sangpum, int su, int dan,String messge) {
		//메소드안에서 같은 멤버 메소드는 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		
		//인스턴스 메소드에서 static 메소드 호출이 가능할까? O
		setMessge(messge); // 앞에 클래스명은 같은 클래스라생략함;
		
		//********************************반대로 static 메소드에서 일반 인스턴스 메소드 호출이 가능할까? X
		//static 메소드에서 같은 static 메소드는 호출이 가능할까? O 
		
	}
	//출력은 getter 가 아닌 일반메소드로 만들어보자
	public void writeData() {
		System.out.println("상품명 : "+sangpum);
		System.out.println("수량 : "+su+" 단가 : "+dan);
		System.out.println("총금액 : "+(su*dan));
		System.out.println("오늘의 메세지 : "+messge);
		System.out.println("=".repeat(30));
	}
}

public class Ex03_StaticMethod {
	
	public static void main(String[] args) {
		Myshop sang1 = new Myshop();
		Myshop sang2 = new Myshop();
		Myshop sang3 = new Myshop();
		System.out.println("==상품1==");
		sang1.setSangpum("딸기");
		sang1.setSu(3);
		sang1.setDan(2300);
		Myshop.setMessge("오늘 각종 과일 세일합니다");
		sang1.writeData();
		System.out.println("==상품2==");
		sang2.setData("수박", 5, 2000);
		sang2.writeData();
		System.out.println("==상품3==");
		sang3.setData("참외", 5, 2000,"오늘세일 마감");
		sang3.writeData();
		System.out.println("==상품1다시출력==");
		sang1.writeData();
		System.out.println("==상품2의수량만출력==");
		sang2.setSu(5);
		sang2.writeData();
	}

}
