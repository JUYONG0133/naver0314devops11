package day0321;

import java.util.Scanner;

public class Ex06_ArrayLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []lotto = new int[6];
		int money;

		while(true) {

			System.out.println("======로또 금액 입력=======");
			System.out.println("1회당 1,000원 || (0)을 입력하면 프로그램 종료");
			money = sc.nextInt();
			if(money==0) {
				System.out.println("0을 입력하여 프로그램을 종료합니다.");
				break;
			}
				
			if(money<1000) {
				System.out.println("금액이 부족합니다.");
				continue;
			}
			
			int num = money/1000;
			for(int q=0;q<num;q++) {

				Loop:
					for(int i =0; i< lotto.length; i++) {
						int rand = (int)(Math.random()*45)+1;
						lotto[i] = rand;
						for(int j = 0; j < i; j++) {
							if(lotto[i]==lotto[j]) {
								i--;
								continue Loop;
							}
							if(lotto[i]<lotto[j]) {
								int temp = lotto[i];
								lotto[i] = lotto[j];
								lotto[j] = temp;
							}

						}
					}
				System.out.println("=".repeat(50));
				System.out.printf("%d회 :\t",q+1);
				for(int pri = 0; pri < lotto.length; pri++) {
					System.out.printf("%d\t",lotto[pri]);
					//if()
				}
				System.out.println();
				System.out.println("=".repeat(50));
				System.out.println();
				
			}
		}
	}

}
