package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.Goods;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public List<Tree> queryTree() {
        List<Tree> treeList = queryTreeByPid(0);
        return treeList;
    }

    @Override
    public HashMap<String, Object> queryGoods(Integer page, Integer rows) {
        page = (page-1)*rows;
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = userMapper.queryGoodsSum();
        List<Goods> goodsList = userMapper.queryGoodsList(page,rows);
        map.put("rows",goodsList);
        map.put("total",sum);
        return map;
    }

    @Override
    public void saveGoods(Goods goods) {
        userMapper.saveGoods(goods);
    }


    private List<Tree> queryTreeByPid(Integer id){
        List<Tree> treeList = userMapper.queryTreeList(id);
        for (Tree tree : treeList) {
            List<Tree> nodeList = queryTreeByPid(tree.getId());
            if(nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }

        }
        return treeList;
    }

}
