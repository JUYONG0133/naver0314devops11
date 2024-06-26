package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 * 1. 이름추가 2.이름삭제 3.이름출력 4.이름검색 5.저장후 종료
 * 
 * 종료시 파일에 저장
 * 처음 생성시 파일에서 읽어올것
 */
public class Ex07_Vector {
	Scanner sc = new Scanner(System.in);
	List<String> list = new Vector<String>();
	static final String FILENAME = "/Users/macbook/Desktop/naver0314/person.txt";
	public Ex07_Vector() {
		try {
			personRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//생성자 호출
	public void personRead() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			//int count =0;
			while(true) {
				String name = br.readLine();
				if(name == null) {
					break;
				}
				list.add(name);
				System.out.println("총 "+list.size()+"명의 멤버명을 파일에서 읽어 추가합니다.");
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("읽어올 명단이 없습니다.");
		}finally {
			if(br!=null) br.close();
			if(fr!=null) fr.close();
		}
	}
	//종료시 저장
	public void personSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for(String s : list) {
				fw.write(s+"\n");
			}
			System.out.println("총 "+list.size()+"명의 명단을 파일에 저장합니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	//메뉴선택시번호반환
	public int getMenu() {
		int menu=0;
		System.out.println("-".repeat(70));
		System.out.println("1.이름추가\t 2.이름삭제\t 3.이름출력\t 4.이름검색\t 5.종료");
		System.out.println("-".repeat(70));
		menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	public void addPerson() {
		System.out.print("추가할 이름 입력 :");
		String name = sc.nextLine();
		list.add(name);
		System.out.println("\n"+list.size()+"번째 멤버를 추가했습니다");
	}
	public void deletePerson() {
		System.out.print("삭제할 이름 입력 :");
		String name = sc.nextLine();
		boolean f = list.remove(name);
		if(!f) {
			System.out.println(name+"은 명단에 없습니다.");
		}
		else {
			System.out.println(name+"은 명단에서 삭제했습니다.");
		}
	}
	public void listPerson() {
		System.out.println("멤버 현황");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1+" : "+list.get(i));
		}
	}
	public void searchPerson() {
			//이름을 입력하면 "@@@님은 @번째에 있습니다" 또는 "@@@님은 멤버 명단에 없습니다"
		boolean f = false;
		System.out.println("찾을 이름 검색");
		String name = sc.nextLine();
		for(int i = 0; i < list.size(); i++) {
			String listName=list.get(i);
			if(listName.equals(name)) {
				f=true;
				System.out.println(name+"은 "+(i+1)+"번째 있습니다.");
				
			}
		}
		if(!f) {
			System.out.println(name+"은 명단에 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex07_Vector ex = new Ex07_Vector();
		while(true) {
			int menu = ex.getMenu();
			if(menu==5) {
				ex.personSave();
				System.out.println("명단을 파일에 저장 후 종료");
				break;
			}
			switch (menu) {
				case 1: 
					ex.addPerson();
					break;
				case 2:
					ex.deletePerson();
					break;
				case 3:
					ex.listPerson();
					break;
				case 4:
					ex.searchPerson();
					break;
			
				default:
					System.out.println("잘못된 번호 입력");
					break;
			}
			System.out.println();
		}
	}

}
