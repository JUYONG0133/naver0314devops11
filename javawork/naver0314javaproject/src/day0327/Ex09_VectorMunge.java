package day0327;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 1,학생 정보추가  : 이름 나이 과목3개 점수 입력
 * 2.학생 정보삭제 : 이름으로 찾아서 삭제 없을경우 없다고 출력
 * 3.학생 정보 전체 출력 " 번호 이름 자바 스프링 html 점수 총점 평균 등급 출력
 * 4.평균으로 검색 """"평균값을 입력하면 그 평균이상의 학생들을 출력
 * 5.이름으로 검색 : 입력한 이름을 포함하고 있으면 출력 (contains)
 * 6.저장후종료
 * 
 */
public class Ex09_VectorMunge {
	List<StudentDto> list = new ArrayList<StudentDto>();
	Scanner sc = new Scanner(System.in);
	static final String FILENAME = "/Users/macbook/Desktop/naver0314/student.txt";

	public Ex09_VectorMunge() {
		studentList();
	}
	public void studentList() {
		FileReader fr = null;
		BufferedReader br =null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while(true) {
				String s = br.readLine();
				if(s==null) {
					break;
				}
				String []a = s.split(",");
				if (a.length >= 5) { // 적절한 데이터 형식인지 확인
	                StudentDto dto = new StudentDto();
	                dto.setName(a[0]);
	                dto.setAge(Integer.parseInt(a[1]));
	                dto.setJava(Integer.parseInt(a[2]));
	                dto.setSpring(Integer.parseInt(a[3]));
	                dto.setHtml(Integer.parseInt(a[4]));
	                list.add(dto); // 데이터를 리스트에 추가
				}
			}
			System.out.println("총 "+list.size()+"명의 멤버 정보를 읽어왔습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("읽어올 멤버 정보가 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				// TODO Auto-generated catch block
				//	e.printStackTrace();

			}
		}
	}
	public void studentListSave() {
		FileWriter fw = null;
		try {
			fw = new  FileWriter(FILENAME);
			for(StudentDto dto : list) {
				String s = dto.getName()+","+dto.getAge()+","+dto.getJava()+","+dto.getSpring()+","+dto.getHtml()+","+dto.getTotal()+","+dto.getAvg()+","+dto.getGrade()+"\n";
				fw.write(s);
			}
			System.out.println("총 "+list.size()+"명의 정보를 파일에 저장하였습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getMenu() {
		int menu = 0;
		System.out.println("=".repeat(70));
		System.out.println("1.학생 정보 추가");
		System.out.println("2.학생 정보 삭제");
		System.out.println("3.전체 정보 출력");
		System.out.println("4.학생 평균으로 검색");
		System.out.println("5.학생 이름으로 검색");
		System.out.println("6.학생 정보 저장 후 종료");
		System.out.println("=".repeat(70));
		try {	
			menu = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("번호를 숫자로 입력해주세요");
		}
		return menu;

	}
	public void addInfo() {
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("나이를 입력하세요");
		int age = Integer.parseInt(sc.nextLine()); 
		System.out.println("Java 점수를 입력하세요");
		int java = Integer.parseInt(sc.nextLine()); 
		System.out.println("Spring 점수를 입력하세요");
		int spring = Integer.parseInt(sc.nextLine()); 
		System.out.println("Html 점수를 입력하세요");
		int html = Integer.parseInt(sc.nextLine()); 

		StudentDto dto = new StudentDto(name, age, java, spring, html);

		list.add(dto);
		System.out.println(list.size()+"번째 멤버 정보를 추가하였습니다.");

	}
	public void deleteInfo() {
		System.out.println("삭제할 학생 이름을 입력하세요.");
		String name = sc.nextLine();
		boolean f = false;
		for(int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			if(dto.getName().equals(name)) {
				f=true;
				list.remove(i);
				break;
			}
		}
		if(f) {
			System.out.println(name+"님의 정보를 삭제하였습니다. ");
		}
		else System.out.println(name+"님은 명단에 없습니다.");
	}
	public void printInfo() {
		System.out.println("\t\t 전체 멤버 명단\n");
		System.out.println("=".repeat(50));
		System.out.println("번호\t이름\t나이\tjava점수\tspring점수\thtml점수\t총점\t평균\t등급");
		System.out.println("=".repeat(50));
		for(int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			System.out.printf("%d\t %s\t %d\t %d\t %d\t\t %d\t %d\t %.2f\t %s\n", i + 1, dto.getName(), dto.getAge(), dto.getJava(), dto.getSpring(), dto.getHtml(), dto.getTotal(), (double) dto.getAvg(), dto.getGrade());

		}
		System.out.println("=".repeat(50));
	}
	public void searchInfoAvg() {
		System.out.println("찾을 학생의 평균을 입력하세요.");
		int avg = Integer.parseInt(sc.nextLine()) ;
		//MemberDto dto = new MemberDto(, hp, addr, blood);
		boolean f = false;
		for(int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			while(avg<dto.getAvg()){
				//if(dto.getName().equals(name) || dto.getName().startsWith(name)) {
				f=true;
				System.out.println("이름 : "+dto.getName());
				System.out.println("나이 : "+dto.getAge());
				System.out.println("java점수 : "+dto.getJava());
				System.out.println("spring점수 : "+dto.getSpring());
				System.out.println("html점수 : "+dto.getHtml());
				System.out.println("총 점수 : "+dto.getTotal());
				System.out.printf("평균 점수 : %3.2f\n",(double)dto.getAvg());
				System.out.println("등급 : "+dto.getGrade());
				System.out.println("=======================");
				break;
			}
		}
		if(!f) System.out.println(avg +" 이상 학생이 없습니다.");
	}
	public void searchInfoName() {
	    System.out.println("찾을 학생의 이름을 입력하세요.");
	    String name = sc.nextLine();
	    boolean f = false;
	    for (int i = 0; i < list.size(); i++) {
	        StudentDto dto = list.get(i);
	        if (dto.getName().contains(name)) { // 학생 이름에 입력한 이름이 포함되는지 확인
	            f = true;
	            System.out.println("이름 : " + dto.getName());
	            System.out.println("나이 : " + dto.getAge());
	            System.out.println("java점수 : " + dto.getJava());
	            System.out.println("spring점수 : " + dto.getSpring());
	            System.out.println("html점수 : " + dto.getHtml());
	            System.out.println("총 점수 : " + dto.getTotal());
	            System.out.printf("평균 점수 : %3.2f\n", (double) dto.getAvg());
	            System.out.println("등급 : " + dto.getGrade());
	            System.out.println("=======================");
	        }
	    }
	    if (!f) {
	        System.out.println(name + " 을 포함한 이름을 가진 학생이 없습니다.");
	    }
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex09_VectorMunge ex = new Ex09_VectorMunge();
		while(true) {
			int menu = ex.getMenu();
			switch(menu) {
			case 1 :
				ex.addInfo();
				break;
			case 2 :
				ex.deleteInfo();
				break;
			case 3 :
				ex.printInfo();
				break;
			case 4 :
				ex.searchInfoAvg();
				break;
			case 5 :
				ex.searchInfoName();
				break;
			case 6 :
				ex.studentListSave();
				System.out.println("멤버 정보를 저장 후 종료합니다");
				System.exit(0);
			default :
				System.out.println("잘못 입력된 번호 입니다");
			}
			System.out.println();
		}
	}
}
