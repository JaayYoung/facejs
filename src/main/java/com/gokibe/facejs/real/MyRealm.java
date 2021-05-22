package com.gokibe.facejs.real;

import com.gokibe.facejs.dao.AdminDao;
import com.gokibe.facejs.dao.UserDao;
import com.gokibe.facejs.entity.Admin;
import com.gokibe.facejs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;
//重写授权模块
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("已授权");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) principalCollection.getPrimaryPrincipal() ;
        //
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        return null;
    }
    //（2）重写认证方法doGetAuthenticationInfo
    //用户登录时会调用这个方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        if(authenticationToken instanceof UserToken) //普通用户的认证逻辑
        {
//            token里包含会员的登录信息（包含账号和密码）
            UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken ;
//            通过账号和密码从数据库查出是否存在这个会员用户
        User user = userDao.findByUseraccountAndUserpassword(token.getUsername(),String.copyValueOf(token.getPassword()));
//    如果是null，就会抛出异常
        if(null == user){
            return null;
        }
        //SimpleAuthenticationInfo ：代表该用户的认证信息。参数为“用户名或者用户+密码+盐”
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getUserpassword(),"") ;
        System.out.println("完成认证！");
        return info;
        }
        else if(authenticationToken instanceof AdminToken) //管理员的谁逻辑
        {
            UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken ;
        Admin admin = adminDao.findByAdminaccountAndAdminpassword(token.getUsername(),String.copyValueOf(token.getPassword()));

        if(null == admin){
            return null ;
        }
        //SimpleAuthenticationInfo ：代表该用户的认证信息。参数为“用户名+密码+盐”
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin,admin.getAdminpassword(),"") ;
        System.out.println("完成认证！");
        return info;
        }
        else
        {
            return null;
        }
    }
}
