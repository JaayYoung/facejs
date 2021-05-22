package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.Attender;

import java.util.List;

/**
 * 考勤人信息(Attender)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:10:29
 */
public interface AttenderService {

    /**
     * 通过ID查询单条数据
     *
     * @param attid 主键
     * @return 实例对象
     */
    Attender queryById(Integer attid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Attender> queryAllByLimit(int offset, int limit, String attenderName, Integer attenderNum);

    /**
     * 新增数据
     *
     * @param attender 实例对象
     * @return 实例对象
     */
    boolean insert(Attender attender);

    /**
     * 修改数据
     *
     * @param attender 实例对象
     * @return 实例对象
     */
    boolean update(Attender attender);

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attid);

    Integer getCount(String attenderName, Integer attenderNum);

    boolean removeBatch(String[] ids);
}