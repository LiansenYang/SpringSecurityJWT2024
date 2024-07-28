package com.example.springsecurity20240711demo_jwt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecurity20240711demo_jwt.mapper.AuthorityMapper;
import com.example.springsecurity20240711demo_jwt.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    public List<Authority> findByUsername(String username) {
        return authorityMapper.selectList(new QueryWrapper<Authority>().eq("username", username));
    }
}
