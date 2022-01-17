package com.quan.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName: TestController
 * @Description: 测试 Thtmeleaf
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 10:07
 */

@Controller
public class TestController {
    @RequestMapping("/t1")
    public String test1() {
        // classpath:/templates/test.html
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(Model model) {
        // 存入数据
        model.addAttribute("msg", "hello, Thymeleaf");
        // 返回
        return "test";
    }

    @RequestMapping("/t3")
    public String test3(Map<String, Object> map) {
        // 存入数据
        map.put("msg", "<h1>Hello</h1>");
        map.put("users", Arrays.asList("quan", "hilda"));

        return "test2";
    }

}
