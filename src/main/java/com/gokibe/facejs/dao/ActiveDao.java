package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Active;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考勤活动表
 * (Active)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:09:53
 */
public interface ActiveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param actid 主键
     * @return 实例对象
     */
    Active queryById(Integer actid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @param actname
     * @return 对象列表
     */
    List<Active> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("actname")String actname);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param active 实例对象
     * @return 对象列表
     */
    List<Active> queryAll(Active active);

    /**
     * 新增数据
     *
     * @param active 实例对象
     * @return 影响行数
     */
    int insert(Active active);

    /**
     * 修改数据
     *
     * @param active 实例对象
     * @return 影响行数
     */
    int update(Active active);

    /**
     * 通过主键删除数据
     *
     * @param actid 主键
     * @return 影响行数
     */
    int deleteById(Integer actid);

    boolean removeBatch(String[] ids);

    int getCount(String actname);
}