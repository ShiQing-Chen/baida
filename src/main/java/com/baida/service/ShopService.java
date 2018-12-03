package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Shop;
import com.baida.vo.MessageVo;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 16:41
 */

public interface ShopService {

    //分页查询 排序
    PagerList<Shop> getListByPage(int pageNum, boolean isOrder);

    //List查询 排序
    List<Shop> getList(boolean isOrder);

    //根据名字查询
    List<Shop> getListByName(String shopName);

    //根据地区查询
    List<Shop> getListByAddress(String shopAddress);

    //添加
    MessageVo addShop(Shop shop);

    //修改
    MessageVo changeShop(Shop shop);

    //删除
    MessageVo deleteShop(String id);


}
