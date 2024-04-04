package test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[]= new int[9];
        for(int i = 0; i < arr1.length ; i++){
            arr1[i] = sc.nextInt();
        }
        int count=0;
        int max = arr1[0];
        for(int i = 0; i < arr1.length; i++){
            if(max < arr1[i]){
                max = arr1[i];
                count = i+1;
            }
          //  min = min < nInt[i] ? min : nInt[i];
        }
        System.out.println(max);
        System.out.println(count);
    }
}
