package com.nullen.demo.helloworld.controller;

import com.alibaba.fastjson2.JSONObject;
import com.fd.web.response.Result;
import com.nullen.demo.helloworld.request.HelloWorldDTO;
import com.nullen.demo.helloworld.request.TestReq;
import com.nullen.demo.helloworld.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nullen
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(required = false) String name) {
        return helloWorldService.sayHello(name);
    }

    @PostMapping("/hello-world")
    public String helloWorld(@RequestBody @Validated HelloWorldDTO dto) {

        return helloWorldService.sayHello(dto.getName());
    }


    @PostMapping("/test-enum")
    public TestReq testEnumReq(@RequestBody @Validated TestReq testReq) {
        return testReq;
    }

    @PostMapping("/req-list")
    public Result<List<String>> reqList(@RequestBody @Validated List<String> list) {
        return Result.ok(list);
    }

    @GetMapping("/json")
    public Result<JSONObject> getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "nullen");
        jsonObject.put("age", null);
        System.out.println(jsonObject);
        return Result.ok(jsonObject);
    }

}
