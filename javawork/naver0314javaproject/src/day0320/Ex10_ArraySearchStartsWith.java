package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStartsWith {
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
			int count;
			String searchName;
			char a;
			String b;
			while(true) {
				count=0;
				System.out.println("찾을 이름을 검색하세요. 영문 q를 누르면 프로그램을 종료합니다.");
				searchName = sc.nextLine();
				if(searchName.equalsIgnoreCase("q"))
					break;
				for(int i = 0; i < members.length; i++) {
					if((members[i]).startsWith(searchName)) { //숫자를 비교할떄와 문자를비교할때 이 부분만 달라진다.
						count++;
						System.out.printf("%d 번째 : %s\n",i+1,members[i]);
					}
				
				
				}
				if(count==0) {
					System.out.println("\t\""+searchName+"\"로 시작하는 이름은 없습니다.");
				}
				else {
					System.out.println("총"+count+"명");
				}
			}
		}
	}


