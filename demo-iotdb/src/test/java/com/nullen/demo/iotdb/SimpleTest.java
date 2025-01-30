package com.nullen.demo.iotdb;

import org.apache.iotdb.isession.util.Version;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.apache.iotdb.session.Session;
import org.apache.iotdb.session.pool.SessionPool;
import org.apache.iotdb.tsfile.file.metadata.enums.CompressionType;
import org.apache.iotdb.tsfile.file.metadata.enums.TSDataType;
import org.apache.iotdb.tsfile.file.metadata.enums.TSEncoding;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Silas
 */
@SpringBootTest
public class SimpleTest {

    @Resource
    private SessionPool sessionPool;

    @Test
    void testDefaultSession() throws StatementExecutionException {
        try {
            // DDL
            // 创建数据库
            sessionPool.createDatabase("root.demo");
            // 删除数据库
            // session.deleteStorageGroup("default");
            // 批量删除
            // session.deleteStorageGroups(Arrays.asList("default"));

            // 创建时间序列管理
            Map<String, String> props = new HashMap<>();
            Map<String, String> tags = new HashMap<>();
            Map<String, String> attributes = new HashMap<>();
            sessionPool.createTimeseries("root.demo.test1.status", TSDataType.INT32, TSEncoding.BITMAP,
                    CompressionType.GZIP, props, tags, attributes, "root.demo.test1.status");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testSingleSession() throws IoTDBConnectionException {
        // 指定一个可连接节点
        Session singleSession =
                new Session.Builder()
                        .host("192.168.110.245")
                        .port(6667).build();

    }


    @Test
    void testMultiSession() throws IoTDBConnectionException {
        // 指定多个可连接节点
        Session multiSession =
                new Session.Builder()
                        .nodeUrls(Arrays.asList("192.168.110.243", "192.168.110.245"))
                        .build();
    }


    @Test
    void testDetailSession() throws IoTDBConnectionException {
        // 其他配置项
        Session otherSession =
                new Session.Builder()
                        .fetchSize(10)
                        .username("root")
                        .password("root")
                        .thriftDefaultBufferSize(10)
                        .thriftMaxFrameSize(10)
                        .enableRedirection(true)
                        .version(Version.V_1_0)
                        .build();
    }

}
