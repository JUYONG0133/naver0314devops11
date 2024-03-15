package day0315;

public class Ex4_MainArgs {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		System.out.println(args[2]+args[3]);
		//문자열-> 숫자 변환 후 계산
		//Wrapper class 중 Integer를 이용해서 변환한다.
		int s1 = Integer.parseInt(args[2]);
		int s2 = Integer.parseInt(args[3]);
		System.out.println(s1+s2);
	}

}
