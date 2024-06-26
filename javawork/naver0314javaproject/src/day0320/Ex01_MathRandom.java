package day0320;

public class Ex01_MathRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.random() 시 값 ");
		for(int i = 0; i < 10; i++) {
			double d = Math.random(); // 0.0 보다 크거나같고 1.0보다 작은 난수 발생
			System.out.println(d);
		}
		System.out.println();
		System.out.println("2. random() * 10 시 값 		0~9 발생");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*10);
			System.out.printf("%4d",n);
		}
		System.out.println();
		System.out.println("=".repeat(50));
		System.out.println("3. random() * 10+1 시 값		1~10 발생");
		System.out.println();
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*10+1);
			System.out.printf("%4d",n);
		}
		System.out.println();
		System.out.println("=".repeat(50));
		System.out.println("4. random() * 100+1 시 값		1~100 발생");
		System.out.println();
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*100+1);
			System.out.printf("%4d",n);
		}
		System.out.println();
		System.out.println("=".repeat(50));
		System.out.println("5. random() *26+65 시 값		65(A)~90(Z) 발생"); //26을 곱하는 이유는 90-65 = 
		System.out.println();
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*26)+65;
			System.out.printf("%4c",(char)n);
		}
		System.out.println();
		System.out.println("=".repeat(50));
		System.out.println("6. random() *26+97 시 값		97(a)~122(z) 발생");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random()*26)+97;
			System.out.printf("%4c",(char)n);
		}
		System.out.println();
		System.out.println("=".repeat(50));
	}

}
