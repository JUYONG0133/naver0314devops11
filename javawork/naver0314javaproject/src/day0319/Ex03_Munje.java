package day0319;

public class Ex03_Munje {

	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				int sum = (i * 10 + j) + (j * 10 + i );
				if(sum ==121)
					System.out.printf("%d%d + %d%d = 121\n",i,j,j,i);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
}
//		// TODO Auto-generated method stub
//		int num=0,num1=0,sum=0;
//		for(int i = 1; i <= 9; i++) {
//			for(int j = i-1; j <= 9; j++) {
//				num=i*j;
//				System.out.printf("%d: ",num);
//				num1=j*i;
//				System.out.printf("%d: ",num1);
//				System.out.println();
//				System.out.println(num+num1);
//			}
////			for(int j = 1; j <= 9; j++) {
////				num1=j*i;
////				System.out.printf("%d ",num1);
////			}
////			
////			System.out.println();
////			System.out.println(num+num1);
////			System.out.println();
//		}
//
//	}
//		
//	}
//
//
////xy+yx=121
//
////num+num1=121
