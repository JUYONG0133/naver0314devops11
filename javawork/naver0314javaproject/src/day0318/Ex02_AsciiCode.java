package day0318;

public class Ex02_AsciiCode {

	public static void main(String[] args) {
		char a = 'A';
		char a1 = 65; // 아스키 코드로 65는 문자 A 이다.
		
		System.out.println(a+"  "+a1);
		
		System.out.printf("A=%d, %c\n",(int)a,a1);
			
		System.out.println(a+3); //68;   char + int = int
		System.out.println(a+(char)3);
		System.out.println((char)(a+3));  //char형으로 선언된 a가 있기때문에 a+3을 char형으로 선언해주면 68에 대한 아스키 코드 D가출력됨
		
		System.out.println("==========================================");
		char c = '7';
		
		System.out.println(c);
		System.out.println(c+2); //7을 char형으로 선언했기때문에 7을 아스키 코드로 변환한 값인 55에 2가 더해짐
		int n1 = c-'0';
		System.out.println(n1);  //n1에 7(55) 에서 0(48)을 빼준다면 숫자 7 로 출력이 가능하다. //()안에 숫자는 아스키 코드
		System.out.println(n1+2);
	}

}
