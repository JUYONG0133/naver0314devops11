package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class MemberFormController {

    @Autowired
    private MemberService memberService;
    private String bucketName = "bitcamp-bucket-56";
    private String folderName = "photocommon";

    @Autowired
    private NcpObjectStorageService storageService;

    @GetMapping("/member/form")
    public String form()
    {
        return "member/memberform";
    }

    @ResponseBody  //json 으로 반환
    @GetMapping("/member/idcheck")
    public Map<String, Integer> getIdCheck(
            @RequestParam String searchid)
    {
        Map<String, Integer> map=new HashMap<>();
        int count=memberService.getIdCheckCount(searchid);
        map.put("count", count);
        return map;
    }

    @PostMapping("/member/insert")
    public String saveData(@ModelAttribute MemberDto dto,
                           @RequestParam("myfile")MultipartFile myfile,
                           HttpServletRequest request
                           ){
//        // 업로드 될경로
//        String savePath = request.getSession().getServletContext().getRealPath("/save");
//        //업로드한 파일 확장자 분리
//        String ext = myfile.getOriginalFilename().split("\\.")[1];
//        //업로드할파일명
//        String photo = UUID.randomUUID()+"."+ext;
//        dto.setPhoto(photo);
//        //실제업로드
//        try {
//            myfile.transferTo(new File(savePath+"/"+photo));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //스토리지에 업로드하기
        String photo = storageService.uploadFile(bucketName,folderName,myfile);
        dto.setPhoto(photo);

        //db에 저장
        memberService.insertMember(dto);




        return "redirect:./list";
    }

}
