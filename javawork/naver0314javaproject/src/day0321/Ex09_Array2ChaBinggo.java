package day0321;

import java.util.Scanner;

public class Ex09_Array2ChaBinggo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[3][3];
		int binggo;
		Scanner sc = new Scanner(System.in);
		System.out.println("=".repeat(15));
		System.out.println();
		while(true) {
			//랜덤함수
			binggo = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = (int)(Math.random()*3)+1;
				}
			}
			//랜덤함수 출력
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.printf("%4d",arr[i][j]);
				}
				System.out.println("\n");
			}
			//빙고 계산
			for(int i = 0; i < 3; i++) {
				if(arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2]) {
					binggo++;
				}
				if(arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i]) {
					binggo++;
				}
			}
			if(arr[0][0]==arr[1][1]&&arr[1][1]==arr[1][2]) {
				binggo++;
			}
			if(arr[0][2]==arr[1][1]&&arr[1][1]==arr[2][0]) {
				binggo++;
			}
			
			if(binggo==0) {
				System.out.println("\t광");
			}
			else {
				System.out.println("\t"+binggo+" 빙고");
			}
//			for(int i = 0; i<3; i++) {
//				for(int j=0; j<arr[i].length; j++) {
//					if(arr[i][0]==arr[i+1][0]) {
//						if(arr[i][0]==arr[i+2][0]) {
//							binggo++;
//						}
//					}
//				}
//			}




			System.out.println("=".repeat(15));
			String ans = sc.nextLine();
			if(ans.equalsIgnoreCase("x")){{
				System.out.println("빙고 게임을 종료합니다.");
				break;
			}

			}
		}
	}
}


