package day0321;

public class Ex05_ArrayAgeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []memberages = {12,56,34,23,34,58,46,5,11,32,57,54,32,19,56,54,23,12,43,53};
		//System.out.println(memberages.length);
		int []agecount = new int[6];
		
		for(int i = 0; i<memberages.length; i++) {
			
				agecount[memberages[i]/10]++;
			
		}
		
		for(int i =0; i<agecount.length;i++) {
			if(i==0) {
				System.out.println("10세미만 : "+agecount[i]);
			}
			else
				System.out.println((i*10)+"대 : "+agecount[i]);
		}
	}

}
