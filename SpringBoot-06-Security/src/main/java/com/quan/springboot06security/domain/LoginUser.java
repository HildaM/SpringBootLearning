package com.quan.springboot06security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ClassName: LoginUser
 * @Description: 实现UserDetails
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/16 17:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {

    // 其实也可让User类直接实现UserDetails
    private User user;

    // 返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }


    // 判断是否没有过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
