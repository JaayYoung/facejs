package com.gokibe.facejs.controller;

import com.gokibe.facejs.entity.Active;
import com.gokibe.facejs.entity.User;
import com.gokibe.facejs.service.ActiveService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 考勤活动表
 * (Active)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:09:59
 */
@Controller
@RequestMapping("active")
public class ActiveController {
    /**
     * 服务对象
     */
    @Resource
    private ActiveService activeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Active selectOne(Integer id) {
        return this.activeService.queryById(id);
    }

    @RequestMapping(value = "/index")
    public String attenderIndex() {
        return "activemanager";
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
    public String listPage(int page, int limit, String actname) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
//        result.put("msg","");
        result.put("count", activeService.getCount(actname));
        result.put("data", activeService.queryAllByLimit((page - 1) * limit, limit, actname));
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
    public boolean save(Active active ) {
        return activeService.insert(active);
    }

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(Active active ){
        return activeService.update(active);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "removeBatch")
    @ResponseBody
    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
        return activeService.removeBatch(ids);
    }

}