package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:28
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -75457324614777349L;
    /**
     * 管理员id
     */
    private Integer adminid;
    /**
     * 账号
     */
    private String adminaccount;
    /**
     * 密码
     */
    private String adminpassword;
    /**
     * 姓名
     */
    private String adminname;
    /**
     * 电话
     */
    private String admintel;




}