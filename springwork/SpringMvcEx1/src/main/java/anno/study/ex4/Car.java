//package anno.study.ex4;
////xml 방식
//public class Car {
//    private String carName;
//    private Tire tire;
//
//    public Car(Tire tire) {
//        this.tire = tire;
//    }
//
//    public void setCarName(String carName) {
//        this.carName = carName;
//    }
//
//    public void carInfo(){
//        System.out.println("자동차명 : "+carName);
//        System.out.println("타이어 : "+tire.getTireName());
//    }
//}

package anno.study.ex4;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

////annotation 방식
//@Component
//public class Car {
//    @Value("Audi")
//    private String carName;
//
//    @Autowired
//    private KoreaTire tire;     //  정확하게 클래스명으로 선언을 해야만 오류가 발생하지않는다.
//    //Hello class가 가진 메소드입니다.
//    //자동차명 : Audi
//    //타이어 : 한국타이어
//    // 만일 타이어를 캐나다타이어로 주고싶다면
//    //private CanadaTire tire;로 하면된다
//
//
//
//    public void carInfo(){
//        System.out.println("자동차명 : "+carName);
//        System.out.println("타이어 : "+tire.getTireName());
//    }
//}
//tire를 lombok를 이용한 방식
@Component
@RequiredArgsConstructor //@NonNull이 붙은 멤버변수만 생성자로 주입된다.
public class Car {
    @Value("Kia")
    private String carName;

    @NonNull
    private KoreaTire tire;




    public void carInfo(){
        System.out.println("자동차명 : "+carName);
        System.out.println("타이어 : "+tire.getTireName());
    }
}