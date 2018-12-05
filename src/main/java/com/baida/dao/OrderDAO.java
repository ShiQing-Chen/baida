package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Order;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:52
 */

@Repository
public class OrderDAO extends HibernateDao<Order, String> {

    //分页查询
    public PagerList<Order> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Order> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据下单时间分页查询
    public PagerList<Order> getListByPageAndPlaceTime(int pageNum, Timestamp placeTime){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("placeTime", placeTime));
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据下单时间list查询
    public List<Order> getListByPlaceTime(Timestamp placeTime){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("placeTime", placeTime));
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据状态分页查询
    public PagerList<Order> getListByPageAndStatus(int pageNum, Integer orderStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("orderStatus", orderStatus));
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据状态list查询
    public List<Order> getListByStatus(Integer orderStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("orderStatus", orderStatus));
        dc.addOrder(org.hibernate.criterion.Order.desc("placeTime"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Order getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
