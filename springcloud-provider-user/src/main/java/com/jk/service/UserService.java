package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.Tree;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<Tree> queryTree();

    HashMap<String, Object> queryGoods(Integer page, Integer rows);

    void saveGoods(Goods goods);

}
