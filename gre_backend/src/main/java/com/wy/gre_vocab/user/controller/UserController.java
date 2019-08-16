package com.wy.gre_vocab.user.controller;

import com.wy.gre_vocab.common.Result;

import com.wy.gre_vocab.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // create a new user
    @PostMapping("/createUser")
    public Result createNewUser(@RequestBody @NotNull Map<String, String> user){

        String username = user.get("username");
        String password = user.get("password");

        int status = userService.createNewUser(username, password);
        if ( status == 0){
            return Result.error("USER EXIST");
        }

        return Result.success("USER CREATED");


    }


}
