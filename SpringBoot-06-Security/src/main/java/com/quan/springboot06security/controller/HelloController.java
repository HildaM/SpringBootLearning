package com.quan.springboot06security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/16 15:35
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")   // 注意不要使用两个双引号！！！
    public String hello() {
        return "hello";
    }
}
