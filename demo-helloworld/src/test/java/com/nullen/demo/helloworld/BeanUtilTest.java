package com.nullen.demo.helloworld;

import cn.hutool.extra.cglib.CglibUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nullen.demo.comm.entity.User;
import com.nullen.demo.helloworld.controller.GzipController;
import com.nullen.demo.helloworld.util.TestUtil;
import com.nullen.fd.utils.BeanUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Nullen
 */

@SpringBootTest
public class BeanUtilTest {

    @Test
    void testContext() {
        System.out.println(BeanUtil.getBean(GzipController.class));
    }

    @Test
    void testStatic() {
        System.out.println(TestUtil.testBeanUtil());
    }

    @Test
    void testGetName() {
        ObjectMapper objectMapper = BeanUtil.getBean(ObjectMapper.class);
        System.out.println(objectMapper);
    }

    @Test
    void testSpringBeanUtilsCopy() {
        User user = new User();
        user.setId(1L);

        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);

        System.out.println(user);
        System.out.println(newUser);

    }


    @Test
    void testHutoolBeanUtilCopy() {
        User user = new User();
        user.setId(1L);

        User newUser = new User();
        BeanUtil.copyProperties(user, newUser);

        System.out.println(user);
        System.out.println(newUser);
    }

    @Test
    void testCgLibCopy() {
        User user = new User();
        user.setId(1L);

        User newUser = CglibUtil.copy(user, User.class);

        System.out.println(user);
        System.out.println(newUser);
    }
}
