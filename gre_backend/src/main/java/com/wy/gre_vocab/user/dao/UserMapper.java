package com.wy.gre_vocab.user.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int checkExist(String username);

    int createNewUser(String username, String password);
}
