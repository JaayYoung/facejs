package com.gokibe.facejs.controller;


import com.gokibe.facejs.entity.Dept;
import com.gokibe.facejs.service.DeptService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:10:33
 */
@Controller
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dept selectOne(Integer id) {
        return this.deptService.queryById(id);
    }

    @RequestMapping(value = "/index")
    public String deptIndex() {
        return "deptmanager";
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
    public String listPage(int page, int limit, String deptName) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
//        result.put("msg","");
        result.put("count", deptService.getCount(deptName));
        result.put("data", deptService.queryAllByLimit((page - 1) * limit, limit, deptName));
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
    public boolean save(Dept dept) {
        return deptService.insert(dept);
    }



    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(Dept dept){
        return deptService.update(dept);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "removeBatch")
    @ResponseBody
    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
        return deptService.removeBatch(ids);
    }
}