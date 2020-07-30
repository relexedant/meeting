package com.gxc.meeting.controller;

import com.github.pagehelper.PageInfo;
import com.gxc.meeting.domain.Employee;
import com.gxc.meeting.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmpController {

    private final static int PAGE_SIZE=10;

    @Autowired
    EmpService empService;
//    @RequestMapping("/searchemployees") //原始分页
    public String EmpController(Employee employee, @RequestParam(defaultValue="1") int page, Model model){
        System.out.println("EmpController+searchemployees+employee"+employee);
        List<Employee> list = empService.getAllEmpByif(employee,page,PAGE_SIZE);

        Long total  = empService.getTotal(employee);

        model.addAttribute("list1",list);
        model.addAttribute("total",total);
        model.addAttribute("pageNum",total%PAGE_SIZE==0?total/PAGE_SIZE:total/PAGE_SIZE+1);
        model.addAttribute("page",page);

        return "searchemployees";


    }


    @RequestMapping("/searchemployees")
    public String getAllEmpByPage(Employee employee, @RequestParam(defaultValue="1") int page,
                                  @RequestParam(defaultValue="10")int pageSize, Model model){
        System.out.println("EmpController+searchemployees+employee:所要筛选的员工类型"+employee);

        Long total  = empService.getTotal(employee);
        int pagex =(int)( total%PAGE_SIZE==0?total/PAGE_SIZE:total/PAGE_SIZE+1);
        page = page>pagex?pagex:page;

        PageInfo<Employee> pageInfo = empService.getAllEmpByif2(employee,page,PAGE_SIZE);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("total",total);
        model.addAttribute("pageNum", pagex);
//        model.addAttribute("page",page);



        return "searchemployees2";


    }
}
