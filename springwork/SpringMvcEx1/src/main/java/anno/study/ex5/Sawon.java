package anno.study.ex5;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
@Data

public class Sawon {

    @Value("강호동")
    private String name;
    @Value("경기성남")
    private String addr;
    @Value("23")
    private int age;


}
