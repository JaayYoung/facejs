package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤活动表
 * (Active)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:09:49
 */
@Data
public class Active implements Serializable {
    private static final long serialVersionUID = 241723771878906884L;
    /**
     * 活动id
     */
    private Integer actid;
    /**
     * 考勤用户 id
     */
    private Integer userid;
    /**
     * 举办部门id
     */
    private Integer deptid;
    /**
     * 活动名称
     */
    private String actname;
    /**
     * 举办部门
     */
    private String deptname;
    /**
     * 考勤用户
     */
    private String username;
    /**
     * 活动时间
     */
    private Date acttime;
    /**
     * 活动地点
     */
    private String actplace;

    private Integer delflag;




}