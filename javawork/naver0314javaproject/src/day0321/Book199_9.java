package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stu = 0;
		int[] score = null;
		
		while(true) {
			System.out.println();
			System.out.println("=".repeat(55));
			System.out.println("1.학생 수\t 2.점수 입력\t 3.점수리스트\t 4.분석\t 5.종료");
			System.out.println("=".repeat(55));
			System.out.print("선택 > ");
			int num;
			num = Integer.parseInt(sc.nextLine());
			
			if(num==1) {
				System.out.print("학생 수 >");
				System.out.println();
				stu = Integer.parseInt(sc.nextLine());
				score = new int[stu];
			}
			//점수입력
			else if(num==2) {
				for(int i = 0; i<score.length; i++) {
					System.out.print("score["+(i+1)+"] > ");
					System.out.println();
					score[i] = Integer.parseInt(sc.nextLine());
					
				}
			}
			//점수리스트
			else if(num==3) {
				for(int i = 0; i<score.length; i++) {
					System.out.println("score["+(i+1)+"] : "+score[i]);
				}
				System.out.println();
			}
			//분석
			else if(num==4) {
				int max=0;
				int sum=0;
				double avg=0;
				for(int i = 0; i<score.length; i++) {
					max = (max < score[i]) ? score[i] : max ;
					sum += score[i];
					
				}
				avg = (double)sum/stu;
				System.out.println("최고 점수 : "+max);
				System.out.println("평균 점수 : "+avg);
				System.out.println();
			}
			else if(num==5) {
				break;
			}
		}
				
	}
}

