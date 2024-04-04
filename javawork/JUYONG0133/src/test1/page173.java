package test1;

public class page173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []arr1 = new int[3];  //배열 변수 선언과 배열생성  //integer 초기값은 0
		
		for(int i = 0; i < 3; i++) {  //for문 실행시 배열은 0부터 시작, 배열의 길이를 3칸으로 선언했기 때문에 3번 이상 돌리면 ArrayIndexOutOfBoundsException 이 발생함
			System.out.println("arr1 ["+i+"] : "+arr1[i]+",");  //arr1[i] i값 만큼 출력한다. 배열을 생성만 하였으니 생성된 배열의 초기값이 출력
		}
		
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30; 
		//생성된 배열에 각각 값 대입
		
		for(int i = 0; i < 3; i++) {
			System.out.println("arr1 ["+i+"] : "+arr1[i]+","); //생성한 배열 arr1에 0번지~2번지까지 값을 넣어줬기 때문에 arr1[0] = 10, 1=20,2=30 순으로 출력
		}
		System.out.println();
		
		double[] arr2 = new double[3]; //double형 배열 3칸 선언 및 생성
		for(int i = 0; i < 3; i++) {
			System.out.println("arr2 ["+i+"] : "+arr2[i]+","); //double 배열 초기값은 0.0 이기 때문에 0.0이 출력
		}
	
		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		//생성된 double형 배열에 값 대입
		
		for(int i = 0; i < 3; i++) {
			System.out.println("arr2 ["+i+"] : "+arr2[i]+","); //arr[i]에 0번지~2번지까지 값을 넣어줬기 때문에 arr1[0] = 0.1, 1=0.2,2=0.3 순으로 출력
		}
		
		System.out.println();
		
		String[] arr3 = new String[3];  //String 형 배열 3칸 선언 및 생성
		
		for(int i = 0; i < 3; i++) {
			System.out.println("arr3 ["+i+"] : "+arr3[i]+","); //String 형 배열 초기값은 null이기때문에 null이 출력됨
		}
		
		arr3[0] = "1월";
		arr3[1] = "2월";
		arr3[2] = "3월";
		
		for(int i = 0; i < 3; i++) {
			System.out.println("arr3 ["+i+"] : "+arr3[i]+","); //arr[i]에 0번지~2번지까지 값을 넣어줬기 때문에 arr1[0] = 1월, 1 = 2월 , 2 =3월 순으로 출력
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
