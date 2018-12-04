package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Goodsclass;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:08
 */

public interface GoodsclassService {

    //分页查询
    public PagerList<Goodsclass> getListByPage(int pageNum);

    //List查询
    public List<Goodsclass> getList();

    //根据状态分页查询
    public PagerList<Goodsclass> getListByPageAndStatus(int pageNum, Integer classStatus);

    //根据状态list查询
    public List<Goodsclass> getListByStatus(Integer classStatus);

    //根据title查询
    public List<Goodsclass> getListByName(String className);

    //根据店铺分页查询
    public PagerList<Goodsclass> getListByPageAndShop(int pageNum, String shopId);

    //根据店铺list查询
    public List<Goodsclass> getListByShop(String shopId);

    //添加
    MessageVo addGoodsclass(Goodsclass goodsclass);

    //修改
    MessageVo changeGoodsclass(Goodsclass goodsclass);

    //删除
    MessageVo deleteGoodsclass(String id);
}
