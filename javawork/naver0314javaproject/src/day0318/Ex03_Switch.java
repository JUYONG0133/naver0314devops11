package day0318;

import java.util.Scanner;

public class Ex03_Switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num=0;
		
		System.out.println("숫자 1~3을 입력하세요.");
		num = sc.nextInt();
		System.out.println(num+" 을 입력하셨습니다.");
		
		switch (num) {
			case 1 :
					System.out.println("one");
					break;
		
			case 2 : 
					System.out.println("two");
					break;
		
			case 3 :
					System.out.println("three");
					break;
			default : 
					System.out.println("other number");
					
		}  // switch case 문에서 해당 case에서 프로그램을 종료하려면 case 마지막에 break;를 사용해서 해당 switch case 문을 종료시킴;
	}

}
