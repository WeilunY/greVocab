package com.wy.gre_vocab.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int checkExist(String username);

    int createNewUser(@Param("username") String username, @Param("password") String password);
}
