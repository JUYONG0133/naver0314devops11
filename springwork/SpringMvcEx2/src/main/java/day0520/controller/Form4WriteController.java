package day0520.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Form4WriteController {

    @PostMapping("/read4")
    public String read4(
            /*
            폼 태그의 name 이 key 값으로 , 입력값이 value 값으로 들어온다.
             */
            @RequestParam Map <String,String> map,
            Model model

            ){
        model.addAttribute("fname",map.get("foodname"));
        model.addAttribute("fphoto",map.get("foodphoto"));
        model.addAttribute("fprice",map.get("price"));
        model.addAttribute("fcnt",map.get("cnt"));

        return "form4/result4";
    }
}
