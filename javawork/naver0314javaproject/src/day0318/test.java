package day0318;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,count=0;
		a = sc.nextInt();
		for(int i = 0; i<a; i++) {
			for(int j = 0; j<i;j++) {
				System.out.print(" ");
			}
			for(int j = i*2; j<(2*a)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<a-1; i++) {
			for(int j=i+1;j<a-1;j++) {
				System.out.print(" ");
			}
			
			for(int j =1; j<4+count;j++) {
				System.out.print("*");
			}
			System.out.println();
			count+=2;
		}
	}
}
