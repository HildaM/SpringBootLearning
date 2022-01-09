package com.quan.hellospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/9 16:03
 */

@RestController
public class HelloController {

    // 接口：localhost:8080/hello
    @RequestMapping("/hello")
    public String hello() {
        // 调用业务，接受前端参数
        return "hello world";
    }
}
