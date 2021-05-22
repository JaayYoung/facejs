package com.gokibe.facejs.controller;

import com.gokibe.facejs.entity.Facefeature;
import com.gokibe.facejs.service.FacefeatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (Facefeature)表控制层
 *
 * @author makejava
 * @since 2021-04-10 22:10:34
 */
@Controller
@RequestMapping("facefeature")
public class FacefeatureController {
    /**
     * 服务对象
     */
    @Resource
    private FacefeatureService facefeatureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Facefeature selectOne(Integer id) {
        return this.facefeatureService.queryById(id);
    }

    @RequestMapping(value = "/index")
    public String attenderIndex() {
        return "facefeaturemanager";
    }
    /**
     * 添加用户信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public boolean save( Facefeature facefeature) {
        return facefeatureService.insert(facefeature);
    }

    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(Facefeature facefeature){
        return facefeatureService.update(facefeature);
    }


    @RequestMapping(value = "/addface")
    public String addface(){
        return "addface";
    }

    /**
     * 跳转到人脸录入页面
     * @param model
     * @param attid
     * @return
     */
    @RequestMapping(value = "/toface")
    public String toface(Model model,Integer attid){
        model.addAttribute("attid",attid);
        return "face";
    }


    @RequestMapping(value = "getface")
    @ResponseBody
    public boolean saveface(@RequestParam(value = "arr[]") String arr[],@RequestParam(value = "attid")Integer aid) throws Exception {
        boolean flag = facefeatureService.saveface(aid, arr);
        return flag;
    }

//    /**
//     * 批量删除
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "removeBatch")
//    @ResponseBody
//    public boolean removeBatch(@RequestParam(value = "ids[]") String ids[]){
//        return facefeatureService.removeBatch(ids);
//    }

}