package com.gxc.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingroomController {
    @RequestMapping("/meetingrooms")
    public String meetingrooms(){

        return "meetingrooms";
    }
}
