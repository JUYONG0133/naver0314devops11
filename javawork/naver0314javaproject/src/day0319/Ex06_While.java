package day0319;

public class Ex06_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		while(n>10) { // 선조건 : 조건이 참이 아니라면 while문을 실행시키지 않음
			System.out.println("h");
		}
		do { // 후조건 : 조건이 참 혹은 거짓이더라도 한번은 do ~while문을 실행시키고 후에 조건을 비교함;
			System.out.println("h1");
		}while(n>10);
		int a = 1;
		while(a<=10) {
			System.out.printf("%3d",a++);
		}
		System.out.println();
		a = 1;
		while(true) {
			System.out.printf("%3d",a++);
			if(a>10) {
				break;
			}
		}
		System.out.println();
		char ch = 'A';
		while(true) {
			System.out.printf("%3s",ch++);
			if(ch>'Z')
				break;
		}
	}

}
