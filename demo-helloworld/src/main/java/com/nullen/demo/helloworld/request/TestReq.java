package com.nullen.demo.helloworld.request;

import com.nullen.demo.helloworld.enums.TestEnum;
import com.nullen.demo.helloworld.enums.TestJsonValueEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Nullen
 */
@Data
public class TestReq {

    /**
     * 测试枚举类
     */
    @NotNull(message = "Time span is missing")
    private TestEnum testEnum;

    private TestJsonValueEnum testJsonValueEnum;
}
