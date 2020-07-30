package com.gxc.meeting.controller;

import com.gxc.meeting.domain.Meetingroom;
import com.gxc.meeting.service.MeetingroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingroomController {

@Autowired
    MeetingroomService meetingroomService;

    @RequestMapping("/meetingrooms")
    public String meetingrooms(Model model){

        model.addAttribute("rooms",meetingroomService.getAll());
        return "meetingrooms";
    }

    @RequestMapping("/roomdetails")
    public String roomdetails(int roomid,Model model){
        Meetingroom meetingroom = meetingroomService.getMeetingRoom(roomid);
        model.addAttribute("meetingroom",meetingroom);
        return "roomdetails";
    }
}
