package day0322;
/*
 * 생성자의 특징
 * 1. 클래스명과 동일한 메소드명으로 만들어야한다.
 * 2. 리턴 타입이 없다.
 * 3. overloading이 가능하다. (여러개 생성가능)
 * 4. 생성할때 단 한번 호출됨
 * 5. 멤버변수의 초기화를 담당한다.
 * 
 */
class Kiwi{
	String  name,addr;
	Kiwi(){
		System.out.println("디폴트 생성자");
		name = "aaa";
		addr = "seoul";
	}
	
	Kiwi(String name){
		this.name= name;
		addr="서울";
	}
	
	Kiwi(String name, String addr){
		this.name=name;
		this.addr=addr;
	}
	
	
	
	public void show() {
		System.out.println(name+"님은 "+addr+"에 살고 있어요");
	}
}

public class Ex08_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi ki = new Kiwi();
		ki.show();
		Kiwi k2 = new Kiwi("강호동");
		k2.show();
		Kiwi k3 = new Kiwi("영숙이","부산");
		k3.show();
		
	}

}
