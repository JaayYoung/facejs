package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:10:28
 */
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param admin 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 影响行数
     */
    int deleteById(Integer adminid);

    Admin findByAdminaccountAndAdminpassword(@Param("adname") String adname,@Param("adPassword")  String adPassword);
}