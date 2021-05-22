package com.gokibe.facejs.controller;

import com.gokibe.facejs.entity.Attendrecord;
import com.gokibe.facejs.entity.User;
import com.gokibe.facejs.service.AttendrecordService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Attendrecord)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:10:31
 */
@Controller
@RequestMapping("attendrecord")
public class AttendrecordController {
    /**
     * 服务对象
     */
    @Resource
    private AttendrecordService attendrecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Attendrecord selectOne(Integer id) {
        return this.attendrecordService.queryById(id);
    }

    @RequestMapping(value = "/index")
    public String attenderIndex() {
        return "attendercordmanager";
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
    public String listPage(int page, int limit,  String username) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
//        result.put("msg","");
        result.put("count", attendrecordService.getCount());
        result.put("data", attendrecordService.queryAllByLimit((page - 1) * limit, limit));
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
    public boolean save(Attendrecord attendrecord) {
        return attendrecordService.insert(attendrecord);
    }

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(Attendrecord attendrecord){
        return attendrecordService.update(attendrecord);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "removeBatch")
    @ResponseBody
    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
        return attendrecordService.removeBatch(ids);
    }
    @RequestMapping(value = "faceRefirst")
    public String facefirst(){
        return  "faceRefirst";
    }
    @RequestMapping(value = "faceRe")
    public String getface(Model model,Integer actid) throws Exception {
        attendrecordService.getface(model,actid);
        return "faceRecognition";
    }

    @RequestMapping(value = "addrecord")
    @ResponseBody
    public boolean addrecord(@RequestParam("attid") Integer attid,@RequestParam("actid")  Integer actid){
        return attendrecordService.addrecord(attid,actid);
    }

}