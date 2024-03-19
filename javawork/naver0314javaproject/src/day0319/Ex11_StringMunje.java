package day0319;

import java.util.Scanner;
//import java.util.StringTokenizer;

public class Ex11_StringMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		//System.out.println(msg.length());
		for(int i = 0; i<msg.length(); i++) {
			char ch = msg.charAt(i);
			if(ch>='A' && ch <='Z')
				a++;
			else if(ch>='a' && ch <='z')
				b++;
			else if(ch>='0'&&ch<='9')
				c++;
		}
		
		System.out.println("대문자 : "+a+"\n소문자 : "+b+"\n숫자 : "+c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		StringTokenizer st = new StringTokenizer(msg," ");
//		System.out.println(st.countTokens());
//		while(st.hasMoreElements()) {
//			System.out.println(st.nextToken());
//			if()
		}
	}


