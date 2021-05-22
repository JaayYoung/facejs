package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Attendrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Attendrecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:10:31
 */
public interface AttendrecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param recid 主键
     * @return 实例对象
     */
    Attendrecord queryById(Integer recid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attendrecord 实例对象
     * @return 对象列表
     */
    List<Attendrecord> queryAll(Attendrecord attendrecord);

    /**
     * 新增数据
     *
     * @param attendrecord 实例对象
     * @return 影响行数
     */
    int insert(Attendrecord attendrecord);

    /**
     * 修改数据
     *
     * @param attendrecord 实例对象
     * @return 影响行数
     */
    int update(Attendrecord attendrecord);

    /**
     * 通过主键删除数据
     *
     * @param recid 主键
     * @return 影响行数
     */
    int deleteById(Integer recid);

    List<Attendrecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Attendrecord findByAttidAndActid(@Param("attid") Integer attid,@Param("actid") Integer actid);

    int getCount( );

    boolean removeBatch(String[] ids);
}