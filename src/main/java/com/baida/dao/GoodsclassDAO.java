package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Goodsclass;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:16
 */

@Repository
public class GoodsclassDAO extends HibernateDao<Goodsclass, String> {


    //分页查询
    public PagerList<Goodsclass> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.addOrder(Order.asc("className"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Goodsclass> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.addOrder(Order.asc("className"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据状态分页查询
    public PagerList<Goodsclass> getListByPageAndStatus(int pageNum, Integer classStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("classStatus", classStatus));
        dc.addOrder(Order.asc("className"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据状态list查询
    public List<Goodsclass> getListByStatus(Integer classStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("classStatus", classStatus));
        dc.addOrder(Order.asc("className"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据title查询
    public List<Goodsclass> getListByName(String className){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("className", className));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据店铺分页查询
    public PagerList<Goodsclass> getListByPageAndShop(int pageNum, String shopId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("shopId", shopId));
        dc.addOrder(Order.asc("classNum"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据店铺list查询
    public List<Goodsclass> getListByShop(String shopId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("shopId", shopId));
        dc.addOrder(Order.asc("classNum"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Goodsclass getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Goodsclass.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
