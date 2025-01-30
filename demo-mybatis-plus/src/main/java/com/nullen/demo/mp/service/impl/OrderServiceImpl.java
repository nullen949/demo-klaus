package com.nullen.demo.mp.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.toolkit.MPJWrappers;
import com.nullen.demo.comm.entity.User;
import com.nullen.demo.mp.entity.Order;
import com.nullen.demo.mp.entity.TestEntityA;
import com.nullen.demo.mp.entity.TestEntityB;
import com.nullen.demo.mp.mapper.OrderMapper;
import com.nullen.demo.mp.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author Nullen
 */
@Service
public class OrderServiceImpl extends MPJBaseServiceImpl<OrderMapper, Order> implements OrderService {


    public void test() {
        MPJWrappers.lambdaJoin(Order.class)
                .leftJoin(User.class, User::getId, Order::getId)
                .leftJoin(TestEntityA.class, TestEntityA::getName, TestEntityB::getName);
    }
}
