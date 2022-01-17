package com.quan.springboot04webproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @ClassName: User
 * @Description: 用户
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/17 16:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
