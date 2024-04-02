package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,a1;
        int []b;
        int num;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        a1 = sc.nextInt();
        b = new int[a];
        for(int i = 0; i < a; i++) {
            b[i] = sc.nextInt();
        }
        for(int i =0; i < a; i++){

            if(b[i]<a1){
                System.out.printf("%d ",b[i]);

            }
        }
    }
}
