package com.wy.gre_vocab.user.controller;

import com.wy.gre_vocab.common.Result;

import com.wy.gre_vocab.user.entity.User;
import com.wy.gre_vocab.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    // create a new user
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/createUser")
    public Result createNewUser(@RequestBody Map<String, String> user){

        String username = user.get("username");
        String password = user.get("password");
        String email = user.get("email");

        int status = userService.createNewUser(username, password, email);
        if ( status == 0){
            return Result.error("USER EXIST");
        }

        return Result.success("USER CREATED");

    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/getUser")
    public Result getUser(@RequestBody Map<String, Integer> user) {

        int id = user.get("id");

        return Result.success(userService.getUser(id));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {

        int status = userService.updateUser(user);
        if (status == -1) {
            return Result.error();
        }
        return Result.success((status));
    }


}
