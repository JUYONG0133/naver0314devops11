package day0319;

import java.util.Scanner;

public class Ex05_ForStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int star;
//		star = sc.nextInt();
		for(int i = 1; i <= 5; i++) { // 행 
			for(int j = 1; j <= 5; j++) { // 열
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("=".repeat(10));
		for(int i = 1; i <= 5; i++) { // 행 
			for(int j = 1; j <= i; j++) { // 열
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(10));
		for(int i = 1; i <= 5; i++) { // 행 
			for(int j = i; j <= 5; j++) { // 열
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(10));
		for(int i = 0; i < 5; i++) { // 행 
			for(int j = 0; j < i; j++) { // 열
				System.out.print(" ");
			}
			//System.out.println();
			for(int j = i; j < 5; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i = 0; i < 5; i++) { // 행 
			for(int j = i; j < 4; j++) { // 열
				System.out.print(" ");
			}
			//System.out.println();
			for(int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("=".repeat(10));
	}

}
