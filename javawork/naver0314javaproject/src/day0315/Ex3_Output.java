package day0315;

public class Ex3_Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2024;
		int month = 3;
		int day = 15;
		
		String msg = "Have a Nice day!!";
		char blood = 'B';
		double avg = 97.4567;
		
		System.out.println("** 출력 1 **");
		System.out.println("날짜 :"+year+"-"+month+"-"+day);
		System.out.print("혈액형 :"+blood+"형");//print는 다음 행으로 넘어가지 않음
		System.out.println("\t평균 :"+avg);//이전에서 print를 사용했기 때문에 평균값은 혈액형 바로 뒤에 출력 //\t를 사용하면 혈액형뒤 한탭 띄고 출력
		System.out.println("===========================================");
		//printf 를 이용하여 출력
		//변환기호를 이용해서 출력한다
		//정수 %d, 실수 %f, 문자 %c, 문자열 %s
		System.out.printf("**%40s**\n\n",msg); //%40s == 40칸의 우측기준으로 출력
		System.out.printf("**%-40s**\n\n",msg); //%40s == 40칸의 좌측기준으로 출력
		System.out.printf("**%s**\n\n",msg);
		
		System.out.printf("날짜 : %d-%d-%d\n\n",year,month,day);
		System.out.printf("날짜 : %2d-%2d-%2d\n\n",year,month,day); //출력된 값을 2칸이 안될경우 공백을 포함하여 채움
		System.out.printf("날짜 : %02d-%02d-%02d\n\n",year,month,day); //출력된 값이 2칸이 안될경우 공백에 0을 포함하여 채움
		
		System.out.printf("나의 혈액형는 %c형입니다.\n",blood);
		
		System.out.printf("평균 : %f\n",avg); //%f : 소숫점이하가 6자리
		System.out.printf("평균 : %3.1f점\n",avg); //%3.1f :전체 자릿수 3자리 소숫점아래 1자리
		System.out.printf("평균 : %10.2f점\n",avg); //자리가 남을경우 공백처리
		System.out.printf("평균 : %-10.2f점\n",avg); //자리가 남을경우 공백처리 -가포함되면 왼쪽정렬
		
		
		
	}

}














