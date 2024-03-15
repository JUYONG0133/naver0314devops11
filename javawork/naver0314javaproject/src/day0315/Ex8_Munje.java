/*
package day0315;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hp,birthyear,age ;
		
		String  name;
		//sc.nextLine();
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("핸드폰 번호 (숫자만 입력) : ");
		hp = sc.nextInt();
		System.out.println("태어난 년도 : ");
		birthyear = sc.nextInt();
		age = 2024-birthyear;
		System.out.printf("나이 : %d\n",age);
		
		System.out.printf("이름 : %s\n핸드폰번호 : %d\n태어난년도 : %d\n나이 : %d",name,hp,birthyear,age);
		
		
	}

}
*/

package day0315;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int birthyear,age ;
		
		String  name,hp;
		//sc.nextLine();
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("핸드폰 번호 ( - 포함 ): ");
		hp = sc.nextLine();
		System.out.println("태어난 년도 : ");
		birthyear = sc.nextInt();
		age = 2024-birthyear;
		System.out.printf("나이 : %d\n",age);
		
		System.out.printf("이름 : %s\n핸드폰번호 : %s\n태어난년도 : %d\n나이 : %d",name,hp,birthyear,age);
		
	}
}





