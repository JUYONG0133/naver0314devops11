package day0318;

import java.util.Scanner;

public class Ex12_Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("구구단 : ");
		Scanner sc = new Scanner(System.in);
		int num;
		int num1;
		num = sc.nextInt();
		if((num>=10)||(num<=1)) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		System.out.println(num+"단");
		for(int i = 1; i<=9;i++) {
			
			num1 = num * i;
			System.out.printf("%d * %d = %d\n",num,i,num1);
		}
	}

}