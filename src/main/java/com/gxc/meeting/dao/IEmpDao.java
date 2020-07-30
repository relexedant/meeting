package com.gxc.meeting.dao;

import com.gxc.meeting.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmpDao {



    List<Employee> getAll();

    Employee getEmpByUsername(String username);

    int doReg(Employee employee);

    List<Employee> getAllByStatus();

    int updatestatus(@Param("employeeid") int employeeid,@Param("status") int status);

    List<Employee> getAllEmpByif(@Param("emp")Employee employee, @Param("page") int page, @Param("pageSize") int pageSize);

    List<Employee> getAllEmpByif2(@Param("emp")Employee employee);

    Long getTotal(Employee employee);
}
