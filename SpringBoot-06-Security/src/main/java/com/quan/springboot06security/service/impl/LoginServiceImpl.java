package com.quan.springboot06security.service.impl;

import com.quan.springboot06security.domain.LoginUser;
import com.quan.springboot06security.domain.ResponseResult;
import com.quan.springboot06security.domain.User;
import com.quan.springboot06security.service.LoginService;
import com.quan.springboot06security.utils.JwtUtil;
import com.quan.springboot06security.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @ClassName: LoginServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/17 16:48
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        // 1. 获取AuthenticationManager的authenticate方法进行验证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate))
            throw new RuntimeException("登录失败");

        // 如果认证通过，使用userid生成jwt，jwt存入ResponceResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);


        // 2. 使返回的body中有：token：jwt 的键值对
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("token", jwt);


        // 3. 把完整的用户信息存入redis
        redisCache.setCacheObject("login:"+userId, loginUser);

        return new ResponseResult(200, "登录成功", map);
    }
}
