package com.nullen.demo.iotdb.config;

import org.apache.iotdb.session.pool.SessionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneOffset;

/**
 * @author Silas
 */
@Configuration
public class AppConfig {

    @Bean
    public SessionPool sessionPool() {
        return new SessionPool.Builder()
                .host("127.0.0.1")
                .port(6667)
                .user("root")
                .password("root")
                .maxSize(30)
                .zoneId(ZoneOffset.UTC)
                .build();
    }
}
