package day0327;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex03_SetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Set<Integer> setLotto = new TreeSet<Integer>();
		//int count;
		while(true) {
			System.out.println("금액을 입력하세요");
			int money = sc.nextInt();
			if(money==0) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			else if(money < 1000) {
				System.out.println("잔액이 부족합니다");
				break;
			}

			
			
			for(int i = 0; i < money/1000; i++) {
				setLotto.clear();
				while(true) {
					int n = (int)(Math.random()*45)+1;
					setLotto.add(n);
					if(setLotto.size()==6) {
						break;
					}
				}
					System.out.printf("%3d회 : ",i+1);
					//System.out.println();
				
					for(int a : setLotto) {
						System.out.printf("%3d",a);
				
				}
					System.out.println();
				
			

			}
			
			
		}
	}

}
