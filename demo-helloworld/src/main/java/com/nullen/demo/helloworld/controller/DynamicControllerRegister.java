package com.nullen.demo.helloworld.controller;

import cn.hutool.core.util.ReflectUtil;
import com.nullen.demo.helloworld.entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author Nullen
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DynamicControllerRegister {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;


    @PostConstruct
    void init() throws NoSuchMethodException {
        log.info("动态创建接口");

        RequestMappingInfo.BuilderConfiguration config = new RequestMappingInfo.BuilderConfiguration();
        config.setPatternParser(requestMappingHandlerMapping.getPatternParser());

        RequestMappingInfo getApiMappingInfo = RequestMappingInfo
                // 给接口地址赋值
                .paths("/api/dynamic/get")
                // 指定接口请求方式
                .methods(RequestMethod.GET)
                .options(config)
                .build();

        DynamicController<Test> testDynamicController = new DynamicController<>(Test.class);
        Class<? extends DynamicController> aClass = testDynamicController.getClass();
        requestMappingHandlerMapping.registerMapping(getApiMappingInfo, testDynamicController, ReflectUtil.getMethodByName(aClass, "get"));

        requestMappingHandlerMapping.registerMapping(
                RequestMappingInfo
                        .paths("/api/dynamic/post-single-dto")
                        .methods(RequestMethod.POST)
                        .produces(MediaType.APPLICATION_JSON_VALUE)
                        .consumes(MediaType.APPLICATION_JSON_VALUE)
                        .options(config)
                        .build(),
                testDynamicController, ReflectUtil.getMethodByName(aClass, "postSingleDto")
        );

        requestMappingHandlerMapping.registerMapping(RequestMappingInfo
                        .paths("/api/dynamic/post-str-list")
                        .methods(RequestMethod.POST)
                        .consumes(MediaType.APPLICATION_JSON_VALUE)
                        .options(config)
                        .build(),
                testDynamicController, ReflectUtil.getMethodByName(aClass, "postStrList"));

        // requestMappingHandlerMapping.registerMapping(RequestMappingInfo
        //                 .paths("/api/dynamic/post-dto-list")
        //                 .methods(RequestMethod.POST)
        //                 .consumes(MediaType.APPLICATION_JSON_VALUE)
        //                 .options(config)
        //                 .build(),
        //         testDynamicController,
        //         testDynamicController.getClass().getMethod("postDtoList", List.class)
                /* ReflectUtil.getMethodByName(aClass, "postDtoList") )*/;

        requestMappingHandlerMapping.registerMapping(RequestMappingInfo
                        .paths("/api/dynamic/post-test-entity")
                        .methods(RequestMethod.POST)
                        .consumes(MediaType.APPLICATION_JSON_VALUE)
                        .options(config)
                        .build(),
                testDynamicController,
                ReflectUtil.getMethodByName(aClass, "postTestEntity"));

        // 获取所有的handler
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        log.info("接口列表: {}", handlerMethods);
    }
}
