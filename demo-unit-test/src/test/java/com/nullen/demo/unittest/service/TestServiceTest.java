package com.nullen.demo.unittest.service;

import com.nullen.demo.unittest.entity.TestEntity;
import com.nullen.demo.unittest.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Silas
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class TestServiceTest {

    @MockBean
    private TestMapper testMapper;
    @MockBean
    private TestService testService;

    @Test
    void test1() {
        TestEntity mockEntity = new TestEntity();
        mockEntity.setId(3L);
        mockEntity.setName("test");
        Mockito
                .when(testMapper.selectById(Mockito.any()))
                .thenReturn(mockEntity);
    }
}