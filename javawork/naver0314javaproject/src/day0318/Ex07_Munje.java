package day0318;

import java.util.Scanner;

public class Ex07_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num, fanum;
		String name;
		System.out.println("이름 입력 ");
		name = sc.nextLine();
		System.out.println("가족수 입력 ");
		fanum = sc.nextInt();
		System.out.println("기본급 입력");
		num = sc.nextInt();
		int total=0;
		if(fanum >= 3 ) {
			total = num + (fanum*50000);
		}
		else if(fanum<3) {
			total = num + 30000;
		}
		System.out.println("이름 : "+name+"\n기본급 : "+num+"\n가족수 : "+fanum+"\n실수령액 : "+total);
	}

}
