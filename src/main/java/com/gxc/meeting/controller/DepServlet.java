package com.gxc.meeting.controller;

import com.gxc.meeting.domain.Department;
import com.gxc.meeting.service.impl.DepartmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DepServlet {


    @Autowired
    private DepartmentImpl departmentImpl;


    @RequestMapping("/departments")
    public String department(Model model) {
        List<Department> allDep = departmentImpl.getAllDep();
        model.addAttribute("deps", allDep);
        System.out.println("DepServlet+departments:" + allDep);
        return "departments";
    }

    @RequestMapping("/adddep")
    public String adddep(String department) {

        departmentImpl.adddep(department);
        System.out.println("DepServlet+adddep:");
        return "redirect:/admin/departments";
    }

    //    /admin/deleteDep?depid=
    @RequestMapping("/deleteDep")
    public String deleteDep(int depid) {

        departmentImpl.deleteDep(depid);
        System.out.println("DepServlet+deleteDep:");
        return "redirect:/admin/departments";
    }


}
