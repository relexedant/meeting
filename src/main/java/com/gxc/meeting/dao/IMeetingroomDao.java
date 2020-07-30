package com.gxc.meeting.dao;


import com.gxc.meeting.domain.Meetingroom;

import java.util.List;

public interface IMeetingroomDao {


    List<Meetingroom> getAll();

    Meetingroom getMeetingRoom(int roomid);

    void updatemeetingroom(Meetingroom meetingroom);

    void addmr(Meetingroom meetingroom);
}
