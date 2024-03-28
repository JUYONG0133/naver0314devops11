package day0326;
//인터페이스는 음식점의 메뉴판과 같다.
//구현 가능한 목록을 나열만하고 실체가 없기 때문이다.
//상수와 추상메소드로만 구성되어있다.


interface InterA{
	int MAX = 10;  //상수이지만 구분할 필요가 없으므로 final 생략함
	public void disp(); // 추상메소드지만 구분할 필요가 없으므로 abstract 생략함
	public void study();
	
}
class MyInter implements InterA{
	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("현재 최대 인원수는 "+MAX+"명입니다.");
	}
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("우리는 인터페이스를 공부하고 있어요");
	}
	public void play() {
		System.out.println("게임을 합니다.");
	}
}


public class Ex04_Interface {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			InterA a = new MyInter();
			a.disp();
			a.study();
			// a.play(); // 호출안됨
			//play 를 호출하고자 할 경우 
			//서브 클래스로 형변환후 호출하면 된다.
			((MyInter)a).play();
	}

}
