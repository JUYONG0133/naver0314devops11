package day0328;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Ex03_LambdaForEach {

	public static void main(String[] args) {
		//list 에 데이터를 넣고 출력하는 방법 1
		List<String> list1 = new Vector<String>();
		list1.add("빨강");
		list1.add("노랑");
		list1.add("분홍");
		list1.add("초록");
		
		for(String s : list1) {
			System.out.println(s);
		}
		System.out.println("-----------------");
		//list 에 데이터를 넣고 출력하는 방법 2
		List<String> list2 = Arrays.asList("장미","다알리아","칸나","안개");
		list2.forEach(s->System.out.println(s));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
