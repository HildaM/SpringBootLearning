package com.quan.springboot04webproject.controller;

import com.quan.springboot04webproject.dao.UserDao;
import com.quan.springboot04webproject.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description: 登录模块
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 16:35
 */

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;

    // 登录验证
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

        if (username != null && username.length() > 0) {
            User user = new User(username, password);

            if (userDao.checkUser(user)) {
                model.addAttribute("msg", "登录成功");
                // 写入登录成功的用户的session
                session.setAttribute("loginUser", username);
                return "redirect:/dashboard";
            }

        }

        model.addAttribute("msg", "用户名或密码错误");
        return "index";
    }
}
