package day0320;

import java.util.Scanner;

public class Ex09_ArraySearchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		
		String searchName;
		while(true) {
			int searchIndex=-1;
			System.out.println("찾을 이름을 검색하세요. 영문 q를 누르면 프로그램을 종료합니다.");
			searchName = sc.nextLine();
			if(searchName.equalsIgnoreCase("q"))
				break;
			for(int i = 0; i < members.length; i++) {

				if(searchName.equals(members[i])) { //숫자를 비교할떄와 문자를비교할때 이 부분만 달라진다.
					searchIndex = i;
					//System.out.println(searchIndex);
					break;
				}
			}
			if(searchIndex==-1) {
				System.out.println("찾으시는 값 "+searchName+" 이 없습니다.");
			}
			else {
				System.out.println("찾으시려는 값 : "+searchName+"은 "+(searchIndex+1)+" 에 있습니다." );
			}

		}
	}

}
