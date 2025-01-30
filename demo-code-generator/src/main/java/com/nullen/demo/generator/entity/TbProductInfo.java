package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("tb_product_info")
public class TbProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 发布状态 0-未发布 1-已发布
     */
    private Byte publishStatus;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 消息协议
     */
    private String msgProtocol;

    /**
     * 传输协议
     */
    private String transportProtocol;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 产品描述
     */
    private String remarks;

    /**
     * 物模型内容
     */
    private String modelContent;

    /**
     * 排序（正序）
     */
    private Integer sort;

    /**
     * 是否内置
     */
    private Byte isSys;

    private LocalDateTime createTime;

    private String deleted;

    /**
     * 船舶imo编号
     */
    private String imo;
}
