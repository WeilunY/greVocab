package com.wy.gre_vocab.user.dao;

import com.wy.gre_vocab.user.entity.User;
import com.wy.gre_vocab.user.entity.UserSafe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int checkExist(String email);

    int checkExistId(int id);

    int createNewUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);

    UserSafe getUser(int id);

    int updateUser(User user);
}
