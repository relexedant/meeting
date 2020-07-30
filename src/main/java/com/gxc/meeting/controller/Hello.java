package com.gxc.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello","hello boy");
        System.out.println(":hello");
        return  "hello";
    }
}
