package day0327;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex06_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new Vector<String>();
		//List<String> list1 = new ArrayList<String>();
		//List<String> list2 = new Vector<String>(5); //5개가넘을경우 10개로 할당 보통 2배처리
		List<String> list2 = new Vector<String>(5,3); //5개가 넘을경우 3개씩 추가해서 할당 받는다 ex) 할당된개수 5->8   8->11
		System.out.println("데이터 갯수"+list1.size());
		System.out.println("할당된 개수"+((Vector<String>)list1).capacity()); //capacity 는 오버라이드 메소드가 아니고 vector 갖고있는 메소드임
		System.out.println("=".repeat(50));
		System.out.println("데이터 갯수"+list2.size());
		System.out.println("할당된 개수"+((Vector<String>)list2).capacity());
		
		String []str = {"red","blue","green","white","red","yellow","pink"};
		
		//list1 에 배열 데이터 추가
		for(String s : str) {
			list1.add(s);
			list2.add(s);
		}
			System.out.println("=".repeat(50));
			System.out.println("데이터 갯수"+list1.size());
			System.out.println("할당된 개수"+((Vector<String>)list1).capacity()); //capacity 는 오버라이드 메소드가 아니고 vector 갖고있는 메소드임
			System.out.println("=".repeat(50));
			System.out.println("데이터 갯수"+list2.size());
			System.out.println("할당된 개수"+((Vector<String>)list2).capacity());
		
			
			System.out.println("=".repeat(50));
			System.out.println("출력 1   for");
			System.out.println("=".repeat(50));
			for(String s : list1) {
				System.out.println(s);
			}
			
			System.out.println("=".repeat(50));
			System.out.println("출력 2   for문 출력앞 숫자 번호 출력");
			System.out.println("=".repeat(50));
			for(int i = 0; i < list1.size(); i++) {
				System.out.println(i+1+" : "+list1.get(i));
			}
			
			System.out.println("=".repeat(50));
			System.out.println("출력 3	iterator");
			System.out.println("=".repeat(50));
			Iterator<String> iter = list1.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
			
			System.out.println("=".repeat(50));
			System.out.println("출력 4	object");
			System.out.println("=".repeat(50));
			Object []ob = list1.toArray();
			for(Object s : ob) {
				System.out.println((String)s);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}

}
