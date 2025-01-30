package com.demo.kafka.consumer;

import com.demo.kafka.constant.KafkaDemoConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * KafkaConsumer is a Spring-based component designed to facilitate the consumption of messages from Apache Kafka topics.
 * It leverages Spring's {@link KafkaListener} annotations to define methods that react to messages arriving on specified Kafka topics.
 * This class includes functionality for consuming individual messages, batch processing, manual acknowledgment,
 * and transactional message handling, demonstrating versatility in managing different Kafka consumption scenarios.
 *
 * <p><b>Key Features:</b>
 * <ul>
 *   <li>Individual Message Consumption: Listens to a single Kafka topic and processes each message individually.</li>
 *   <li>Batch Consumption: Handles incoming messages in batches, improving throughput by reducing database interaction overhead.</li>
 *   <li>Manual Acknowledgment: Provides control over when a message is considered processed, allowing for custom commit strategies.</li>
 *   <li>Transactional Consumption: Supports transactional message processing, ensuring data consistency between Kafka and databases.</li>
 * </ul>
 *
 * <p><b>Usage Note:</b>
 * Ensure that the appropriate Spring Kafka configuration is in place to establish connections to the Kafka cluster,
 * including settings for consumer groups, bootstrap servers, and any additional Kafka properties necessary for the desired behavior.
 *
 * @see KafkaListener
 * @see Acknowledgment
 */
@Slf4j
@Component
public class KafkaConsumer {


    /**
     * 监听kafka数据
     */
    @KafkaListener(topics = {KafkaDemoConstant.TOPIC_TEST}, groupId = KafkaDemoConstant.GROUP_ID)
    public void consumer(ConsumerRecord<String, String> msgList, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic/* , Acknowledgment ack */) throws Exception {
        // public void consumer(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Acknowledgment ack) throws Exception {
        // public void consumer(String msg) {
        log.info("消费者接受到数据, Topic: {}, 内容: '{}'", topic, msgList);
        // log.info("消费者接受到数据: '{}'", msg);
        //...
        // db.save(consumerRecord);//插入或者更新数据

        // 手动ACK, 默认是没有报错就自动ack, 可以在配置中禁止
        // ack.acknowledge();

        // 拒绝ack, 会报错"nack(sleep) is not supported by this Acknowledgment", 原因未知
        // ack.nack(1000);

        // 拒绝ACK (需要拒绝的msg index (一次只能拒绝一条???), 重新消费延迟的ms值)
        // ack.nack(msgList.size() - 1,10000);
    }

    /**
     * 监听kafka数据（批量消费）
     *
     * @param consumerRecords
     * @param ack
     */
    @KafkaListener(topics = {KafkaDemoConstant.TOPIC_BATCH}, containerFactory = KafkaDemoConstant.BATCH_FACTORY)
    public void batchConsumer(List<ConsumerRecord<String, String>> consumerRecords, Acknowledgment ack) { // 使用ConsumerRecord进行数据接收, 必须使用List, 而不是单个ConsumerRecord对象
        log.info("收到批量数据，batch size：{}", consumerRecords.size());
        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            log.info("批量消息-单条 partition: {} offset: {}, 内容: {}", consumerRecord.partition(),
                    consumerRecord.offset(), consumerRecord.value());
        }
        //...
        // db.batchSave(consumerRecords);//批量插入或者批量更新数据

        // 手动提交
        ack.acknowledge();
    }


    @KafkaListener(topics = KafkaDemoConstant.TOPIC_CB1)
    public void cb1Consumer(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        log.info("cb1Consumer topic_cb1：{}, 分区: {}, 消息内容: {}", record.topic(), record.partition(), record.value());
        ack.acknowledge();
    }

    /**
     * 批量消费的回调消费者
     *
     * @param records 记录
     * @param ack     消
     */
    @KafkaListener(topics = KafkaDemoConstant.TOPIC_CB2, containerFactory = KafkaDemoConstant.BATCH_FACTORY)
    public void batchCb2Consumer(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {
        log.info("batchCb2Consumer 收到批量消息 size:{}", records.size());
        records.forEach(record -> {
            log.info("batchCb2Consumer topic：{}, partition: {}, value: {}", record.topic(), record.partition(), record.value());
        });
        ack.acknowledge();
    }


    /**
     * 事务消息消费者
     *
     * @param record 接入的消息
     */
    @KafkaListener(id = "transactionTopicConsumer",
            topicPartitions = {
                    @TopicPartition(topic = "transaction_topic1", partitions = {"0"}),
                    @TopicPartition(topic = "transaction_topic2", partitions = "0",
                            partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8")
                    )
            })
    public void transactionTopicConsumer(ConsumerRecord<?, ?> record) {
        log.info("接收到Kafka事务消息, topic: {}, partition:{}, offset: {}, value: {}", record.topic(), record.partition(), record.offset(), record.value());
    }
}