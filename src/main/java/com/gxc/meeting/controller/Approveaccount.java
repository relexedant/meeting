package com.gxc.meeting.controller;

import com.gxc.meeting.domain.Employee;
import com.gxc.meeting.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Approveaccount {


    @Autowired
    EmpService empService;
    @RequestMapping("/approveaccount")
    public String approveaccount(Model model){
        List<Employee> list0 = empService.getAllByStatus();


        model.addAttribute("list0",list0);
        return "approveaccount";
    }
//    /admin/updatestatus?employeeid=${e.employeeid}&status=1"

    @RequestMapping("/updatestatus")
    public String updatestatus(int employeeid ,int status){
        int res = empService.updatestatus(employeeid,status);

        return "redirect:/admin/approveaccount";
    }
}
