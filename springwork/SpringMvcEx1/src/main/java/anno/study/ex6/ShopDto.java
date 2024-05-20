package anno.study.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ShopDto {

    private String sang;
    private int su;
    private int dan;

}
