package day0322;

class Orange {
	//private 접근 지정자는  같은 클래스 내에서만 접근이 가능
	//멤버 변수는 자동 초기화 객체는 null int 0이 들어간다.
	
	private String name; 
	private int age;
	
	private static String company = "삼성";
	
	
	
	//getter 메소드 : 멤버변수값을 반환하는 메소드 규칙: getName, getAge);
	public String getName() {
	  //return this.name     //this : 자기 자신을 의미하는 인스턴스 변수(일반 멤버메소드에만 존재, static 메소드에는 없음);
		return name;  //같은 구역안에 같은 이름이 없을경우에만 this 생략가능
	}
	public int getAge() {
		return age;
	}
	//외부로부터 값을 받아서 멤버변수의 값을 변경
	public void setName(String name) { //(인자 )
		this.name = name; // 인자에 있는 name 값을멤버변수 name 으로 전달;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	//static 변수를 반환하는 메서드
	public static String getCompany() {
		return company;
	}
	
	
}
public class Ex02_Object {

	public static void main(String[] args) {
		Orange oo = new Orange();
		System.out.println(oo.getName());
		System.out.println(oo.getAge());
		
		//이름과 나이 변경 후 출력]
		oo.setName("ㅇㅇ");
		oo.setAge(23);
		System.out.println(oo.getName());
		System.out.println(oo.getAge());
		
		//static method 호출도 클래스명으로 호출가능
		System.out.println(Orange.getCompany());
	}

}





































