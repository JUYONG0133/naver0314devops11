package day0319;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num,num2,num1=0;

		int count=0;
		num = sc.nextInt();
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}

		num2 = sc.nextInt();

		for(int i = 0; i<arr.length; i++) {
			if(num2==arr[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
