package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.ActiveDao;
import com.gokibe.facejs.dao.AttenderDao;
import com.gokibe.facejs.dao.AttendrecordDao;
import com.gokibe.facejs.dao.FacefeatureDao;
import com.gokibe.facejs.entity.Active;
import com.gokibe.facejs.entity.Attender;
import com.gokibe.facejs.entity.Attendrecord;
import com.gokibe.facejs.entity.Facefeature;
import com.gokibe.facejs.service.AttendrecordService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Attendrecord)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:10:31
 */
@Service("attendrecordService")
public class AttendrecordServiceImpl implements AttendrecordService {
    @Resource
    private AttendrecordDao attendrecordDao;
    @Resource
    private FacefeatureDao facefeatureDao;
    @Resource
    private ActiveDao activeDao;
    @Resource
    private AttenderDao attenderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recid 主键
     * @return 实例对象
     */
    @Override
    public Attendrecord queryById(Integer recid) {
        return this.attendrecordDao.queryById(recid);
    }


    /**
     * 新增数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Attendrecord attendrecord) {

        return this.attendrecordDao.insert(attendrecord) > 0;
    }

    /**
     * 修改数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Attendrecord attendrecord) {

        return this.attendrecordDao.update(attendrecord) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param recid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recid) {
        return this.attendrecordDao.deleteById(recid) > 0;
    }

    @Override
    public boolean removeBatch(String[] ids) {
        return attendrecordDao.removeBatch(ids);
    }

    @Override
    public int getCount() {
        return attendrecordDao.getCount();
    }

    @Override
    public List<Attendrecord> queryAllByLimit(int offset, int limit) {
        return attendrecordDao.queryAllByLimit(offset, limit);
    }

    @Override
    public void getface(Model model, Integer actid) throws Exception {
        Active active = activeDao.queryById(actid);
        Facefeature facefeature = facefeatureDao.queryById(1);
        if (null != facefeature) {
            model.addAttribute("actid", actid);
            String str[] = facefeature.getFacemark().split(",", 128);
            model.addAttribute("fea", str);
        } else {
            throw new Exception("人脸信息库为空！");
        }

    }

    @Override
    public boolean addrecord(Integer attid, Integer actid) {
        Attendrecord attendrecord = attendrecordDao.findByAttidAndActid(attid, actid);
        if (null != attendrecord ) {
            if (1==attendrecord.getRecstatic()){
                return false;
            }
            attendrecord.setActid(actid);
            attendrecord.setAttid(attid);
            Attender attender = attenderDao.queryById(attid);
            Active active = activeDao.queryById(actid);
            if (null != attender)
                attendrecord.setAttname(attender.getAttname());
            if (null != active)
                attendrecord.setRecactive(active.getActname());
            attendrecord.setRecplace(active.getActplace());
            attendrecord.setRectime(active.getActtime());
            attendrecord.setRecstatic(1);
            return attendrecordDao.update(attendrecord) > 0;
        } else {
            Attendrecord attendrecord1 =new Attendrecord();
            attendrecord1.setActid(actid);
            attendrecord1.setAttid(attid);
            Attender attender = attenderDao.queryById(attid);
            Active active = activeDao.queryById(actid);
            if (null != attender)
                attendrecord1.setAttname(attender.getAttname());
            if (null != active)
                attendrecord1.setRecactive(active.getActname());
            attendrecord1.setRecplace(active.getActplace());
            attendrecord1.setRectime(active.getActtime());
            attendrecord1.setRecstatic(1);
            return attendrecordDao.insert(attendrecord1) > 0;
        }

    }
}