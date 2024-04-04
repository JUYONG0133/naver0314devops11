package test1;

import java.util.Scanner;

public class page199_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-".repeat(50));
        System.out.println("1.학생 수\t 2.점수입력\t 3.점수리스트\t 4.분석\t 5.종료");
        System.out.println("-".repeat(50));
        int stu,sum=0,count=0,max=0;
        int [] scores = null;
        EXIT :
        while(true) {
            System.out.print("선택 > ");
            int num = Integer.parseInt(sc.nextLine());
            if (num == 5) {                             //5를 입력하면
                System.out.println("프로그램 종료");
                break;                                  //프로그램 종료
            }
            else if (num==1){                           //1을 입력하면
                System.out.print("학생수 > ");
                stu = Integer.parseInt(sc.nextLine());  // 총 학생수를 입력받는다
                scores = new int[stu];                  //입력 받은 총 학생 수의 점수를 입력받아야 하기 때문에 scores를 입력받은 학생수만큼 배열 칸 생성
                }
            else if (num==2) {                          //2를 입력하면.
                for (int i = 0; i < scores.length; i++) {
                    System.out.print("scores[" + i + "] >");    //총 학생수 만큼 for문을 돌린다
                    scores[i] = Integer.parseInt(sc.nextLine());    //학생 점수를 입력받는다.
                }
            }
            else if(num==3){                            //3을 입력하면
                for(int i = 0; i < scores.length; i++){     //총 학생수의 점수를 출력해야하기 때문에 학생수 만큼 for문을 돌린다.
                    System.out.println("scores["+i+"] : "+scores[i]); //배열에 저장된 학생 점수를 출력한다.
                }
            }
            else if(num==4){                            //4를 입력하면
                for(int i = 0; i < scores.length; i++){ //총 학생수의 평균과 최고점수를 출력해야하기 때문에 학생수 만큼 for문을 돌린다.
                    sum = sum + scores[i];              // 총점을 구하기 위해서 배열에 저장된 학생 점수를 계속 더한다.
                    count++;                            //count 변수를 생성하고, 평균을 구하기 위해서 총 학생수가 몇명인지 계산한다.
                    max = (max < scores[i]) ?  scores[i] :   max; //max 변수를 생성하고, 입력받아 저장한 학생 점수중 가장 큰 점수를 계산한다.
                }
                System.out.println("총점 : "+sum);
                System.out.printf("평균 : %.1f\n",(double)sum/count);
                System.out.println("최고 점수 : "+max);
            }

        }

    }
}

