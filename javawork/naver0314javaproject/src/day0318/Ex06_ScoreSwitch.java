package day0318;

import java.util.Scanner;

public class Ex06_ScoreSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num;
		String num1;
		System.out.println("점수 입력");
		num = sc.nextInt();
		//if 문
		if(num<0 ||  num>100) {
			System.out.println("잘못된점수입니다.");
			return ; //main 메서드를 종료 (프로그램이 종료됨);
		}
		
		if(num>=90) {
			num1 = "A";
			System.out.println(num1);
		}
		else if (num>=80) {
			num1 = "B";
			System.out.println(num1);
		}
		else if(num>=70) {
			num1 = "C";
			System.out.println(num1);
		}
		else if(num>=60) {
			num1 = "D";
			System.out.println(num1);
		}
		else {
			num1 = "F";
			System.out.println(num1);
		}
		System.out.println(num+"점은 "+num1+"학점입니다.");
	}
}

		/* switch case 문 
		Scanner sc = new Scanner(System.in);
		int num;
		String num1;
		System.out.println("점수 입력");
		num = sc.nextInt();
		
		if(num<0 ||  num>100) {
			System.out.println("잘못된점수입니다.");
			return ; //main 메서드를 종료 (프로그램이 종료됨);
		}
		switch(num/10) {
			case 10:
			case 9 :
				num1 = "A";
				break;
			case 8 :
				num1 = "B";
				break;
			case 7 : 
				num1 = "C";
				break;
			case 6 :
				num1 = "D";
				break;
			default :
				num1 = "F";
		}
		System.out.println(num+"점은 "+num1+"학점입니다.");
	}
}
*/
