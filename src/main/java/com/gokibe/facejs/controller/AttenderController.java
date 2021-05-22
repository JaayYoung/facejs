package com.gokibe.facejs.controller;

import com.gokibe.facejs.entity.Attender;
import com.gokibe.facejs.service.AttenderService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 考勤人信息(Attender)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:10:30
 */
@Controller
@RequestMapping("attender")
public class AttenderController {
    /**
     * 服务对象
     */
    @Resource
    private AttenderService attenderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Attender selectOne(Integer id) {
        return this.attenderService.queryById(id);
    }


    @RequestMapping(value = "/face")
    public String addfacemark(){
        return "face";
    }




    @RequestMapping(value = "/index")
    public String attenderIndex() {
        return "attendermanager";
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
    public String listPage(int page, int limit, String attName,Integer attNum) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
//        result.put("msg","");
        result.put("count", attenderService.getCount(attName,attNum));
        result.put("data", attenderService.queryAllByLimit((page - 1) * limit, limit, attName,attNum));
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
    public boolean save(Attender attender) {
        return attenderService.insert(attender);
    }

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(Attender attender){
        return attenderService.update(attender);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "removeBatch")
    @ResponseBody
    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
        return attenderService.removeBatch(ids);
    }

}