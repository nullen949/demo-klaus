package com.nullen.demo.helloworld.util;

import com.nullen.demo.helloworld.controller.HelloWorldController;

/**
 * @author Nullen
 */
public class TestUtil {

    public static String testBeanUtil() {
        return HelloWorldBeanUtil.getBean(HelloWorldController.class).toString();
    }
}
