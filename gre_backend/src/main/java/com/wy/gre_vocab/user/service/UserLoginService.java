package com.wy.gre_vocab.user.service;

import com.wy.gre_vocab.user.dao.UserLoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginService {

    @Resource
    UserLoginMapper userLoginMapper;

    public int verifyUser(String email, String password){
        if (userLoginMapper.verifyUser(email, password) != 0){
            return userLoginMapper.getID(email, password);
        } else {
            return -1;
        }
    }
}
