package com.nullen.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Nullen
 */

@Slf4j
@SpringBootTest
class VersionIdUtilTest {

    @Test
    void generateLatestId() {
        log.info("New version id: {}", VersionIdUtil.generateLatestId());
    }
}