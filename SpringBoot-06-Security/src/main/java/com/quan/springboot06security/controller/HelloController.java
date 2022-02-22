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
    //@PreAuthorize("hasAuthority('system:test:list')")   // 注意不要使用两个双引号！！！
    @PreAuthorize("@ex.hasAuthority('system:test:list')") // @：可以获取指定名称的bean（spel表达式）
    public String hello() {
        return "hello";
    }

    @RequestMapping("/testConfig")
    public String testConfig() {
        return "testConfig";
    }
}
