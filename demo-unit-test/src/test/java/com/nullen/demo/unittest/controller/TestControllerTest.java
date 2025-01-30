package com.nullen.demo.unittest.controller;

import com.nullen.demo.unittest.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Silas
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TestService testService;

    @Test
    void testA() throws Exception {
        String mockName = "Nullen";
        Mockito.when(testService.test(mockName)).thenReturn(mockName);
        mockMvc.perform(get("/api/test").param("name", mockName))
                .andExpect(status().isOk());
    }

}