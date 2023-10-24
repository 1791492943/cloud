package com.sso.mapper;

import com.feign.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    User login(@Param("username") String username, @Param("password") String password);

}
