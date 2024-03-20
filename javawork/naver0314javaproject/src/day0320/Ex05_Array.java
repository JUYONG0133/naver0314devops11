package day0320;

public class Ex05_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언 하는 여러가지 방법;
		int[] arr1;
		//arr1 배열에 몇개를 넣을지 개수만큼 할당
		arr1 = new int[5]; //5개의 배열이 생성 ㅣ 이때 각 배열에는 0의 초기값이 할당이 된다.(객체인경우는 null로 초기값이 할당)
		System.out.println("arr1의 갯수 : "+arr1.length);
		System.out.println("== arr1의 초기값 출력 ==");
		for(int i = 0; i < arr1.length; i++) {
			System.out.println((i+1)+" : "+arr1[i]);
		}
		System.out.println("==  배열에 일부 값을 변경 후 출력  ==");
		arr1[0] = 5;
		arr1[4] = 40;
		for(int i = 0; i < arr1.length; i++) {
			System.out.println((i+1)+" : "+arr1[i]);
		}
		System.out.println("== 다른 방법으로 출력하기 =="); //i 값 필요없이 배열에 들어있는 값만 출력할 경우 for(int a:arr1) 으로 배열값을 출력할수있다.
		for(int a:arr1) {
			System.out.println(a);
		}
	}

}
