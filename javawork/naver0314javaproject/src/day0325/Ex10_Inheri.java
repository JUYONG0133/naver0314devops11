package day0325;
//9번에서 만든 Animal, Cat, Dog 클래스를 이용한 예제
//다형성 처리에 대한 에제
public class Ex10_Inheri {
	public static void showAnimal(Animal an) {
		an.writeAnimal(); // 이때 an 변수는 cat이 되기도 하고 dog가 되기도 한다.(누가 생성되어 넘어오냐에 따라서 다름)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showAnimal(new Cat());
		showAnimal(new Dog());
	}

}
