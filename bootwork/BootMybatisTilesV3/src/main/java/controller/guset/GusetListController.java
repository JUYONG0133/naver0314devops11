package controller.guset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GusetListController {


    @GetMapping("/guest/list")
    public String list(){
        return "guest/guestlist";

    }

}
