package com.quan.springboot02config;

import com.quan.springboot02config.pojo.Dog;
import com.quan.springboot02config.pojo.Person;
import com.quan.springboot02config.pojo.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {
    @Autowired
    Dog dog;
    @Autowired
    Person person;
    @Autowired
    Person2 person2;

    @Test
    void contextLoads() {
        System.out.println(person.toString());
    }
}
