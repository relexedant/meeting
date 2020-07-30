package com.gxc.meeting.service;

import com.gxc.meeting.dao.IMeetingroomDao;
import com.gxc.meeting.domain.Meetingroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingroomService {
    @Autowired
    IMeetingroomDao iMeetingroomDao;


    public List<Meetingroom> getAll() {
       return iMeetingroomDao.getAll();
    }

    public Meetingroom getMeetingRoom(int roomid) {
       return iMeetingroomDao.getMeetingRoom(roomid);
    }

    public void updatemeetingroom(Meetingroom meetingroom) {
        System.out.println("业务层：updatemeetingroom"+meetingroom);
        iMeetingroomDao.updatemeetingroom(meetingroom);
    }

    public void addmr(Meetingroom meetingroom) {
        iMeetingroomDao.addmr(meetingroom);
    }

    public List<Meetingroom> getAllMr() {
        return iMeetingroomDao.getAll();
    }
}
