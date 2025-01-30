package com.nullen.dsdemo.controller;

import cn.hutool.json.JSONUtil;
import com.nullen.dsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nullen
 */
@RestController
public class TempUserController {

    @Autowired
    private UserService userService;

    @GetMapping("tempUser")
    public String get() {
        return JSONUtil.toJsonStr(userService.list());
    }
}
