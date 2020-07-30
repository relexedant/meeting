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
}
