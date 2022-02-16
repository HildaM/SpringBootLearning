package com.quan.springboot06security;

import com.quan.springboot06security.domain.User;
import com.quan.springboot06security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringBoot06SecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 1. 加密
        String encode1 = encoder.encode("1234");
        String encode2 = encoder.encode("1234");

        // 在加密的时候，使用了加密盐，即使明文一样，生成的密文也不一样
        System.out.println(encode1);
        System.out.println(encode2);


            System.out.println();
        // 2. 校验
        boolean matches = encoder.matches("1234", "$2a$10$dZ0h1UO/XSX1E2RovZYoT.4K6m2aiTNJnoV7IkvewpYqZ2xTxG7cW");
        System.out.println(matches);
    }
}
