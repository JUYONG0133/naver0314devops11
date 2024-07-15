package bit.mycar.controller;

import bit.mycar.data.MycarDto;
import bit.mycar.service.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyCarListController {
    final MyCarService myCarService;
    final NcpObjectStorageService storageService;


    String bucketName = "bitcamp-bucket132";
    String folderName = "mycar";


    @GetMapping("/mycar/list")
    public List<MycarDto> list(){
        return myCarService.getAllDatas();
    }


}