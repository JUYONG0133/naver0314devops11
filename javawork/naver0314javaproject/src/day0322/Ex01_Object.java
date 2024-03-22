package day0322;


class Apple{
	String msg = "Happy Day";  //인스턴스 멤버 변수
	static String messge = "오늘은 금요일"; //static 멤버변수 final이 붙은 경우는 대문자, 안붙은 경우는 첫글자는 소문자 이후 단어가 붙으면 두번째 부터 대문자를 입력한다..
	
}

class Banana {
	static int kor = 100;
	static int eng = 80;
	String name = "마이클";
}


public class Ex01_Object {
	//멤버변수들
	String name = "홍길동"; // 인스턴스 변수
	final static int Max = 100; //static 변수 , final : 상수 지정,  값 변경이 안됨;
	
		
	public static void main(String[] args) {
		/*
		 *  static 멤버 메소드는 static 멤버 변수나 static 멤버메소드만 접근이 가능하다.
		 *  일반 인스턴스 메소드나 변수를 접근하기 위해서는 new 로 생성 후 
		 *  그 변수를 이용해서 호출해야한다.  
		 */
	//	System.out.println(name);  //오류 발생
		System.out.println(Ex01_Object.Max); //static  변수는 클래스명.변수명
		System.out.println(Max);  //같은클래스에 있을경우 클래스명은 생략이 가능하다. 
		
		
		//name 을 출력하려면 new 생성한 인스턴스 변수가 필요하다,
		Ex01_Object ex = new Ex01_Object();
		//ex가 인스턴스 변수이다. 이 변수를 이용해야만 name 이 접근이 가능하다.
		System.out.println(ex.name);
		
		//Apple 가 가진 2개의 멤버변수를 출력
		Apple mm = new Apple();
		System.out.println(mm.msg);
		System.out.println(Apple.messge);
		
		//Banana 가 가진 3개의 멤버 변수를 출력
		System.out.println(Banana.kor);
		System.out.println(Banana.eng);
		System.out.println(Banana.kor+Banana.eng);
		Banana bb = new Banana();
		System.out.println(bb.name);
	}

}
