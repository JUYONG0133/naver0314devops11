package day0520.controller;


import day0520.dto.FoodDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form3WriteController {

    @PostMapping("/read3")
    public String read3(

            @ModelAttribute FoodDto dto //폼태크에서 같은 이름을 자동으로 읽어온다.
            ){

        return "form3/result3";
    }
}
