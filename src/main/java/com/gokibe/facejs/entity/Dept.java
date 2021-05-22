package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:32
 */
@Data
public class Dept implements Serializable {
    private static final long serialVersionUID = 636294627528570223L;
    /**
     * 部门id
     */
    private Integer deptid;
    /**
     * 部门名称
     */
    private String deptname;
    /**
     * 部门编号
     */
    private String deptnum;

    private String deptmajor;

    private Integer delflag;




}