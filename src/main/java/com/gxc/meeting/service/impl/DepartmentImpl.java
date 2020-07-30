package com.gxc.meeting.service.impl;

import com.gxc.meeting.dao.IDepartmentDao;
import com.gxc.meeting.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl {


    @Autowired
    IDepartmentDao iDepartmentDao;

    public List<Department> getAllDep() {
        System.out.println("service:getAllDep");
        List<Department> all = iDepartmentDao.getAll();
        System.out.println(all);
        return all;
    }

    public List<Department> getAll() {
        return iDepartmentDao.getAll();
    }

    public void adddep(String department) {
        Department dep = iDepartmentDao.getDepByName(department);
        if (dep != null) {
            return;
        }
        iDepartmentDao.adddep(department);
    }

    public void deleteDep(int depid) {
        iDepartmentDao.deleteDep(depid);
    }
}
