package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.Active;

import java.util.List;

/**
 * 考勤活动表
 * (Active)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:09:54
 */
public interface ActiveService {

    /**
     * 通过ID查询单条数据
     *
     * @param actid 主键
     * @return 实例对象
     */
    Active queryById(Integer actid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @param actname
     * @return 对象列表
     */
    List<Active> queryAllByLimit(int offset, int limit, String actname);

    /**
     * 新增数据
     *
     * @param active 实例对象
     * @return 实例对象
     */
    boolean insert(Active active);

    /**
     * 修改数据
     *
     * @param active 实例对象
     * @return 实例对象
     */
    boolean update(Active active);

    /**
     * 通过主键删除数据
     *
     * @param actid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer actid);

    int getCount(String actname);


    boolean removeBatch(String[] ids);
}