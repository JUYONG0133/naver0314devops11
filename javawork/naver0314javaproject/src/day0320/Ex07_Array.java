package day0320;

public class Ex07_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr1 = {23,100,200,-13,67,-123,78,345,3,110};
		int max,min;
		max=min=arr1[0];
		for(int i = 1; i < arr1.length; i++) {
			if(max<arr1[i])
				max = arr1[i];
			else if(min>arr1[i])
				min = arr1[i];
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
		int pcnt=0,mcnt=0;
		for(int i = 0; i <arr1.length; i++) {
			if(arr1[i]>=1)
				pcnt++;
			else
				mcnt++;
		}
		System.out.println("배열에 포함된 양수 값 : "+pcnt+"개");
		System.out.println("배열에 포함된 음수 값 : "+mcnt+"개");
	}

}
