package com.quan.springboot04webproject.dao;

import com.quan.springboot04webproject.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DepartmentDao
 * @Description:    部门dao
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 14:03
 */

@Repository
public class DepartmentDao {
    // 初始化数据
    private static Map<Integer, Department> departmentMap = null;

    // 初始化代码块
    static {
        departmentMap = new HashMap<Integer, Department>(); // 创建部门表
        // 模拟数据库初始化数据
        departmentMap.put(101, new Department(101, "q部"));
        departmentMap.put(102, new Department(102, "a部"));
        departmentMap.put(103, new Department(103, "b部"));
        departmentMap.put(104, new Department(104, "c部"));
        departmentMap.put(105, new Department(105, "d部"));
        departmentMap.put(106, new Department(106, "e部"));
    }

    // 获得所有部门信息
    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    // 通过id获得指定部门
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }

    //
}
