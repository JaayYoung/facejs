package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 考勤人信息(Attender)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:29
 */
@Data
public class Attender implements Serializable {
    private static final long serialVersionUID = 363611655868107038L;
    /**
     * 考勤人id
     */
    private Integer attid;
    /**
     * 部门id
     */
    private Integer deptid;
    /**
     * 姓名
     */
    private String attname;
    /**
     * 编号
     */
    private String attnum;
    /**
     * 电话
     */
    private String atttel;
    /**
     * 性别
     */
    private String attsex;
    /**
     * 所属部门
     */
    private String deptname;
    /**
     * 逻辑删除标记
     */
    private int delflag;




}