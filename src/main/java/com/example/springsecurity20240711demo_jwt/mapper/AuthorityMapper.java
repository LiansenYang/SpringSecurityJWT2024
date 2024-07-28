package com.example.springsecurity20240711demo_jwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity20240711demo_jwt.model.Authority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {
}
