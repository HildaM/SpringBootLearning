package com.quan.springboot06security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.quan.springboot06security.domain.LoginUser;
import com.quan.springboot06security.domain.User;
import com.quan.springboot06security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName: UserDetailsServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/16 17:31
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 双冒号（::）运算符在Java 8中被用作方法引用（method reference）
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);
        // 如果没有查询到用户，抛出异常
        if (Objects.isNull(user))
            throw new RuntimeException("用户名或密码错误");  // 会被ExceptionTranslationFilter捕获到！


        // 2. 查询对应的权限信息


        // 3. 封装成UserDetails返回
        return new LoginUser(user);
    }
}
