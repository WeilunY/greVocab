package com.wy.gre_vocab.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper {

    int verifyUser(@Param("username") String username, @Param("password") String password);

    int getID(@Param("username") String username, @Param("password") String password);
}
