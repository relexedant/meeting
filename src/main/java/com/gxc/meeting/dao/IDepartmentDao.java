package com.gxc.meeting.dao;

import com.gxc.meeting.domain.Department;

import java.util.List;

public interface IDepartmentDao {


     Department getDepByName(String department);

    List<Department> getAll();

    void adddep(String department);

    void deleteDep(int depid);
}
