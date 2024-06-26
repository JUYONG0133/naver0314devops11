package day0315;

public class Ex10_Operator {

	public static void main(String[] args) {
		//증감연산자
		//전치일경우는 1순위, 후치일경우는 끝 순위
		//단 단항일경우 상관없음
		
		//증감연산자이거나 대입연산자는 초기값이 들어가있어야함
		
		int m=5, n=5;
		int a=10, b=10;
		
		
		m++;
		++n;
		
		
		System.out.println("m = "+m);//6
		System.out.println("n = "+n);//6
		
		a += m++; // a= a+m; m=m+1;
		System.out.println("a = "+a);		//a = a(10)+m(6)
		System.out.println("m = "+m);		
		
		b += ++n; //n=n+1; b=b+n;
		System.out.println("b = "+b);		//n(6)+1 + b(10)
		System.out.println("n = "+n);
		// a와 b, m과 n은 서로 같은 값으로 변수 선언해주었지만 대입 연산자의 위치로 값이 변함
		
		m=5;
		System.out.println(m++);
		n=5;
		System.out.println(++n);
		System.out.println("m = "+m+" n = "+n);
	}

}
