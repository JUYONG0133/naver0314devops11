package day0319;

public class Ex04_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%63s\n\n","[구구단]");
		for(int i = 2; i <= 9; i ++) {
			System.out.printf("====%d단====\t",i);
		}
		System.out.println();
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\t",j,i,j*i);
			}
			System.out.println();
		}
	}

}
