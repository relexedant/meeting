package com.gxc.meeting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meetingroom {
    private int roomid;
    private int roomnum;
    private String roomname;
    private int capacity;
    private String status;
    private String description;


}
