package day0319;

public class Ex08_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**String 객체의 Method 공부하기**");
		String str1 = "Have a Nice Day";
		//인덱스 시작은 항상 0부터 시작함	
		System.out.println(str1.charAt(7)) ; //7번 인덱스의 문자 : N 
		System.out.println(str1.charAt(0)) ; //0번 인덱스의 문자 : H
		System.out.println(str1.indexOf('a')); //첫번째 'a'의 위치 : 1
		System.out.println(str1.indexOf('X')); //첫번째 'X'의 위치 : -1 (없을 경우 : -1)
		System.out.println(str1.lastIndexOf('a')); //마지막 'a'의 위치 : 13
		System.out.println(str1.length()); //str1의 총 길이 : 15
		System.out.println();
		String str2 = "apple";
		System.out.println(str2.concat("***")); ///str2문자에 *** 추가해서 반환
		System.out.println(str2+"***");///위와 같음
		System.out.println(str1.toLowerCase()); //str1을 모두 소문자로 바꿔서 반
		System.out.println(str1.toUpperCase()); //str1을 모두 대문자로 바꿔서 반환
		
		//문자열 비교시(값으로 비교시 equal 사용
		String str3 = "Apple";
		System.out.println("apple".equals(str2)); //true
		System.out.println("apple".equals(str3)); //false 
		//equal 은 대소문자 구별하기 때문에 str2는 참으로 나오지만 str3는 대문자가 포함되어서 false로 나옴
		System.out.println(str2.equals(str3)); //false 대소문자가 다르므로 거짓
		System.out.println(str2.equalsIgnoreCase(str3)); //true [equalsIgnoreCase : 대소문자 상관없이 비교]
		
		//문자열 추출
		System.out.println(str1.substring(7)); //7번 인덱스부터 끝 까지 추출 : Nice Day
		System.out.println(str1.substring(7,10)); //7번 부터 9까지 추출 : Nic
		
		//문자열 비교( 시작과 끝)
		System.out.println(str1.startsWith("Have")); //str1이 Have로 시작하면 true 그렇지 않으면 false : true
		System.out.println(str1.startsWith("Nice")); //str1이 Nice로 시작하면 true 그렇지 않으면 false : false
		System.out.println(str1.endsWith("Day")); //str1이 Day로 끝나면 true 그렇지 않으면 false : true
		System.out.println(str1.endsWith("day")); //str1이 day로 끝나면 true 그렇지 않으면 false : false
		System.out.println(str1.toLowerCase().endsWith("day")); // str1을 모두 소문자로 변환후 day와 일치하는지 비교 : true
		//compareTo 로 비
		System.out.println("apple".compareTo("append"));// 'l' , 'e' : 7(양수 : 첫 문자열이 더 크다.) 첫문자열이 작을경우 음수가 나온다.
		System.out.println("apple".compareTo("banana")); // 'a', 'b' : -1
		System.out.println("apple".compareTo("apple")); // 'a', 'b' : 완전히 같을경우 0
		
		//반복
		System.out.println(str2.repeat(3)); //str2를 3번반복  : appleappleapple
		System.out.println("*".repeat(10)); //*를 10번 반복 **********
		
		//변경
		System.out.println(str1.replace('a', '*')); //str1의 a를 *로 변경 H*ve * Nice D*y
		System.out.println(str1.replace("Nice", "Good")); //str1 의 Nice를 Good로 변경 Have a Good Day
		
		//문자열 분리(결과값이 배열타입)
		String colors = "red,blue,green,yellow,pink";
		System.out.println(colors);
		//, 로 분리를 하고 싶을 경우
		String[]a1 = colors.split(",");
		System.out.println("분리된 배열의 갯수 : "+a1.length);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
