package com.nullen.dsdemo.controller;

import com.fd.web.response.Result;
import com.nullen.dsdemo.entity.User;
import com.nullen.dsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result<List<User>> getAllUserList() {
        return Result.ok(userService.list());
    }

}
