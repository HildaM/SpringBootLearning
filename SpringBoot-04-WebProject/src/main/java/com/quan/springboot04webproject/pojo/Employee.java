package com.quan.springboot04webproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: Employee
 * @Description: 员工表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 14:00
 */
// 员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;  // 0:woman 1:man

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
