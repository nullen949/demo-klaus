package com.nullen.demo.tdengine.tdorm;

import com.nullen.fd.utils.JsonUtil;
import com.nullen.tdengineorm.mapper.TDengineMapper;
import com.nullen.tdengineorm.wrapper.AbstractTdQueryWrapper;
import com.nullen.tdengineorm.wrapper.TdWrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Nullen
 */
@Slf4j
@SpringBootTest
public class TestA {

    @Resource
    private TDengineMapper tdengineMapper;

    @Test
    void testList() {
        AbstractTdQueryWrapper<TestEntityA> wrapper = TdWrappers.queryWrapper(TestEntityA.class)
                .selectAll()
                .intervalWindow("1m")
                .orderByDesc(TestEntityA::getTs)
                .limit(1, 2);

        log.info("sql: {}", wrapper.getSql());
        log.info("param: {}", wrapper.getParamsMap());

        List<TestEntityA> list = tdengineMapper.list(wrapper);
        log.info("{}", JsonUtil.toJsonStr(list));
    }
}
