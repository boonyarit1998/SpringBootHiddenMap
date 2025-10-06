package com.api.hiddenMap.controller;

import com.api.hiddenMap.entity.UserEntity;
import com.api.hiddenMap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public UserEntity  registerUser(@RequestBody UserEntity user){
       return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String  loginUser(@RequestBody UserEntity user){
        UserEntity login = userService.findByEmail(user.getEmail());
        return "token";
    }
}
