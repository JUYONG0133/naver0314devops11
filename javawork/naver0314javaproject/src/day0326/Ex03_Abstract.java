package day0326;

import java.util.Scanner;

abstract class Command{
	abstract public void process();
}
class List extends Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터 목록을 출력합니다");
	}
}
class Insert extends Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터 목록을 추가합니다");
	}
}
class Delete extends Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터 목록을 삭제합니다");
	}
}
class Update extends Command{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터 목록을 수정합니다");
	}
}


public class Ex03_Abstract {
	public static void process(Command comm) {
		comm.process(); //comm 에 누가 생성되어 있느냐에 따라서 process가 하는일이 달라진다.
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-".repeat(30));
			System.out.println("1.추가\t 2.삭제\t 3.목록출력\t 4.수정\t 5.종료");
			System.out.println("-".repeat(30));
			int num=sc.nextInt();
			if(num==5) {
				System.out.println("작업을 종료합니다.");
				break;
			}
			switch(num) {
				case 1 :
					process(new Insert());
					break;
				case 2 :
					process(new Delete());
					break;
				case 3 :
					process(new List());
					break;
				case 4 :
					process(new Update());
					break;
				default :
					System.out.println("잘못된 번호 입니다");
					break;
			}
		}
	}

}


















































