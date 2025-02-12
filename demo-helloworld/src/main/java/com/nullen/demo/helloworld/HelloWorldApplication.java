package com.nullen.demo.helloworld;

import cn.hutool.extra.spring.EnableSpringUtil;
import com.nullen.demo.helloworld.anno.EnableDataSync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Nullen
 */
@EnableSpringUtil
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableDataSync("com.nullen.demo.helloworld.entity")
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
