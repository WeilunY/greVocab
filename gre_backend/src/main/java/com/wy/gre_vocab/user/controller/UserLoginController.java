package com.wy.gre_vocab.user.controller;

import com.wy.gre_vocab.common.Result;
import com.wy.gre_vocab.user.service.UserLoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Resource
    UserLoginService userLoginService;

    // verify info and return user_id
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/verify")
    public Result verifyLogin(@RequestBody @NotNull Map<String, String> user) {

        String email= user.get("email");
        String password = user.get("password");

        int status = userLoginService.verifyUser(email, password);

        if (status == -1){
            return Result.error("WRONG INFO");
        } else {
            return Result.success(status);
        }

    }
}
