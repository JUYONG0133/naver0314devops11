package day0315;

public class Ex1_DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 한줄 주석
		/*
		 * 여러줄주석
		 */
		//기본 자료형 공부
		//Boolean 첫 글자 대문자인경우 wrapper class (모든타입에 다 있음)
		boolean flag=true;
		//public static void main(String[] args) { 중괄호안에있울경우 지역변수 초기화 안됌
		//초기화를 지정하거나 나중에값을 지정해주긴해야함
		boolean flag2;
		flag2=false;
		System.out.println(flag); //printf ln == ln은 다음줄로 넘어감 어떤타입을 보내는 에러없이출력가능
		System.out.println(flag2);
		
		System.out.println(!flag); //! = not (반대로 출력)
		System.out.println(!flag2); 
		
		// && : 둘다 참일경우 참
		// || : 둘중 하나만 참이라도 참
		System.out.println(flag && flag2);
		System.out.println(flag || flag2);
		
		
	}

}
