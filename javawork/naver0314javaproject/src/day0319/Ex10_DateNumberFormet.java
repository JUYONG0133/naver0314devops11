package day0319;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_DateNumberFormet {

	public static void main(String[] args) {
		//현재 날짜를 문자열로 출력
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		System.out.println(sdf1.format(date));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
		System.out.println(sdf2.format(date));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		System.out.println(sdf3.format(date));
		
		// 숫자 포멧양식 지정하기
		int money = 5678900;
		double avg = 98.7256;
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance(); // 화폐단위와 3자리 마다 콤마가 추가되어 출력
		System.out.println(nf1.format(money));
		System.out.println(nf1.format(avg));
		//따로 생성없이 바로 메서드 호출가능
		System.out.println(NumberFormat.getInstance().format(money)); // 화폐단위 없이 3자리마다 콤마가 출력
		System.out.println(NumberFormat.getCurrencyInstance().format(money));
		
		//평균값을 소수점이하 1자리로 출력하기
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setMaximumFractionDigits(1); //소수점이하값 지정 1을 지정해주었으니 1자리로 반환 98.7 만약 소수점이하 2번째 자릿수가 5이상이면 반올림해서 98.8로 출력
		System.out.println(nf2.format(avg));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
