package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.DeptDao;
import com.gokibe.facejs.entity.Dept;
import com.gokibe.facejs.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:10:33
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param deptid 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Integer deptid) {
        return this.deptDao.queryById(deptid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Dept> queryAllByLimit(int offset, int limit, String deptName) {
        return this.deptDao.queryAllByLimit(offset, limit,deptName);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Dept dept) {

        return this.deptDao.insert(dept) >0 ? true:false;
    }

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Dept dept) {
        return this.deptDao.update(dept) >0 ? true:false;
    }

    /**
     * 通过主键删除数据
     *
     * @param deptid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer deptid) {
        return this.deptDao.deleteById(deptid) > 0;
    }

    @Override
    public int getCount(String deptName) {
        return deptDao.getCount(deptName);
    }

    @Override
    public boolean removeBatch(String[] ids) {
        return deptDao.removeBatch(ids);
    }
}