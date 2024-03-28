package day0325;

class Parent2{
	public void job() {
		System.out.println("부모 클래스에서 해야할일 처리..");
	}
}

class Sub2 extends Parent2{
	@Override
	public void job() {
		super.job();  //같은 이름의 메소드가 현재 클래스에 존재하므로 부모가 가진 메소드 호출시 반드시 super로 호출	
		System.out.println("자식 클래스에서 처리해야할일...");
	}
}






public class Ex06_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub2  s = new Sub2();
		s.job();  //sub2가 가진 job method 가 호출
	}

}
