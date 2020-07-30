package com.gxc.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationsServlet {

    @GetMapping("/notifications")
    public String notifications(){
        return "notifications";
    }
}
