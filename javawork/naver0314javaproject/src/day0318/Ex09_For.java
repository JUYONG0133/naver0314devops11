package day0318;

public class Ex09_For {

	public static void main(String[] args) {
		
		for(int i = 1; i<=10; i++) {
			System.out.printf("%4d",i);
			}
		System.out.println();
		
		for(int i = 10; i>=1; i--) {
			System.out.printf("%4d",i);
			}
		System.out.println();
		
		for(int i = 1; i<=10; i+=3) {
			System.out.printf("%4d",i);
			}
		System.out.println();
		
		for(int i = 'A'; i<='Z'; i++) {
			System.out.printf("%4d",i);
			}
		System.out.println();
		for(int i = 65 ; i<= 90; i++) {
			System.out.printf("%4c",(char)i);
			}
		System.out.println();
		for(int i = 97 ; i<= 122; i++) {
			System.out.printf("%4d",i);
			}
		System.out.println();
		for(int i = 'a' ; i<= 'z'; i++) {
			System.out.printf("%4c",(char)i);
			}
		System.out.println();
		System.out.println();
		for(int i = 1; i <=10; i++) {
			System.out.printf("%3d",i);
			if(i==5) {// 현재속한 반복문 빠져나감
				break;
			}
		}
		System.out.println();
		System.out.println();
	
		for(int i = 1; i <=10; i++) {
			if(i%2==0) {  //홀수만 출력
				continue;
			}
			System.out.printf("%3d",i);
			
		}
		System.out.println();
		System.out.println();
		
		
		
		int num=0;
		for(int i = 2 ; i<=9; i++) {
			for(int j =1;j<=9;j++) {
				num = i*j;
				System.out.println(i+"*"+j+"="+num);
			}
			System.out.println();
		}
		
	
		
		
		
	}

}
