package com.quan.springboot06security.expression;

import com.quan.springboot06security.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: QuanExpressionRoot
 * @Description: 自定义权限校验类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/22 14:14
 */

@Component("ex")  // 指定这个bean的名字
public class QuanExpressionRoot {

    public boolean hasAuthority(String authority) {
        // 1. 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 获取权限集合
        List<String> permissions = loginUser.getPermissions();

        System.out.println("QuanExpressionRoot doing......");

        // 2. 判断用户权限集合中是否存在传进来的authority
        return permissions.contains(authority);
    }
}
