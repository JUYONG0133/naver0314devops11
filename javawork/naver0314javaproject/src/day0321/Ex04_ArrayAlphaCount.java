package day0321;

import java.util.Scanner;

public class Ex04_ArrayAlphaCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String msg; 
		int []alpha = new int[26];
		msg = sc.nextLine();
		
		for(int i = 0; i < msg.length(); i++) {
			char ch = msg.toUpperCase().charAt(i);
				if(ch>='A'&&ch<='Z')
					alpha[ch-'A']++;
		}
		for(int i =0; i<alpha.length;i++) {
			if(alpha[i]>0) {
				System.out.printf("%c : %d\t",(char)('A'+i),alpha[i]);
				if((i+1)%5==0) System.out.println();
			}
		}
	}

}
