package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    public void showMessage(){
        System.out.println("Hello class가 가진 메소드입니다.");
    }
}
