package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tb_rule_chain")
public class TbRuleChain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String ruleChainId;

    private String chainContent;

    private Long productId;

    private String deviceCodeStr;

    private String ruleDesc;

    private String ruleName;

    private String triggerType;

    private Byte disabled;

    private String cron;
}
