package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * set 인터페이스를 구현한 클래스로는 treeset, hashset 이 있다,
		 * set 특징 1: 중복데이터를 허용하지 않는다.
		 * 		   2: 비 순차적이다.
		 * 		   3: treeset은 오름차순으로 들어간다. hashset 은 자기 맘대로 들어간다.
		 * 
		 */
		//<Integer> : 제네릭, 해당 컬렉션에는 integer 타입만 넣을수있다. 다른 타입을 넣을 경우 컴파일 오류 발생
		//Set<Integer> set1 = new HashSet<Integer>();
		//Set<Integer> set1 = new HashSet<>();  //뒷부분 제네릭 <> 안에 integer 생략가능
		Set<Integer> set1 = new TreeSet<Integer>(); //treeset 은 오름차순
		set1.add(100); //jdk5 이전에는 set1.add(new Integer(100)); 
		set1.add(79);
		set1.add(79);
		set1.add(100);
		set1.add(65);
		System.out.println(set1.size()); // 출력 값 3 //중복 데이터 허용X 데이터가 안들어가는것이 아닌 중복데이터는 덮어쓰기
		
		System.out.println("=".repeat(30));
		System.out.println("출력 1 for");
		System.out.println("=".repeat(30));
		for(int n : set1) {
			System.out.println(n);
		}
		//System.out.println("=".repeat(30));
		System.out.println("출력 2 Iterator");
		System.out.println("=".repeat(30));
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
		
		
		
		
	}

}
