package member.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberUpdateController {

    @NonNull
    private MemberService memberService;

    @GetMapping("/member/update")
    public String form(@RequestParam int num, Model model){

        MemberDto dto = memberService.getData(num);
        model.addAttribute("dto",dto);
        return "member/updateform";
    }
    @PostMapping("/member/update1")
    public String update(
            int num,
            String name,
            String hp,
            String addr,
            String email,
            String birthday
    ){
        MemberDto dto = new MemberDto();
        dto.setHp(hp);
        dto.setName(name);
        dto.setAddr(addr);
        dto.setEmail(email);
        dto.setBirthday(birthday);
        dto.setNum(num);
        memberService.updateMember(dto);

        return "redirect:./detail?num="+num;
    }
    @ResponseBody
    @GetMapping("/member/delete")
    private Map<String, String> delete(
            @RequestParam int num,
            @RequestParam String passwd
    ){
        Map<String, String> map = new HashMap<>();
        boolean b = memberService.isEqualPassCheck(num,passwd);
        if(b){
            memberService.deleteMember(num);
        }
        map.put("status",b?"success":"fail");
        return map;
    }

}
