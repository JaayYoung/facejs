package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Attendrecord;
import com.gokibe.facejs.entity.Facefeature;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Facefeature)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:10:33
 */
public interface FacefeatureDao {

    /**
     * 通过ID查询单条数据
     *
     * @param faceid 主键
     * @return 实例对象
     */
    Facefeature queryById(Integer faceid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Facefeature> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 全查
     *
     * @param facefeature 实例对象
     * @return 对象列表
     */
    List<Facefeature> queryAll();

    /**
     * 新增数据
     *
     * @param facefeature 实例对象
     * @return 影响行数
     */
    int insert(Facefeature facefeature);

    /**
     * 修改数据
     *
     * @param facefeature 实例对象
     * @return 影响行数
     */
    int update(Facefeature facefeature);

    /**
     * 通过主键删除数据
     *
     * @param faceid 主键
     * @return 影响行数
     */
    int deleteById(Integer faceid);

    Facefeature queryByAid(Integer aid);

    Attendrecord findByAttidAndActid(@Param("aid") String attid, @Param("actid") String actid);
}