package day0318;

import java.util.Scanner;

public class Ex13_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("지수승 곱하기");
		Scanner sc = new Scanner(System.in);
		
		int x,y,sum=1;
		System.out.println("X : ");
		x = sc.nextInt();
		System.out.println("Y : ");
		y = sc.nextInt();
		for(int i =1; i<=y;i++) {
			sum *= x;
			//System.out.print(x);
		}
		System.out.println();
		System.out.printf("%d의 %d승은 %d 입니다.",x,y,sum);
	}

}
