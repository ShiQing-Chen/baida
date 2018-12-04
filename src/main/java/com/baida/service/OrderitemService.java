package com.baida.service;

import com.baida.model.Orderitem;
import com.baida.vo.MessageVo;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:13
 */

public interface OrderitemService {

    //List查询
    public List<Orderitem> getList();

    //根据状态list查询
    public List<Orderitem> getListByOrder(String orderId);

    //添加
    MessageVo addOrderitem(Orderitem orderitem);

    //修改
    MessageVo changeOrderitem(Orderitem orderitem);

    //删除
    MessageVo deleteOrderitem(String id);
}
