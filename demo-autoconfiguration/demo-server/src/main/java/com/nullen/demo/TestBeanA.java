package com.nullen.demo;

import com.nullen.demo.starter.AbstractTestBean;
import org.springframework.stereotype.Component;

/**
 * @author Nullen
 */
@Component
public class TestBeanA extends AbstractTestBean {

    @Override
    public String getName() {
        return "Server模块 " + super.getName();
    }
}
