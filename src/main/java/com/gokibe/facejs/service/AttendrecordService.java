package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.Attendrecord;
import org.springframework.ui.Model;

import java.util.List;

/**
 * (Attendrecord)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:10:31
 */
public interface AttendrecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param recid 主键
     * @return 实例对象
     */
    Attendrecord queryById(Integer recid);



    /**
     * 新增数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    boolean insert(Attendrecord attendrecord);

    /**
     * 修改数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    boolean update(Attendrecord attendrecord);

    /**
     * 通过主键删除数据
     *
     * @param recid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recid);

    
    boolean removeBatch(String[] ids);

    int getCount( );

    List<Attendrecord> queryAllByLimit(int i, int limit);

    void getface(Model model,Integer deptid) throws Exception;


    boolean addrecord(Integer attid, Integer actid);
}