package com.nullen.demo.helloworld.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Nullen
 */
@Data
public class HelloWorldDTO {

    @NotBlank(message = "名称不可为空")
    private String name;
}
