package com.quan.springboot04webproject.controller;

import com.quan.springboot04webproject.dao.EmployeeDao;
import com.quan.springboot04webproject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @Description: 员工控制类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/18 10:20
 */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/getList")
    public String getAllEmployeeList(Model model) {
        Collection<Employee> employees = employeeDao.getEmployee();
        model.addAttribute(employees);
        return "emp/list";
    }
}
