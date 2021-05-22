package com.gokibe.facejs.controller;

import com.gokibe.facejs.entity.User;
import com.gokibe.facejs.service.UserService;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:10:35
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @RequestMapping(value = "/index")
    public String userIndex() {
        return "usermanager";
    }

    /**
     * 分页查询用户信息
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "listPage")
    public String listPage(int page, int limit, String uname) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
//        result.put("msg","");
        result.put("count", userService.getCount(uname));
        result.put("data", userService.queryAllByLimit((page - 1) * limit, limit, uname));
        return new Gson().toJson(result);
    }

    /**
     * 添加用户信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public boolean save(User user) {
        return userService.insert(user);
    }

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(User user){
        return userService.update(user);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "removeBatch")
    @ResponseBody
    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
        return userService.removeBatch(ids);
    }


    @RequestMapping(value = "login")
    @ResponseBody
    public boolean login( String username,String password,HttpSession httpSession){
        username ="123456";
        password = "123456";
    return userService.login(username,password,httpSession);
    }

    @RequestMapping(value = "register")
    @ResponseBody
    public boolean reg(String username,String password){
        return userService.reg(username,password);
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";

    }
}