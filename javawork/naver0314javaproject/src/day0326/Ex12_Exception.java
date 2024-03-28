package day0326;

public class Ex12_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,5,7,10};
		int sum=0;
		for(int i = 0; i <= arr.length; i++) {
			sum+=arr[i];
			try {
			System.out.println(i+" : "+arr[i]);
			System.out.println(sum);
			} catch(ArrayIndexOutOfBoundsException e) {
				//e.printStackTrace();  //에러추적  - 라인 번호 출력  에러가 보이고싶지 않다면 해당코드를 써주지않아도됌
				System.out.println("배열 인덱스 오류 : "+e.getMessage());  //에러가 출력되는것이 아니라 메세지로 받아볼수도 있음
			}
		}
		System.out.println("종료");
	}

}
