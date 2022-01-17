package com.quan.springboot04webproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Department
 * @Description: 部门类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 13:58
 */

// 部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;

}
