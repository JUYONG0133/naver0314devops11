package study.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {
    public static void main(String[] args) {
        System.out.println("기본의 자바 방식으로 호출 #1");
        MessageInter m = null;
        m = new Message1();
        String s = m.sayHello("이영자");
        System.out.println(s);

        m=new Message2();
        s=m.sayHello("강호동");
        System.out.println(s);


        System.out.println("\n스프링 방식으로 호출 #2");
        ApplicationContext context = new ClassPathXmlApplicationContext("appex1.xml");

        MessageInter m1 = (Message1)context.getBean("mes1");
        s = m1.sayHello("캔디");
        System.out.println(s);
//        MessageInter m2 = (Message2)context.getBean("mes2");
//        s = m2.sayHello("123");
//        System.out.println(s);
        m1 = context.getBean("mes2",Message2.class);
        s = m1.sayHello("마이클");
        System.out.println(s);
    }
}
