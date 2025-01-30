package com.nullen.demo.test;

import cn.hutool.core.thread.threadlocal.NamedInheritableThreadLocal;

/**
 * @author Nullen
 */
public class TestContextHolder {

    public static final ThreadLocal<String> NAME = new NamedInheritableThreadLocal<>("Name");

    public static String getName() {
        return NAME.get();
    }

    public static void setName(String name) {
        NAME.set(name);
    }
}
