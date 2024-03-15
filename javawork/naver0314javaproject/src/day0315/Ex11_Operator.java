package day0315;

import java.util.Scanner;

public class Ex11_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건(삼항) 연산자
		//조건식 ? 참 : 거짓
		//두수를 입력후 더 큰 숫자를 출력하시오 
//		Scanner sc = new Scanner(System.in);
//		int num1, num2, max;
//		System.out.println("두개의숫자입력");
//		num1=sc.nextInt();
//		num2=sc.nextInt();
//		//num2 보다 num1이크면 num1, num2가 더 크면 num2;
//		max = num1>num2?num1:num2;
//		System.out.println(max);
		
		Scanner sc = new Scanner(System.in);
		
		int num,num1,num2;
		int max;
		System.out.println("3개의 숫자 입력");
		num = sc.nextInt();
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		max = (num>num1&&num>num2) ? num : (num1>num2&&num1>num) ? num1 : num2; 
		System.out.println(max);
		
	}

}
