package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.OrderDAO;
import com.baida.model.Order;
import com.baida.service.OrderService;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:33
 */

public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDAO orderDAO;


    @Override
    public PagerList<Order> getListByPage(int pageNum) {
        return orderDAO.getListByPage(pageNum);
    }

    @Override
    public List<Order> getList() {
        return orderDAO.getList();
    }

    @Override
    public PagerList<Order> getListByPageAndPlaceTime(int pageNum, Timestamp placeTime) {
        return orderDAO.getListByPageAndPlaceTime(pageNum, placeTime);
    }

    @Override
    public List<Order> getListByPlaceTime(Timestamp placeTime) {
        return null;
    }

    @Override
    public PagerList<Order> getListByPageAndStatus(int pageNum, Integer orderStatus) {
        return null;
    }

    @Override
    public List<Order> getListByStatus(Integer orderStatus) {
        return null;
    }

    @Override
    public MessageVo addOrder(Order order) {
        return null;
    }

    @Override
    public MessageVo changeOrder(Order order) {
        return null;
    }

    @Override
    public MessageVo deleteOrder(String id) {
        return null;
    }
}
