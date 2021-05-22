package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.ActiveDao;
import com.gokibe.facejs.entity.Active;
import com.gokibe.facejs.service.ActiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考勤活动表
 * (Active)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:09:55
 */
@Service("activeService")
public class ActiveServiceImpl implements ActiveService {
    @Resource
    private ActiveDao activeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param actid 主键
     * @return 实例对象
     */
    @Override
    public Active queryById(Integer actid) {
        return this.activeDao.queryById(actid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @param actname
     * @return 对象列表
     */
    @Override
    public List<Active> queryAllByLimit(int offset, int limit, String actname) {
        return this.activeDao.queryAllByLimit(offset, limit,actname);
    }

    /**
     * 新增数据
     *
     * @param active 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Active active) {

        return this.activeDao.insert(active) > 0;
    }

    /**
     * 修改数据
     *
     * @param active 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Active active) {

        return this.activeDao.update(active)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param actid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer actid) {
        return this.activeDao.deleteById(actid) > 0;
    }

    @Override
    public int getCount(String actname) {
        return activeDao.getCount(actname);
    }

    @Override
    public boolean removeBatch(String[] ids) {
        return activeDao.removeBatch(ids);
    }

}