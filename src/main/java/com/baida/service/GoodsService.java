package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Goods;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:06
 */

public interface GoodsService {

    //分页查询
    public PagerList<Goods> getListByPage(int pageNum);

    //List查询
    public List<Goods> getList();

    //根据类别分页查询
    public PagerList<Goods> getListByPageAndClass(int pageNum, String classId);

    //根据类别list查询
    public List<Goods> getListByClass(String classId);

    //根据店铺分页查询
    public PagerList<Goods> getListByPageAndShop(int pageNum, String shopId);

    //根据店铺list查询
    public List<Goods> getListByShop(String shopId);

    //根据商品状态分页查询
    public PagerList<Goods> getListByPageAndStatus(int pageNum, Integer goodsStatus);

    //根据商品状态list查询
    public List<Goods> getListByStatus(Integer goodsStatus);

    //根据是否打折分页查询
    public PagerList<Goods> getListByPageAndDiscount(int pageNum, Integer isDiscount);

    //根据是否打折list查询
    public List<Goods> getListByDiscount(Integer isDiscount);

    //根据商品名字list查询
    public List<Goods> getListByName(String goodsName);

    //添加
    MessageVo addGoods(Goods goods);

    //修改
    MessageVo changeGoods(Goods goods);

    //删除
    MessageVo deleteGoods(String id);
}
