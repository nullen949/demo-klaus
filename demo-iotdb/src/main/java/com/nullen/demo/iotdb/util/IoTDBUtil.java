package com.nullen.demo.iotdb.util;

import cn.hutool.core.collection.CollUtil;
import com.nullen.demo.iotdb.entity.BaseIoTDBEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.apache.iotdb.session.pool.SessionPool;
import org.apache.iotdb.tsfile.write.record.Tablet;
import org.apache.iotdb.tsfile.write.schema.MeasurementSchema;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Silas
 */
@Slf4j
@Component
public class IoTDBUtil {

    @Resource
    private SessionPool sessionPool;

    private static SessionPool SESSION_POOL;

    @PostConstruct
    public void init() {
        SESSION_POOL = sessionPool;
    }


    public static <T extends BaseIoTDBEntity> void batchInsert(List<T> entityList) {
        if (CollUtil.isEmpty(entityList)) {
            return;
        }

        List<MeasurementSchema> schemaList = new ArrayList<>();
        for (T entity : entityList) {
            try {
                Tablet tablet = new Tablet(entity.getDeviceId(), schemaList);
                SESSION_POOL.insertTablet(tablet);
            } catch (IoTDBConnectionException | StatementExecutionException e) {
                log.error("Execute insertTablet error, msg: {}", e.getMessage());
            } catch (Exception e) {
                log.error("Insert error, msg: {}", e.getMessage());
            }
        }
    }


    public static <T extends BaseIoTDBEntity> void batchInsert(T entity) {

        // SESSION_POOL.insertTablets();
    }


    public static void query() {
        // SESSION_POOL.executeRawDataQuery();
    }
}
