package day0318;

public class Ex10_MultiFor {

	public static void main(String[] args) {
			for(int i = 1;i<=5;i++) {
				System.out.println("he");
				for(int j =1;j<=3;j++) {
					System.out.print("\tki");
				}
				System.out.println();
			}
			System.out.println("----------------------------------------------");
			
			for(int i=1;i<=5;i++) {
				for(int j =1; j<=3;j++){
					System.out.printf("i=%d, j=%d\n",i,j);
					if (j==2) break;
				}
				System.out.println();
			}
			System.out.println("=========================");
			
			Exit:
				for(int i=1;i<=5;i++) {
					for(int j =1; j<=3;j++){
						System.out.printf("i=%d, j=%d\n",i,j);
						if (j==2) break Exit;
					}
					System.out.println();
				}
	}

}
