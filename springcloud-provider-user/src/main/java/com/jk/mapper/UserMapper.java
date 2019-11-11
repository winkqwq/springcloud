package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<Tree> queryTreeList(Integer id);

    Integer queryGoodsSum();

    List<Goods> queryGoodsList(@Param("page") Integer page, @Param("rows")Integer rows);

    void saveGoods(Goods goods);
}
