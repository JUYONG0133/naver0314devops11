package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberUpdateController {
    @NonNull
    private MemberService memberService;

    private String bucketName = "bitcamp-bucket-56";
    private String folderName = "photocommon";

    @Autowired
    private NcpObjectStorageService storageService;

    @ResponseBody
    @PostMapping("/upload")
    public Map<String,String > uploadPhoto(
            @RequestParam("upload")MultipartFile upload,
            @RequestParam int num,
            HttpServletRequest request
            ){

//        String savePath = request.getSession().getServletContext().getRealPath("/save");
//        //업로드한 파일 확장자 분리
//        String ext = upload.getOriginalFilename().split("\\.")[1];
//        //업로드할파일명
//        String photo = UUID.randomUUID()+"."+ext;
//
//        //실제업로드
//        try {
//            upload.transferTo(new File(savePath+"/"+photo));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String photo = storageService.uploadFile(bucketName,folderName,upload);



        //db에서 photo 수정
        memberService.updatePhoto(num,photo);
        Map<String, String > map = new HashMap<>();
        map.put("photoname",photo);


        return map;
    }

    @GetMapping("/update")
    public String form(@RequestParam int num, Model model){

        MemberDto dto = memberService.getData(num);
        model.addAttribute("dto",dto);
        return "member/memberupdate";

    }
    @PostMapping("/update1")
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
    @GetMapping("/delete")
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
