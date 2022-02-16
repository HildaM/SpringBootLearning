package com.quan.springboot06security.controller;

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
    public String hello() {
        return "hello";
    }
}
