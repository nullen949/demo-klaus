package com.nullen.demo.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author Nullen
 */
@Import(TestBeanA.class)
@ConditionalOnBean(TestBeanC.class) // 写在类上也可以生效, 会影响@Import和@Bean
public class DemoStarterAutoConfigurationB {

    @Bean
    public TestBeanD testBeanD() {
        return new TestBeanD();
    }

}
