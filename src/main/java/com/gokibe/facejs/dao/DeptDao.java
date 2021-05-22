package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dept)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:10:32
 */
public interface DeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param deptid 主键
     * @return 实例对象
     */
    Dept queryById(Integer deptid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @param deptName
     * @return 对象列表
     */
    List<Dept> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,  @Param("deptName") String deptName);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dept 实例对象
     * @return 对象列表
     */
    List<Dept> queryAll(Dept dept);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int insert(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param deptid 主键
     * @return 影响行数
     */
    int deleteById(Integer deptid);

    int getCount(String deptName);

    boolean removeBatch(String[] ids);
}