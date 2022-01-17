package com.quan.springboot04webproject.dao;

import com.quan.springboot04webproject.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: 用户列表
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 16:53
 */

@Component
public class UserDao {
    private static List<User> userList = null;

    static {
        userList = new ArrayList<>();

        userList.add(new User("quan", "123456"));
        userList.add(new User("test", "123"));
    }

    // 验证用户
    public boolean checkUser(User user) {
        if (userList.contains(user)) return true;
        return false;
    }
}
