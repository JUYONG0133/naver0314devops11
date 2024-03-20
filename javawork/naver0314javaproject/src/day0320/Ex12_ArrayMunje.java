package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("인원수 : ");
		Scanner sc = new Scanner(System.in);
		int inwon = Integer.parseInt(sc.nextLine());
		int[] kor = new int[inwon];
		int[] eng = new int[inwon];
		int[] tot = new int[inwon];
		int[] rank = new int[inwon];
		String[] name = new String[inwon];

		for(int i = 0; i<inwon; i++) {
			System.out.println(i+"번째 데이터 :");
			System.out.println("이름 : ");
			name[i] = sc.nextLine();
			System.out.println("국어점수 : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			System.out.println("영어점수 :");
			eng[i] = Integer.parseInt(sc.nextLine());
			tot[i]=kor[i]+eng[i];
		}
		for(int i = 0; i<inwon; i++) {
			
			rank[i]=1;
			for(int j = 0; j<inwon; j++) {
				if(tot[i]<tot[j]) {
					rank[i]++;
				}
			}

		}
		System.out.println("번호\t이름\t국\t영\t총\t순위");
		System.out.println("=".repeat(50));

		for(int i = 0; i <inwon; i++) {
			
			System.out.println(i+1+"\t"+name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+tot[i]+"\t"+rank[i]);
		}
		System.out.println("=".repeat(50));
	}

}
