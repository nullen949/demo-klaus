package com.nullen.demo.unittest.controller;

import com.nullen.demo.unittest.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silas
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController implements InitializingBean {

    private final TestService testService;

    @GetMapping("/api/test")
    public String test(@RequestParam String name) {
        return testService.test(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("TestController afterPropertiesSet");
    }
}
