package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Orderitem;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:53
 */

public class OrderitemDAO extends HibernateDao<Orderitem, String> {

    //List查询
    public List<Orderitem> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据状态list查询
    public List<Orderitem> getListByOrder(String orderId){
        DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
        dc.add(Restrictions.eq("orderId", orderId));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Orderitem getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
