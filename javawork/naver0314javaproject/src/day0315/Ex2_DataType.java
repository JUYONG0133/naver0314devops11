package day0315;

public class Ex2_DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수타입
		byte a = 127;
		System.out.println(a);
		
		/*
		byte b = 200;
		System.out.println(b);
		--byte는 -128 ~ 127까지 가능 200이 입력된다면 컴파일 불가능
		
		*/
		
		byte b = (byte)200; //(byte) : cast연산자 = 강제로 형변환, 값손실 발생
		System.out.println(b); // 이대로 출력하면 -56이 출력됨 || 값손실이 발생할경우 엉뚱한 값이 출력(내부적으로 2의 보수값이 나옴)
		
		//실수타입
		float f1 = 123.567891234f; //f를 붙여야 4바이트 float으로 저장 붙이지 않은경우 double로 저장
		double f2 = 123.567891234;
		System.out.println(f1); //float경우 보통 8자리까지 정확히 나옴
		System.out.println(f2); //double경우 보통 15자리까지 정확히 나옴
		
		//1글자 지정은 char, 문자열은 string(객체타입)
		char ch1 = 'A';
		char ch2 = '가'; //java에서 char는 2바이트라서 한글 한글자도 입력가능
		System.out.println(ch1);
		System.out.println(ch2);
		
		//문자열 지정하는 방법
		String str = new String("happy"); //방법1
		String str2 = "hello"; //방법 2
		System.out.println(str);
		System.out.println(str2);
		
		//긴 문자열을 지정하는 경우
		String str3="(한줄로 쭉)나는 오늘도 자바 공부...............";
		String str4="(중간에 +  사용)나는 오늘도..\n"+"자바 공부 ..............\n";
		System.out.println(str3);
		System.out.println(); 
		System.out.println(str4);
		
		String str5="""
				(큰 따옴표사용) 큰 따옴표를 사용한다면 긴 문자열을 사용할때 + 사용없이 사용할수있다,
				"""; //JDK15 부터 사용가능 텍스트 블록이라 불림
		System.out.println(str5);
		
		
		
	}

}













