package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex03_RandomGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int input;
		int count;
		int random;
		String yn;
		Try:
			while(true) {
				count=0;
				random = rd.nextInt(100)+1;
				//input = Integer.parseInt(sc.nextLine());
				//count++;
				while(true) {
					System.out.print(++count+"회 : ");
					input = Integer.parseInt(sc.nextLine());
					if(input > random)
						System.out.println("\t"+input+"보다 작습니다.");
					else if(input < random) {
						System.out.println("\t"+input+"보다 큽니다.");
					}
					else {
						System.out.printf("정답 %d 입니다.",random);
						System.out.println("계속 하시려면 Y를 그만하려면 N을 입력하세요.");
						yn = sc.nextLine();
						if(yn.equalsIgnoreCase("y")) {
							System.out.println("새로운 게임을 시작합니다.");
							break;
						}
						else {
							break Try;
						}
					}

				}

			}
	}

}
