package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.service.UserService;
import com.jk.service.user.UserServiceFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController implements UserServiceFeign {


    @Value("${1904b.api-a.hi}")
    String name;


    @Resource
    private UserService userService;

    @GetMapping("test")
    public void test() {
        System.out.println("进来了");
    }

    @GetMapping("queryTree")
    public List<Tree> queryTree() {
        return userService.queryTree();
    }

    @GetMapping("queryGoods")
    public HashMap<String, Object> queryGoods(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows) {
        return userService.queryGoods(page,rows);
    }

    @PostMapping("saveGoods")
    public String saveGoods(@RequestBody Goods goods) {

         userService.saveGoods(goods);

         return "新增成功";
    }

    @GetMapping("testConfig")
    public String testConfig() {
        return name;
    }
}
