package com.nullen.dsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nullen.dsdemo.entity.User;
import com.nullen.dsdemo.mapper.UserMapper;
import com.nullen.dsdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
