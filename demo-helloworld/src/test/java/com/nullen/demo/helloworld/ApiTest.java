package com.nullen.demo.helloworld;

import com.nullen.demo.helloworld.controller.HelloWorldController;
import com.nullen.demo.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Nullen
 */
@WebMvcTest(HelloWorldController.class)
public class ApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldService helloWorldService;

    @Test
    void testHelloWorld() {
        // mockMvc.perform()
    }
}
