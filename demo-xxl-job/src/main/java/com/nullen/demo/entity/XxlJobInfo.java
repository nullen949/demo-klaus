package com.nullen.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *
 * @author Nullen
 */
@Data
@NoArgsConstructor
public class XxlJobInfo {

    private int id;
    /**
     * 执行器主键ID
     */
    private int jobGroup;
    private String jobDesc;

    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    /**
     * 负责人
     */
    private String author;
    /**
     * 报警邮件
     */
    private String alarmEmail;
    /**
     * 调度类型
     */
    private String scheduleType;
    /**
     * 调度配置，值含义取决于调度类型
     */
    private String scheduleConf;
    /**
     * 调度过期策略
     */
    private String misfireStrategy;
    /**
     * 执行器路由策略
     */
    private String executorRouteStrategy;
    /**
     * 执行器，任务Handler名称
     */
    private String executorHandler;
    /**
     * 执行器，任务参数
     */
    private String executorParam;
    /**
     * 阻塞处理策略
     */
    private String executorBlockStrategy;
    /**
     * 任务执行超时时间，单位秒
     */
    private int executorTimeout;
    /**
     * 失败重试次数
     */
    private int executorFailRetryCount;
    /**
     * GLUE类型	#com.xxl.job.core.glue.GlueTypeEnum
     */
    private String glueType;
    /**
     * GLUE源代码
     */
    private String glueSource;
    /**
     * GLUE备注
     */
    private String glueRemark;
    /**
     * GLUE更新时间
     */
    private LocalDateTime glueUpdatetime;
    /**
     * 子任务ID，多个逗号分隔
     */
    private String childJobId;
    /**
     * 调度状态：0-停止，1-运行
     */
    private int triggerStatus;
    /**
     * 上次调度时间
     */
    private long triggerLastTime;
    /**
     * 下次调度时间
     */
    private long triggerNextTime;


}
