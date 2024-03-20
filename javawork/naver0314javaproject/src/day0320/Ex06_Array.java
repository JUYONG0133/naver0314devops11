package day0320;

public class Ex06_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열을 선언하면서 초기값을 지정하는 경우
		int []arr1 = {4,6,8,10,30};
		System.out.println("출력1");
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%4d",arr1[i]);
		}
		System.out.println();
		System.out.println("출력2");
		for(int a:arr1) {
			System.out.printf("%4d",a);
		}
		System.out.println();
		System.out.println("=".repeat(50));
		
		int []arr2;
		arr2 = new int[] {10,20,30,40,50}; // 위 arr1의 배열 선언과 다르게 arr2는 필요할때 할당을 해줄수 있다.
		System.out.println("arr의 갯수"+arr2.length);
		for(int a:arr2) {
			System.out.printf("%4d",a);
		}
		System.out.println();
		//문자열 배열
		System.out.println("=".repeat(20)+"문자열 출력"+"=".repeat(20));
		String []str1 = {"김김김","박박박","이이이","최최최","정정정"};
		String []str2 ;
		str2 = new String[] {"사과","오렌지","딸기","수박","참외"};
		
		for(int i = 0; i < str1.length; i++) {
			System.out.printf("%4s",str1[i]);
		}
		System.out.println();
		for(String s:str2) {
			System.out.printf("%4s",s);
		}
	}

}
