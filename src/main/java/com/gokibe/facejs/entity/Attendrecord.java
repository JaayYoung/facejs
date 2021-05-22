package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Attendrecord)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:30
 */
@Data
public class Attendrecord implements Serializable {
    private static final long serialVersionUID = 253542227652279910L;
    /**
     * 记录id
     */
    private Integer recid;
    /**
     * 考勤人id
     */
    private Integer attid;
    /**
     * 考勤活动id
     */
    private Integer actid;
    /**
     * 考勤人姓名
     */
    private String attname;
    /**
     * 考勤状态 0未签到 1已签到
     */
    private Integer recstatic;
    /**
     * 考勤时间
     */
    private Date rectime;
    /**
     * 考勤地点
     */
    private String recplace;
    /**
     * 考勤活动
     */
    private String recactive;

    private Integer delflag;



}