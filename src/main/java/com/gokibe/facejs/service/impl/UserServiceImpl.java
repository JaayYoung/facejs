package com.gokibe.facejs.service.impl;

import com.gokibe.facejs.dao.UserDao;
import com.gokibe.facejs.entity.User;
import com.gokibe.facejs.real.UserToken;
import com.gokibe.facejs.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-04-10 22:10:35
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit, String uname) {
        return this.userDao.queryAllByLimit(offset, limit,uname);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(User user) {

        return this.userDao.insert(user)>0 ? true:false;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(User user) {

        return  this.userDao.update(user) > 0 ? true:false;
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.userDao.deleteById(userid) > 0;
    }

    @Override
    public int getCount(String uname) {
         return userDao.getCount(uname);
    }

    @Override
    public boolean removeBatch(String[] ids) {
        return userDao.removeBatch(ids)>0?true:false;
    }

    @Override
    public boolean login( String username, String password, HttpSession httpSession) {
        Subject subject= SecurityUtils.getSubject();
        UserToken userToken=new UserToken(username,DigestUtils.md5Hex(password));
        try{
            subject.login(userToken);
            User a=userDao.findByUseraccountAndUserpassword(username,DigestUtils.md5Hex(password));
            httpSession.setAttribute("user",a);
    }catch (UnknownAccountException e) {
            return false;
        }
            return true;
        }

    @Override
    public boolean reg(String username, String password) {
        return false;
    }
}