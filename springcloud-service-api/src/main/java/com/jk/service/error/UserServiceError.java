package com.jk.service.error;

import com.jk.model.Goods;
import com.jk.model.Tree;
import com.jk.service.user.UserServiceFeign;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class UserServiceError implements UserServiceFeign {



    public void test() {

    }

    public List<Tree> queryTree() {
        return null;
    }

    public HashMap<String, Object> queryGoods(Integer page, Integer rows) {
        return null;
    }

    public String saveGoods(Goods goods) {
        return "新增失败";
    }

    public String testConfig() {
        return null;
    }
}
