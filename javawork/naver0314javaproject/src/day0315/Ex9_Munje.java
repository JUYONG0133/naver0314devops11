package day0315;

import java.util.Scanner;

public class Ex9_Munje {

	public static void main(String[] args) {
	
			Scanner sc = new Scanner(System.in);
			
			System.out.println("백만 단위의 금액을 입력하세요.");
			int money = sc.nextInt();
			System.out.println("만원 : "+(money/10000)+"장");
			System.out.println("천원 : "+((money/1000)%10)+"장");
			System.out.println("백원 : "+((money/100)%10)+"개");
			System.out.println("십원 : "+((money/10)%10)+"개");
			System.out.println("일원 : "+((money/1)%10)+"개");
			

	}

}
