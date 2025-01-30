package com.nullen.demo.starter;

import com.nullen.demo.starter.properties.DemoProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author Nullen
 * Bean初始化顺序, @Import优先级高于@Bean
 */
@Import({DemoProperties.class, TestBeanG.class, TestBeanF.class})
public class DemoStarterAutoConfigurationC {

    @Bean
    public TestBeanE testBeanE() {
        return new TestBeanE();
    }

    @Bean
    public TestBeanB testBeanB() {
        return new TestBeanB();
    }

    @Bean
    @ConditionalOnProperty(prefix = DemoProperties.PREFIX, name = "name")
    public TestBeanC testBeanC() {
        return new TestBeanC();
    }


}
