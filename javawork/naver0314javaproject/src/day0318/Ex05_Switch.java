package day0318;

import java.util.Scanner;

public class Ex05_Switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int y,m,d;
		boolean flag;
		System.out.println("년도를 입력하세요 ");
		y = sc.nextInt();
		
		if(y%4==0&y%100!=0||y%400==0) {
			System.out.println(y+"년은 윤년입니다.");
			flag = true;
		}
		else {
			System.out.println(y+"년은 평년입니다.");
			flag = false;
		}
		System.out.println("월을 입력하세요.");
		m = sc.nextInt();
		
		if(m<1 || m>12) {
			System.out.println("잘못된 월을 입력하셨습니다.");
			return;
		}
		/*
		else {
			System.out.println(m+"월을 입력하셨습니다.");
		}
		System.out.println(y+"년"+m+" 월");
		*/
		
		//switch case 문
//		switch (m) {
//			case 2 :
//				d = flag==true?29:28;
//				break;
//			case 4 :
//			case 6 :
//			case 9 :
//			case 11 :
//				d = 30;
//				break;
//			default : 
//				d = 31;
//		}
//		System.out.println(y+"년 "+m+"월은 "+d+"일 까지 있습니다.");
//		
		
		//if 문
		if (m==2) {
			d = flag==true?29:28;
		}
		else if(m==4||m==6||m==9||m==11) {
			d=30;
		}
		else {
			d = 31;
		}
		System.out.println(y+"년 "+m+"월은 "+d+"일 까지 있습니다.");
	}

}



























