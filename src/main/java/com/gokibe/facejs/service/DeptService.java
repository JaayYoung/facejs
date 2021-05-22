package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.Dept;

import java.util.List;

/**
 * (Dept)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:10:32
 */
public interface DeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param deptid 主键
     * @return 实例对象
     */
    Dept queryById(Integer deptid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dept> queryAllByLimit(int offset, int limit, String deptName);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    boolean insert(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
   boolean update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param deptid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer deptid);


    int getCount(String deptName);

    boolean removeBatch(String[] ids);
}