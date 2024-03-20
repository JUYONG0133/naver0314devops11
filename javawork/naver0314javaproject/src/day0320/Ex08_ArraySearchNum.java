package day0320;

import java.util.Scanner;

public class Ex08_ArraySearchNum {

	public static void main(String[] args) {
		//숫자를 입력하여 배열에 몇번째에 있는지 출력;
		//없을 경우 없다고 메시지 출력과 반복검색(0을 입력하면 프로그램 종료)
		int []data = {12,3,6,5,4,3,1,7,43,23};
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			int searchIndex = -1;
			System.out.println("검색할숫자를입력하세요. (0)을 입력하면 프로그램이 종료됩니다.");
			num=sc.nextInt();
			if(num==0) {
				System.out.println("검색을종료합니다.");
				break;

			}
			for(int i = 0; i < data.length; i++) {
				if(num==data[i]) {
					searchIndex=i;
					break;
				}
			}
			if(searchIndex==-1) {
				System.out.println("입력한 값 : "+num+" 은 데이터에 없습니다.");
			}
			else {
				System.out.println(""+num+"은 "+(searchIndex+1)+"번째에 있습니다.");
			}
		}
	}

}
