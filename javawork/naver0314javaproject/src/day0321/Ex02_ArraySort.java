package day0321;

public class Ex02_ArraySort {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int a=10,b=20;
//		int temp; //임시변수;
//		System.out.println(a+" "+b);
//		temp = a;
//		a = b;
//		b = temp;
//		System.out.println(a+" "+b);
		
	
		int arr1[] = {5,8,2,1,10};
		//selection sort;
		for(int i = 0; i < arr1.length-1; i++) {
			for(int j = i+1; j < arr1.length; j++) {
//				if(arr1[j]<arr1[i]) { // 오름차순 정렬 
//					int temp = arr1[i];
//					arr1[i] = arr1[j];
//					arr1[j] = temp;
//				}
				if(arr1[j]>arr1[i]) { //내림차순 정렬 
				int temp = arr1[i];
				arr1[i] = arr1[j];
				arr1[j] = temp;
			}
			}
		}
		for(int a : arr1)
			System.out.println(a);
	}
	

}
