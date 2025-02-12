package com.nullen.demo.helloworld.listener;

import com.nullen.demo.helloworld.listener.event.TimeZoneChangeEvent;
import com.nullen.demo.helloworld.scheduler.AbstractDynamicJob;
import com.nullen.fd.utils.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * 时区监听器
 *
 * @author Nullen
 * @date 2024/01/04
 */
@Slf4j
public class TimeZoneListener {
    // @EventListener(classes = TimeZoneChangeEvent.class)
    public void timeZoneChangeListener(TimeZoneChangeEvent timeZoneChangeEvent) {
        log.info("TimeZoneListener#onApplicationEvent");
        Map<String, AbstractDynamicJob> abstractTimeZoneChangeListenerMap = BeanUtil.getBeans(AbstractDynamicJob.class);
        if (CollectionUtils.isEmpty(abstractTimeZoneChangeListenerMap)) {
            return;
        }
        abstractTimeZoneChangeListenerMap.forEach((k, v) -> {
            v.removeOldScheduler();
            v.createJob();
        });
    }
}
