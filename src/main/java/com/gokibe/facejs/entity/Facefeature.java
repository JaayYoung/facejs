package com.gokibe.facejs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Facefeature)实体类
 *
 * @author makejava
 * @since 2021-04-10 22:10:33
 */
@Data
public class Facefeature implements Serializable {
    private static final long serialVersionUID = -76882642267136812L;
    /**
     * 人脸id
     */
    private Integer faceid;
    /**
     * 考勤人id
     */
    private Integer attid;
    /**
     * 考勤人姓名
     */
    private String attname;
    /**
     * 人脸特征
     */
    private String facemark;
    /**
     * 图片路径
     */
    private String imgurl;
    /**
     * 图片标签
     */
    private String imglabel;
    /**
     * 删除标记
     */
    private Object delflag;




}