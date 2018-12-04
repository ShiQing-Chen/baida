package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Order;
import com.baida.vo.MessageVo;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:13
 */

public interface OrderService {

    //分页查询
    public PagerList<Order> getListByPage(int pageNum);

    //List查询
    public List<Order> getList();

    //根据下单时间分页查询
    public PagerList<Order> getListByPageAndPlaceTime(int pageNum, Timestamp placeTime);

    //根据下单时间list查询
    public List<Order> getListByPlaceTime(Timestamp placeTime);

    //根据状态分页查询
    public PagerList<Order> getListByPageAndStatus(int pageNum, Integer orderStatus);

    //根据状态list查询
    public List<Order> getListByStatus(Integer orderStatus);

    //添加
    MessageVo addOrder(Order order);

    //修改
    MessageVo changeOrder(Order order);

    //删除
    MessageVo deleteOrder(String id);
}
