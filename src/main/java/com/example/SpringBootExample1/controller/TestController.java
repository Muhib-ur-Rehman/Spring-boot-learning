package com.example.SpringBootExample1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String testing(){
        System.out.println("here");
        return "home";
    }
}
