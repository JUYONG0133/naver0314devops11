package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {

    @GetMapping("/read1")
    public String read1(
                        //form태그의 name과 읽어올 name이 같다면
                        //@RequestParam String name, 으로 쓸수있음
                        //@RequestParam 도 생략가능
                        //String name 으로 쓸수 있음
                        @RequestParam("name") String name,
                        @RequestParam("addr") String addr,
                        @RequestParam("age") int age,
                        Model model
                        ){
        model.addAttribute("name",name);
        model.addAttribute("addr",addr);
        model.addAttribute("age",age);
        model.addAttribute("info",age>=20?"성인입니다.":"미성년자입니다");
        return "form1/result1";
    }
}
