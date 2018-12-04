package com.baida.service.Impl;

import com.baida.dao.OrderitemDAO;
import com.baida.model.Orderitem;
import com.baida.service.OrderitemService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:32
 */

@Service
public class OrderitemServiceImpl implements OrderitemService {

    private static final Logger logger = LoggerFactory.getLogger(OrderitemServiceImpl.class);

    @Autowired
    OrderitemDAO orderitemDAO;


    @Override
    @Transactional(readOnly = true)
    public List<Orderitem> getList() {
        return orderitemDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orderitem> getListByOrder(String orderId) {
        return orderitemDAO.getListByOrder(orderId);
    }

    @Override
    @Transactional
    public MessageVo addOrderitem(Orderitem orderitem) {
        MessageVo messageVo = new MessageVo();
        if (orderitemDAO.getListByOrder(orderitem.getOrderId()).size()!=0){
            messageVo.setSuccess(false);
            messageVo.setMessage("添加失败！");
            logger.info(">>>>>>add  faild>>>>>>{}"+orderitem.toString());
        }else {
            orderitem.setCreateTime(DateUtils.getNowTimestamp());
            orderitemDAO.save(orderitem);
            messageVo.setSuccess(true);
            messageVo.setMessage("添加成功！");
            logger.info(">>>>>>add  success>>>>>>{}"+orderitem.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeOrderitem(Orderitem orderitem) {
        MessageVo messageVo = new MessageVo();
        if (orderitemDAO.get(orderitem.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+orderitem.toString());
        }else {
            orderitem.setUpdateTime(DateUtils.getNowTimestamp());
            orderitemDAO.update(orderitem);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+orderitem.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteOrderitem(String id) {
        MessageVo messageVo = new MessageVo();
        Orderitem orderitem = orderitemDAO.get(id);
        if (orderitem == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+orderitem.toString());
        }else {
            orderitemDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+orderitem.toString());
        }
        return messageVo;
    }
}
