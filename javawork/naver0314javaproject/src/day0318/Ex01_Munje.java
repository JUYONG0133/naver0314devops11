package day0318;

import java.util.Scanner;

public class Ex01_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		String num1;
		System.out.println("점수 입력");
		num = sc.nextInt();
		
		if(num<0 ||  num>100) {
			System.out.println("잘못된점수입니다.");
			return ; //main 메서드를 종료 (프로그램이 종료됨);
		}
		
		num1 = num >= 90 ? "A" : num >= 80 ? "B" : num >= 70 ? "C" : num >= 60 ? "D" : "F" ;
		
		System.out.println(num+"점은 "+num1+"학점입니다.");
		
	}

}


