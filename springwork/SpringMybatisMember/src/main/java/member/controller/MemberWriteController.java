package member.controller;

import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberWriteController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/form")
    public String form(){
        return "member/writeform";
    }

    @ResponseBody
    @GetMapping("/idcheck")
    public Map<String,Integer> searchId(
            @RequestParam String searchid

    ){

        Map<String, Integer> map = new HashMap<>();
        int count=memberService.getSearchId(searchid);
        map.put("count",count);

        return map;
    }

    @PostMapping("/insert")
    public String insert(
            @ModelAttribute MemberDto dto,
            @RequestParam("myfile") MultipartFile myfile,
            HttpServletRequest request
            ){
        String uploadPath = request.getSession().getServletContext().getRealPath("/resources");
        System.out.println(uploadPath);

        String photo = myfile.getOriginalFilename();
        dto.setPhoto(photo);

        try {
            myfile.transferTo(new File(uploadPath+"/"+photo));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        memberService.insertMember(dto);

        return "redirect:./list";
    }
}
