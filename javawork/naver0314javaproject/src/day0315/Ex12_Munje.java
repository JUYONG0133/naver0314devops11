package day0315;

import java.util.Scanner;

public class Ex12_Munje {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("점수를 입력하세요");
		num=sc.nextInt();
		String msg;
		msg = num>=90 ? "참 잘했어요!": num>=80 ? "수고했어요!" : num>=70 ? "조금 더 노력하세요!" : "재시험입니다.";
		System.out.println(num+"=>"+msg);
	}

}
