package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Baomidou
 * @since 2024-07-03
 */
@Getter
@Setter
@TableName("biz_thing_update_log")
public class BizThingUpdateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 更新内容
     */
    private String updateContent;

    /**
     * 更新种类的关联值
     */
    private String contentCode;

    /**
     * 更新类型：0告警阈值更新 1字段信息更新
     */
    private Integer type;
}
