package day0325;

class Animal{
	public void writeAnimal() {
		System.out.println("Animal 부모클래스");
	}
}
class Cat extends Animal {
	@Override
	public void writeAnimal() {
		super.writeAnimal();
		System.out.println("고양이");
	}
	public void play() {
		System.out.println("야옹");
	}
}
class Dog extends Animal{
	@Override
	public void writeAnimal() {
		// TODO Auto-generated method stub
		super.writeAnimal();
		System.out.println("강아지");
	}
	public void play() {
		System.out.println("멍");
	}
}
public class Ex09_Inheri {

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		cat1.writeAnimal();
		cat1.play();
		
		Dog dog1 = new Dog();
		dog1.writeAnimal();
		dog1.play();
		System.out.println("==========");
		//부모 클래스로 선언, 자식클래스로 생성
		//다형성 이라고 한다.
		//오버라이드 메소드에 한해서 호출이 가능하다.
		//writeAnimal은 호출이 가능하지만, play 메소드는 호출할 수  없다.
		Animal ani = null;
		ani = new Cat();
		ani.writeAnimal();
		//ani.play();  //에러
		ani = new Dog();
		ani.writeAnimal();
		
	}

}
