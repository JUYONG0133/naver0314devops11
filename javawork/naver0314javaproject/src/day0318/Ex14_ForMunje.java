package day0318;

import java.util.Scanner;

public class Ex14_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("5개의 정수를 입력하세요.");	
		int num,sum = 0,count = 0;
		for(int i = 1; i<=5;i++) {

				num = sc.nextInt();
				if(num<=100&&num>=1) {

				sum+=num;
				System.out.println("점수는 ? "+num);
				count++;
				continue;
				}

		}
		System.out.println("입력한 점수 갯수 : "+count);
		System.out.println("총 합계 : "+sum);
		
		
	}

}
