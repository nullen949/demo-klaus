package com.nullen.demo.helloworld.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author Nullen
 */
@Getter
public enum TestJsonValueEnum {


    A(4),
    B(2);

    @JsonValue
    private int value;

    TestJsonValueEnum(int value) {
        this.value = value;
    }
}
