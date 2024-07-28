package com.example.springsecurity20240711demo_jwt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity20240711demo_jwt.mapper.UserMapper;
import com.example.springsecurity20240711demo_jwt.model.Authority;
import com.example.springsecurity20240711demo_jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.ObjectUtils.isEmpty;
import static com.baomidou.mybatisplus.core.toolkit.ObjectUtils.isNotEmpty;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.save(user);
        return user;
    }

    public User findByUsername(String username) {
        User user = baseMapper.findByUsername(username);
        if(isEmpty(user)){
            throw new RuntimeException("用户不存在！");
        }
        List<Authority> authorities = authorityService.findByUsername(username);
        user.setAuthorities(new HashSet<>(authorities));
        return user;
    }

    public List<User> getAllUsers() {
        return this.list();
    }

    public void deleteUser(Long id) {
        this.removeById(id);
    }

    public boolean usernameExists(String username) {
        User one = this.lambdaQuery().eq(User::getUsername, username).one();
        if(isNotEmpty(one)){
            return true;
        }
        return false;
    }

}
