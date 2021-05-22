package com.gokibe.facejs.service;

import com.gokibe.facejs.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-04-10 22:10:35
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    User queryById(Integer userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit, String uname);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    boolean insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    boolean update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

    int getCount(String uname);

    boolean removeBatch(String[] ids);


    boolean login(String username, String password,HttpSession httpSession);


    boolean reg(String username, String password);
}