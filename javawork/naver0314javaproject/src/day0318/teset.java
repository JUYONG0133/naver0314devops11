package day0318;

import java.util.Scanner;

public class teset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		for(int i = 1; i<=a; i++) {
			for(int j = i; j<=a;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=a; i++) {
			for(int j=a-i;j<a;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}