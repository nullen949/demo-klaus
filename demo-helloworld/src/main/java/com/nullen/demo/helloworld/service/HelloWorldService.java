package com.nullen.demo.helloworld.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Silas
 */
@Slf4j
@Service
public class HelloWorldService {

    public String sayHello(String name) {
        log.info("HelloWorldService sayHello");
        return "Hello " + name;
    }

}
