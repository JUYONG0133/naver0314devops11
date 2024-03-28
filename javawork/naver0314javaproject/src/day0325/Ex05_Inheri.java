package day0325;
//같은 패키지내에서는 부모가 가진 메소드중 private를 제외하고 모두 상속받음

class Parent1{
	void method1() {
		System.out.println("부모의 디폴드 메소드");
	}
	protected void method2() {
		System.out.println("부모의 protected 메소드");
	}
	private void method3() {
		System.out.println("부모의 private 메소드");
	}
	public void method4() {
		System.out.println("부모의 public 메소드");
	}
}

//서브 클래스 구현	

class Sub1 extends Parent1{
	public void show() {
		/*
		 * 현재 클래스에 같은 이름의 메소드가 존재할경우
		 * 부모 메소드 호출시 앞에 super 호출
		 * 
		 * 같은 이름의 메소드가 없을경우 super 대신 this 로 호출해도된다,
		 * 
		 * 같은 이름의 메소드를 override method 라고 한다.
		 * 
		 */
		this.method1(); //부모가 다른 패키지에 있다면 default도 호출안됌
		this.method2();
		//this.method3();  //private 는 상속안됌;
		this.method4();
		
		
		//this가 아닌 super로도 호출가능
		super.method1();
		super.method2();
		super.method4();
	}
}





public class Ex05_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub1 s = new Sub1();
		s.show();
	}

}
