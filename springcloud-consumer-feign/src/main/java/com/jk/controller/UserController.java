package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.service.user.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserServiceFeign userServiceFeign;

    @RequestMapping("testConfig")
    @ResponseBody
    public String testConfig(){
        return userServiceFeign.testConfig();
    }

    @RequestMapping("test")
    public void test(){
        userServiceFeign.test();
    }

    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        return userServiceFeign.queryTree();
    }

    //跳主页
    @RequestMapping("toIndex")
    public String toInde(){
        return "index";
    }

    //商品查询  分页
    @RequestMapping("queryGoods")
    @ResponseBody
    public HashMap<String,Object> queryGoods(Integer page, Integer rows, HttpServletResponse response) throws IOException {

        HashMap<String, Object> map = userServiceFeign.queryGoods(page,rows);

        if(map==null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }

        return map;
    }

    //跳查询页
    @RequestMapping("toquery")
    public String toquery(){
        return "query";
    }


    //条新增弹框 页面
    @RequestMapping("toAddGoods")
    public String toAddGoods(){
        return "add";
    }

    //新增商品
    @RequestMapping("saveGoods")
    @ResponseBody
    public String saveGoods(Goods goods){

        return   userServiceFeign.saveGoods(goods);
    }

}
