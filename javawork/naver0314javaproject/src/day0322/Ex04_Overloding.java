package day0322;


class Oper{
	//메소드 오버로딩 //메소드 이름은 같은데 인자값이 다름;
	static public int sum(int a, int b) {
		return a+b;
	}
	static public double sum(double a, double b) {
		return a+b;
	}
	static public String sum(String a, String b) {
		return a+b;
	}
	
	//Variable Argument
	static public int hap(int ...n) { //개수제한없이 인자로 받을 수 있다.
		System.out.println("전달 받은 숫자의 개수 : "+n.length);
		int s = 0;
		for(int i = 0; i < n.length; i++) {
			System.out.printf("%4d",n[i]);
			s+=n[i];
		}
		System.out.println();
		return s;
	}
	
	public static void writeColor(String ...color) {
		System.out.println("총 "+(color.length)+" 개의 색상 전달 받음");
		for(int i =0 ; i < color.length; i++) {
			System.out.println((i+1)+" : "+color[i]);
		}
		System.out.println("=".repeat(10));
	}
	
	
}
public class Ex04_Overloding {

	public static void main(String[] args) {
		System.out.println(Oper.sum(5, 100));
		System.out.println(Oper.sum(5.6, 1.20));
		System.out.println(Oper.sum("apple","banana" ));
		
		System.out.println("총 합계 : "+Oper.hap(3,6,8));
		System.out.println("총 합계 : "+Oper.hap(33552326,634254241,222222231));
		Oper.writeColor("red");
		Oper.writeColor("yellow","gray","blue");
		Oper.writeColor("빨","주","노","초");
	}

}
