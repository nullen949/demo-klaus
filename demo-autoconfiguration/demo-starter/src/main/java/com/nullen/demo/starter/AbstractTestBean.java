package com.nullen.demo.starter;

import javax.annotation.PostConstruct;

/**
 * @author Nullen
 */
public abstract class AbstractTestBean {

    @PostConstruct
    void init() {
        System.out.println("Bean初始化: " + getName());
    }

    public String getName() {
        return "Starter模块 " + this.getClass().getSimpleName();
    }
}
