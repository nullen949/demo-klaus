package com.demo.kafka.test;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSONObject;
import com.demo.kafka.constant.KafkaDemoConstant;
import com.demo.kafka.dto.TestMsg;
import com.nullen.fd.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class KafkaProducerTest {

    @Autowired
    @Qualifier("kafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送单条无回调非事务的消息
     */
    @Test
    public void testSingle() {
        for (int i = 0; i < 2222; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("datekey", 20210610);
            map.put("userid", i);
            map.put("salaryAmount", i);
            kafkaTemplate.send(KafkaDemoConstant.TOPIC_TEST, JSONObject.toJSONString(map));
        }
    }


    /**
     * 批量发送消息
     * 无回调 非事务
     */
    @Test
    public void testBatch() {
        List<TestMsg> msgList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestMsg testMsg = TestMsg.builder()
                    .id(IdUtil.getSnowflakeNextId())
                    .time(DateUtil.now())
                    .msg(IdUtil.simpleUUID())
                    .status(i)
                    .enable(i % 2 == 0)
                    .build();
            msgList.add(testMsg);
            // 向kafka的big_data_topic主题推送数据
            // ProducerRecord producerRecord = new ProducerRecord("topic_test", JSONObject.toJSONString(testMsg));
            kafkaTemplate.send(KafkaDemoConstant.TOPIC_BATCH, JSONObject.toJSONString(testMsg));
        }
    }


    @Test
    public void testSendWithCallback1() {
        // kafkaTemplate.send(KafkaDemoConstant.TOPIC_CB1, "callbackMessage1")
        kafkaTemplate.send(new ProducerRecord<>(KafkaDemoConstant.TOPIC_CB1, "callbackMessage1"))
                .addCallback(success -> {
                    // 消息发送到的topic
                    String topic = success.getRecordMetadata().topic();
                    // 消息发送到的分区
                    int partition = success.getRecordMetadata().partition();
                    // 消息在分区内的offset
                    long offset = success.getRecordMetadata().offset();
                    log.info("发送消息成功: {}_{}_{}", topic, partition, offset);
                }, failure -> {
                    log.error("发送消息失败: {}", failure.getMessage());
                });
    }

    @Test
    public void testBatchSendWithCallback2() {
        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send(KafkaDemoConstant.TOPIC_CB2, "batchCallbackMessage" + i)
                .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                    @Override
                    public void onSuccess(SendResult<String, String> result) {
                        System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                                + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
                    }

                    @Override
                    public void onFailure(Throwable ex) {
                        System.out.println("发送消息失败：" + ex.getMessage());
                    }
                });
        }
    }

    /**
     * 测试发送事务消息
     */
    @Test
    void testSendTransactionMsgAndError() {
        // 声明事务，后面报错消息不会发出去
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send("transaction_topic1", "接收testSendTransactionMsgAndError1")
                    .addCallback(success -> {
                        log.info("Send transaction msg 1 success");
                    }, failure -> {
                        log.info("Send transaction msg 1 error");
                    });

            operations.send("transaction_topic1", "接收testSendTransactionMsgAndError2")
                    .addCallback(success -> {
                        log.info("Send transaction msg 2 success");
                    }, failure -> {
                        log.info("Send transaction msg 2 error");
                    });

            // 这里报错了, 所以前面发送的两个消息发不出去
            // throw new RuntimeException("fail");
            return true;
        });
    }

    @Test
    void testSendWithoutTransactionMsgButError() {
        // 不声明事务，后面保存但前端消息已经发送成功了
        kafkaTemplate.send("transaction_topic2", "接收到testSendWithoutTransactionMsgButError");
        throw new RuntimeException("fail");
    }

}