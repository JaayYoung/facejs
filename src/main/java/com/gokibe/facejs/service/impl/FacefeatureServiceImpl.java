package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.AttenderDao;
import com.gokibe.facejs.dao.FacefeatureDao;
import com.gokibe.facejs.entity.Attender;
import com.gokibe.facejs.entity.Facefeature;
import com.gokibe.facejs.service.AttenderService;
import com.gokibe.facejs.service.FacefeatureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Facefeature)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:10:34
 */
@Transactional
@Service("facefeatureService")
public class FacefeatureServiceImpl implements FacefeatureService {
    @Resource
    private FacefeatureDao facefeatureDao;
    @Resource
    private AttenderDao attenderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param faceid 主键
     * @return 实例对象
     */
    @Override
    public Facefeature queryById(Integer faceid) {
        return this.facefeatureDao.queryById(faceid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Facefeature> queryAllByLimit(int offset, int limit) {
        return this.facefeatureDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param facefeature 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Facefeature facefeature) {
        return this.facefeatureDao.insert(facefeature) > 0;
    }

    @Override
    public boolean update(Facefeature facefeature) {
        return this.facefeatureDao.update(facefeature) > 0;
    }

    @Override
    public boolean deleteById(Integer faceid) {
        return facefeatureDao.deleteById(faceid) > 0;
    }

    @Override
    public boolean saveface(Integer aid, String[] arr) throws Exception {
        Attender attender = attenderDao.queryById(aid);
        Facefeature facefeature = facefeatureDao.queryByAid(aid);
        if (null != attender || null != facefeature) {
            facefeature.setAttname(attender.getAttname());
            facefeature.setAttid(attender.getAttid());
        } else {
            throw new Exception("考勤人信息错误！");
        }
        //       线程不安全，但性能最快
        StringBuilder facemessage = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            if (i == 127) {
                facemessage.append(arr[i]);
                break;
            }
            facemessage.append(arr[i] + ",");

        }
        facefeature.setFacemark(facemessage.toString());
        if (null != facefeature.getFacemark() || "" != facefeature.getFacemark()) {
            return facefeatureDao.update(facefeature) > 0;
        }
        return facefeatureDao.insert(facefeature) > 0;
    }


}