package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.AttenderDao;
import com.gokibe.facejs.entity.Attender;
import com.gokibe.facejs.service.AttenderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考勤人信息(Attender)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:10:30
 */

@Service("attenderService")
public class AttenderServiceImpl implements AttenderService {
    @Resource
    private AttenderDao attenderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param attid 主键
     * @return 实例对象
     */
    @Override
    public Attender queryById(Integer attid) {
        return this.attenderDao.queryById(attid);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Attender> queryAllByLimit(int offset, int limit, String attenderName, Integer attenderNum) {
        return this.attenderDao.queryAllByLimit(offset, limit, attenderName, attenderNum);
    }

    /**
     * 新增数据
     *
     * @param attender 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Attender attender) {

        return this.attenderDao.insert(attender) > 0? true:false;
    }

    /**
     * 修改数据
     *
     * @param attender 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Attender attender) {

        return this.attenderDao.update(attender)> 0? true:false;
    }

    /**
     * 通过主键删除数据
     *
     * @param attid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attid) {
        return this.attenderDao.deleteById(attid) > 0;
    }

    @Override
    public Integer getCount(String attenderName, Integer attenderNum) {
        return attenderDao.getCount(attenderName,attenderNum);
    }

    @Override
    public boolean removeBatch(String[] ids) {
        return attenderDao.removeBatch(ids)>0?true:false;
    }
}