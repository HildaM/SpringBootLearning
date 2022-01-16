package com.quan.springboot03web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: 测试类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/16 16:24
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello Controller";
    }
}
