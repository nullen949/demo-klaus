package com.nullen.demo.unittest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Silas
 */
@Slf4j
@Service
public class TestService {

    @PostConstruct
    void init() {
        log.info("TestService init...");
    }

    public String test(String name) {
        log.info("TestService test...");
        return name;
    }
}
