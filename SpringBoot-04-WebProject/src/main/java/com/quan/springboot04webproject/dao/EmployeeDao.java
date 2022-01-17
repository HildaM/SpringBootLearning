package com.quan.springboot04webproject.dao;

import com.quan.springboot04webproject.pojo.Department;
import com.quan.springboot04webproject.pojo.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: EmployeeDao
 * @Description: 员工dao
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 14:09
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;
    // 员工所属部门
    @Autowired
    private static DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<>();

        employeeMap.put(1, new Employee(1, "Quan", "163@.com", 1, new Department(106, "e部")));
        employeeMap.put(2, new Employee(2, "Quan2", "163@.com", 1, new Department(101, "q部")));
        employeeMap.put(3, new Employee(3, "Quan3", "163@.com", 1, new Department(102, "a部")));
        employeeMap.put(4, new Employee(4, "Quan4", "163@.com", 1, new Department(103, "b部")));
        employeeMap.put(5, new Employee(5, "Quan5", "163@.com", 1, new Department(104, "c部")));
        employeeMap.put(6, new Employee(6, "Quan6", "163@.com", 1, new Department(105, "d部")));
    }

    // 获取所有员工信息
    public Collection<Employee> getEmployee() {
        return employeeMap.values();
    }

    // 根据id获取
    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    // 删除员工
    private int deleteEmployById(Integer id) {
        employeeMap.remove(id);
        return 1;
    }

    // 主键自增
    private static Integer initId = 6;
    // 增加一个员工
    public int add(Employee e) {
        if (e.getId() == null) e.setId(++initId);

        e.setDepartment(departmentDao.getDepartmentById(e.getDepartment().getId()));  //????????
        // if (e != null && departmentDao != null) e.setDepartment(departmentDao.getDepartmentById(1));    // 我自己直接生成一个随机的好了

        employeeMap.put(e.getId(), e);

        return 1;
    }



    @Test
    public void test() {
        Collection<Employee> list = getEmployee();
        for (Employee e : list) {
            System.out.println(e);
        }

        Employee e = new Employee();
        this.add(e);

        System.out.println(employeeMap.get(7));
    }
}
