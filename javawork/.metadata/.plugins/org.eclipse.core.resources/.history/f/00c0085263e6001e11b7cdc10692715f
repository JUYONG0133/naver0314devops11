package day0320;

import java.util.Date;
import java.util.Scanner;

public class Ex04_MyCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year,month,week,endday;
		System.out.println("달력을 출력할 년도와 월을 입력하세요.");
		year = sc.nextInt();
		month = sc.nextInt();
		
		if(month<1 || month>12) {
			System.out.println("잘못된 월을 입력하셨습니다.");
			return;
			
		}
		System.out.printf("%22d년 %d월 달력\n",year,month);
		System.out.println("=".repeat(50));
		System.out.println("|일\t월\t화\t수\t목\t금\t토|");
		System.out.println("=".repeat(50));
		Date date = new Date(year-1900,month-1,1); //입력한 년월에 1일을 구하는 식
		week = date.getDay();
		//System.out.println(week);
		
		switch(month) {
			case 2 :
				endday = year%4==0 && year%100!=0 || year%400==0 ? 29 : 28;
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				endday = 30;
				break;
			default : 
				endday = 31;
		}
		for(int i = 1; i <= week; i++) {
			System.out.print("\t");
		}
		for(int i = 1; i <= endday; i++) {
			System.out.printf("%2d\t",i);
			++week; //토요일이 되면 7의 배수가 된다.
			if(week%7==0) {
				System.out.println("\n");
			}
		}
	}

}
