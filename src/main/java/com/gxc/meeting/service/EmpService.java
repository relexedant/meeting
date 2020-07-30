package com.gxc.meeting.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.meeting.dao.IEmpDao;
import com.gxc.meeting.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    IEmpDao iEmpDao;

    @Autowired
    PageInfo pageInfo;

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
        page = (page - 1) * pageSize;

        return iEmpDao.getAllEmpByif(employee, page, pageSize);
    }

    /**
     * 分页功能实现数据查询
     * @param employee
     * @param page 当前页
     * @param pageSize
     * @return
     */
    public PageInfo<Employee> getAllEmpByif2(Employee employee, int page, int pageSize) {

        PageHelper.startPage(page, pageSize);
        List<Employee> allEmpByif2 = iEmpDao.getAllEmpByif2(employee);
        pageInfo.setList(allEmpByif2);
        Page pages = (Page)(pageInfo.getList());
        //  设置总行数
        pageInfo.setTotal(pages.getTotal());
        //设置有无第一页或最后一页
        if(page<2){
            pageInfo.setHasPreviousPage(false);
        }


        if(page>pages.getPages()-1){
            pageInfo.setHasNextPage(false);
        }
        //设置当前页面
        pageInfo.setPageNum(page);
        // 设置总页数
        pageInfo.setPages(pages.getPages());
        return pageInfo;
    }

    public Long getTotal(Employee employee) {
        return iEmpDao.getTotal(employee);
    }
}
