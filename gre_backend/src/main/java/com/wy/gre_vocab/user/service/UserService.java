package com.wy.gre_vocab.user.service;

import com.wy.gre_vocab.user.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int createNewUser(String username, String password){

        // check exist
        if (userMapper.checkExist(username) > 0){
            return 0;
        } else {
            // return 1 if success
            return userMapper.createNewUser(username, password);
        }
    }
}
