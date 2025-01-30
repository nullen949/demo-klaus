package com.nullen.demo.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("biz_user")
public class BizUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户权限值
     */
    private Byte power;

    /**
     * 逻辑删除
     */
    private Byte delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 数据创建人
     */
    private String createBy;

    /**
     * 数据更新人
     */
    private String updateBy;
}
