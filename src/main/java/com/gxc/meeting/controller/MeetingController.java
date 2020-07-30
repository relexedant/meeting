package com.gxc.meeting.controller;

import com.gxc.meeting.service.MeetingroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingController {

    @Autowired
    MeetingroomService meetingroomService;

    @RequestMapping("/booking")
    public String booking(Model model){
        ;
        model.addAttribute("roomsbooking",meetingroomService.getAllMr());
        return "bookmeeting";
    }
}
