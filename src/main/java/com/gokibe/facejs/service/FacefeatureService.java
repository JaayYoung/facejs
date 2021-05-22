package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.Facefeature;

import java.util.List;

/**
 * (Facefeature)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:10:34
 */
public interface FacefeatureService {

    /**
     * 通过ID查询单条数据
     *
     * @param faceid 主键
     * @return 实例对象
     */
    Facefeature queryById(Integer faceid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Facefeature> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param facefeature 实例对象
     * @return 实例对象
     */
    boolean insert(Facefeature facefeature);

    /**
     * 修改数据
     *
     * @param facefeature 实例对象
     * @return 实例对象
     */
    boolean update(Facefeature facefeature);

    /**
     * 通过主键删除数据
     *
     * @param faceid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer faceid);

    /**
     * 根据考勤人id录入人脸信息
     * @param aid 考勤人id
     * @param arr
     * @return
     */
    boolean saveface(Integer aid, String[] arr) throws Exception;
}