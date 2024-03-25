package day0325;

public class Student {
	private String name;
	private int java;
	private int spring;
	
	
	public Student() {
		//super();  // 부모 클래스의 디폴트 생성자 호출명렁어  평소에는 생략되어있음
		this("aaa",10,10);
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	public Student(int java, int spring) {
		super();
		this.java = java;
		this.spring = spring;
	}
	public Student(String name, int java, int spring) {
		super();
		this.name = name;
		this.java = java;
		this.spring = spring;
		
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public void setScore(int java, int spring) {
		this.java = java;
		this.spring = spring;
	}
	public int getTotal() {
		int tot=0;
		tot = java + spring;
		return tot;
	}
	public double getAverage() {
		double age=0;
		age = (java + spring) /2.0;
		return age;
	}
	public String getGrade() {
		if(getAverage()>=90.0) {
			return "장학생";
		}
		else if (getAverage()>=70.0) {
			return "우등생";
		}
		else 
			return "재시험";
	}
	
}
