package com.gxc.meeting.service;

import com.gxc.meeting.dao.IEmpDao;
import com.gxc.meeting.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    IEmpDao iEmpDao;

    public int doReg(Employee employee) {

        Employee e = iEmpDao.getEmpByUsername(employee.getUsername());
        if (e != null) {
            return -1;
        }
        employee.setRole("1");
        employee.setStatus("0");
        int res = iEmpDao.doReg(employee);
        return res;
    }

    public Employee doLogin(String username, String password) {
        Employee e = iEmpDao.getEmpByUsername(username);

        if (e == null || (!e.getPassword().equals(password))) {
            return null;
        }
        return e;
    }

    public List<Employee> getAllByStatus() {
        return iEmpDao.getAllByStatus();
    }

    public int updatestatus(int employeeid, int status) {


        return iEmpDao.updatestatus(employeeid, status);


    }

    public List<Employee> getAllEmpByif(Employee employee, int page, int pageSize) {
        page = (page-1)*pageSize;

        return iEmpDao.getAllEmpByif(employee,page,pageSize);
    }

    public Long getTotal(Employee employee) {
        return iEmpDao.getTotal(employee);
    }
}
