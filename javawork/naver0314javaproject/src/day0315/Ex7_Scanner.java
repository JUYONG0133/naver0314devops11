package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng;
		
		String name;
		
		System.out.println("국어점수는 ?");
		kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어점수는 ?");
		eng = Integer.parseInt(sc.nextLine());
		
		
		
		System.out.println("이름은 ?");
		name = sc.nextLine();//점수뒤에엔터를읽어온다.(엔터가 버퍼에 저장이 되어있는 상태
		
		System.out.println("이름: "+name);
		System.out.printf("국어점수 :%d점, 영어점수 :%d점\n",kor,eng);
		System.out.printf("총점 : %d점, 평균 : %d점",kor+eng,(kor+eng)/2);
		//System.out.printf("총점 : %d점, 평균 : %3.1f점",kor+eng,(kor+eng)/2.0);정수형으로 입력받은 형태를 묵시적으로형변환 시키기위해선 2 와같은 정수형에 .0 을 붙여 실수형으로 표
		// 결과가 double 이어야할경우 수식중 한개라도 double타입이 있어야한다.
		

	}

}
