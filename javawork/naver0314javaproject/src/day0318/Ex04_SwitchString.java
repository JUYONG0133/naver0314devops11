package day0318;

import java.util.Scanner;

public class Ex04_SwitchString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("영문으로 색상 입력하세요.");
		String color ;
		color = sc.nextLine();
		
		switch(color){
			case "RED" :
			case "red" :
				System.out.println("빨강색");
				break;
			case "GREEN" :
			case "green" :
				System.out.println("초록색");
				break;
			case "PINK" :
			case "pink" :
				System.out.println("분홍색");
				break;
			default :
				System.out.println("빨강, 초록, 분홍 이외의색 ");
				
		}
		
	}

}
