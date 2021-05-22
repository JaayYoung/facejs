package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:34
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -83655328612591252L;
    /**
     * 用户id
     */
    private int userid;

    /**
     * 账号
     */
    private String useraccount;
    /**
     * 密码
     */
    private String userpassword;
    /**
     * 姓名
     */
    private String username;
    /**
     * 电话
     */
    private String usertel;
    /**
     * 0 存在 1删除
     */
    private Integer delflag;




}