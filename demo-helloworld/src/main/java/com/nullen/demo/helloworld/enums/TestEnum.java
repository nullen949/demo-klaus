package com.nullen.demo.helloworld.enums;

import lombok.Getter;

/**
 * @author Nullen
 */
@Getter
public enum TestEnum {

    /**
     * 分钟
     */
    MINUTE(0),

    /**
     * 小时
     */
    HOUR(1),

    /**
     * 日
     */
    DAY(2);


    private final Integer value;

    TestEnum(Integer value) {
        this.value = value;
    }
}