package day0319;

import java.util.Scanner;

public class Ex07_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int score=0,count=0,sum=0;
		System.out.println("1~100까지 점수 입력 : ");
		while(true) {
			System.out.println("숫자 0 을 입력하면 프로그램 종료");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			if(num<=100&&num>=1) {
				System.out.println("입력한 점수 : "+num);
				sum+=num;
				System.out.println("현재 입력된 점수 합 :"+sum);
				count++;
			}
			else if(num>100) System.out.println("100을 초과하여 입력하셨습니다.");
			else if(num==0)
				break;
			else if(num<1&&num!=0) System.out.println("1미만을 입력하셨습니다.");
			
		}
		System.out.println("총 갯수 : "+count+"\n합계 : "+sum);
	}

}
