package com.quan.springboot06security.controller;

        import com.quan.springboot06security.domain.ResponseResult;
        import com.quan.springboot06security.domain.User;
        import com.quan.springboot06security.service.LoginService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginController
 * @Description: 自定义登录接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/17 16:44
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        // 登录
        return loginService.login(user);
    }
}
