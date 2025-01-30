package com.nullen.demo.ws.server;

import cn.hutool.core.util.StrUtil;
import com.nullen.demo.ws.constant.MQConstant;
import com.nullen.demo.ws.mq.producer.DemoProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoProducerTest {

    @Autowired
    private DemoProducer demoProducer;

    @Test
    void sendToRetryExchange() {
        demoProducer.sendToTopicExchange(StrUtil.format(MQConstant.RETRY_ROUTING_KEY_PREFIX, "123"), "{}");
    }

    @Test
    void sendToFanoutExchange() {
        demoProducer.sendToFanoutExchange("{}");
    }
}