package com.nullen.demo.helloworld.controller;

import com.fd.web.response.Result;
import com.nullen.demo.helloworld.entity.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class DynamicController<DTO> {

    /**
     * 泛型类对应的Class对象, 如果没有泛型, 则无需改属性
     */
    private final Class<DTO> entityClass;


    /**
     * 通过构成函数来指定类的泛型
     *
     * @param entityClass 实体类
     */
    public DynamicController(Class<DTO> entityClass) {
        this.entityClass = entityClass;
    }

    @ResponseBody
    public Result<Long> get(@RequestParam("id") Long id) {
        System.out.println("get......");
        return Result.ok(id);
    }


    @ResponseBody
    public Result<DTO> postSingleDto(@RequestBody DTO dto) {
        System.out.println("postSingleDto......");
        return Result.ok(dto);
    }

    @ResponseBody
    public Result<List<String>> postStrList(@RequestBody List<String> testList) {
        System.out.println("postStrList......");
        return Result.ok(testList);
    }

    @ResponseBody
    public Result<ParameterizedTypeReference<List<DTO>>> postDtoList(
            @RequestBody ParameterizedTypeReference<List<DTO>> dtoList
    ) {
        System.out.println("postDtoList......");
        return Result.ok(dtoList);
    }


    @ResponseBody
    public Result<List<Test>> postTestEntity(@RequestBody List<Test> testList) {
        System.out.println("postTestEntity......");
        return Result.ok(testList);
    }
}
