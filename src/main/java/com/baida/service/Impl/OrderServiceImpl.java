package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.OrderDAO;
import com.baida.model.Order;
import com.baida.service.OrderService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:33
 */

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDAO orderDAO;


    @Override
    @Transactional(readOnly = true)
    public PagerList<Order> getListByPage(int pageNum) {
        return orderDAO.getListByPage(pageNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getList() {
        return orderDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public PagerList<Order> getListByPageAndPlaceTime(int pageNum, Timestamp placeTime) {
        return orderDAO.getListByPageAndPlaceTime(pageNum, placeTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getListByPlaceTime(Timestamp placeTime) {
        return orderDAO.getListByPlaceTime(placeTime);
    }

    @Override
    @Transactional(readOnly = true)
    public PagerList<Order> getListByPageAndStatus(int pageNum, Integer orderStatus) {
        return orderDAO.getListByPageAndStatus(pageNum, orderStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getListByStatus(Integer orderStatus) {
        return orderDAO.getListByStatus(orderStatus);
    }

    @Override
    @Transactional
    public MessageVo addOrder(Order order) {
        MessageVo messageVo = new MessageVo();
        order.setCreateTime(DateUtils.getNowTimestamp());
        orderDAO.save(order);
        messageVo.setSuccess(true);
        messageVo.setMessage("添加成功！");
        logger.info(">>>>>>add  success>>>>>>{}"+order.toString());
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeOrder(Order order) {
        MessageVo messageVo = new MessageVo();
        if (orderDAO.get(order.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+order.toString());
        }else {
            order.setUpdateTime(DateUtils.getNowTimestamp());
            orderDAO.update(order);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+order.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteOrder(String id) {
        MessageVo messageVo = new MessageVo();
        Order order = orderDAO.get(id);
        if (order == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+order.toString());
        }else {
            orderDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+order.toString());
        }
        return messageVo;
    }
}
