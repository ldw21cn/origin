package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }
}
