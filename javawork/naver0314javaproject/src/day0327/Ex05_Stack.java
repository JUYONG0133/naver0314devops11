package day0327;

import java.util.List;
import java.util.Stack;

public class Ex05_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 인터페이스 구현한 클래스중 하나
		//LIFO 방식 : 먼저 들어간게 나중에 나오는 방식
		Stack<String> stack1 = new Stack<String>();
		//List<String> stack1 = new Stack<String>(); //push는 오버라이드 메소드가 아니기때문에 list로 선언 불가
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("딸기");
		System.out.println(stack1.size());
		
		while(!stack1.isEmpty()) { //isEmpty 
			System.out.println(stack1.pop());  //마지막으로 추가한 딸기가 먼저 출력됨
		}
		
	}

}
