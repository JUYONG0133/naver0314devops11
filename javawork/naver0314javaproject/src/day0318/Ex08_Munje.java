package day0318;

import java.util.Scanner;

public class Ex08_Munje {

	public static void main(String[] args) {
		int dctotal = 0;
		Scanner sc = new Scanner(System.in);
		
		String sang;
		int su, dan,total;
		System.out.println("상품명 ");
		sang = sc.nextLine();
		System.out.println("수량 ");
		su = sc.nextInt();
		System.out.println("단가 ");
		dan = sc.nextInt();
		
		total = su * dan;

		
		System.out.println(sang+" "+su+"개의 총금액"+"총 금액 : "+total);
		
		if(su>=5) {
			//dctotal = total*9/10;
			//dctotal = (int)(total*0.9);
			dctotal = total-(total/10);
			//System.out.println(dctotal);
			System.out.println("5개 이상이므로 10%할인 입니다.");
			System.out.println("10% 할인된 금액 : "+ dctotal);
		}
	}
}
