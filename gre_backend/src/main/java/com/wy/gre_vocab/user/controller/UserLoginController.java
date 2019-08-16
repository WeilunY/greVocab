package com.wy.gre_vocab.user.controller;

import com.wy.gre_vocab.common.Result;
import com.wy.gre_vocab.user.service.UserLoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Resource
    UserLoginService userLoginService;

    // verify info and return user_id
    @RequestMapping("/verify")
    public Result verifyLogin(@RequestBody @NotNull Map<String, String> user) {

        String username = user.get("username");
        String password = user.get("password");

        int status = userLoginService.verifyUser(username, password);

        if (status == -1){
            return Result.error("WRONG INFO");
        } else {
            return Result.success(status);
        }

    }
}