package com.nullen.demo.helloworld;

import com.nullen.demo.helloworld.mapstruct.TestConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

/**
 * @author Silas
 */
@SpringBootTest(classes = HelloWorldApplication.class)
public class MapstructTest {

    @Test
    void test() {
        TestConverter testConverter = TestConverter.INSTANCE;
        com.nullen.demo.helloworld.entity.Test test = new com.nullen.demo.helloworld.entity.Test();
        test.setName("test");
        test.setTs(new Timestamp(System.currentTimeMillis()));
        System.out.println(testConverter.convertToDTO(test));
    }
}
