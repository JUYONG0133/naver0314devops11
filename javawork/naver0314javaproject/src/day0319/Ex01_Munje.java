package day0319;

public class Ex01_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1~100까지의 소수");
		int count=0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 2; j <= i; j++) {
				if(i%j==0) {
					if(i==j) {
						System.out.printf("%3d",i);
						count ++;
					}
					
					else break;
				}

			}
			

		}
		System.out.println();
		System.out.println(count);
	}

}