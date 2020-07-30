package com.gxc.meeting.controller;

import com.gxc.meeting.domain.Department;
import com.gxc.meeting.domain.Employee;
import com.gxc.meeting.service.EmpService;
import com.gxc.meeting.service.impl.DepartmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DepartmentImpl departmentImpl;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession session) {
        Employee employee = empService.doLogin(username, password);
        if (employee == null) {
            model.addAttribute("error", "用户不存在");
            return "forward:/";

        } else {
            if (employee.getStatus().equals("0")) {
                model.addAttribute("error", "用户未审批");
                return "forward:/";

            } else if (employee.getStatus().equals("2")) {
                model.addAttribute("error", "用户审批未通过");
                return "forward:/";

            } else {
                session.setAttribute("currentuser", employee);
                return "redirect:/notifications";
            }
        }
    }

    @RequestMapping("/register")
    public String register(Model model) {
        System.out.println("LoginController.doRegister");
        List<Department> deps = departmentImpl.getAll();
        model.addAttribute("deps", deps);
        return "register";
    }

    @RequestMapping("/doReg")
    public String doReg(Employee employee, Model model) {
        int res = empService.doReg(employee);
        if (res == 1) {
            return "redirect:/";
        } else {
            model.addAttribute("employee", employee);
            return "forward:/register";
        }

    }
}
