package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component //canadaTire 가 등록이된다.
public class CanadaTire implements Tire{
    @Override
    public String getTireName() {
        return "캐나다타이어";
    }
}
