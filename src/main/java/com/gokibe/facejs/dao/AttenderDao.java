package com.gokibe.facejs.dao;

import com.gokibe.facejs.entity.Attender;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考勤人信息(Attender)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-10 22:10:29
 */
public interface AttenderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attid 主键
     * @return 实例对象
     */
    Attender queryById(Integer attid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Attender> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("attenderName") String attenderName, @Param("attenderNum") Integer attenderNum);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param attender 实例对象
     * @return 对象列表
     */
    List<Attender> queryAll(Attender attender);

    /**
     * 新增数据
     *
     * @param attender 实例对象
     * @return 影响行数
     */
    int insert(Attender attender);

    /**
     * 修改数据
     *
     * @param attender 实例对象
     * @return 影响行数
     */
    int update(Attender attender);

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 影响行数
     */
    int deleteById(Integer attid);

    int  getCount(@Param("attenderName") String attenderName,@Param("attenderNum") Integer attenderNum);

    int removeBatch(String[] ids);
}