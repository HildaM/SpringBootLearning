package com.quan.springboot06security.service;

import com.quan.springboot06security.domain.ResponseResult;
import com.quan.springboot06security.domain.User;

/**
 * @ClassName: LoginService
 * @Description: 登录接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/17 16:47
 */
public interface LoginService {

    public ResponseResult login(User user);
}
