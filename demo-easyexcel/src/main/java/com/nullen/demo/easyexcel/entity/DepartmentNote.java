package com.nullen.demo.easyexcel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 部门记事
 *
 * @author Nullen
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sg_department_note")
public class DepartmentNote extends VesselEntity {

    /**
     * 日志ID
     */
    private Long logbookId;

    /**
     * 部门记事内容
     */
    private String content;


}
