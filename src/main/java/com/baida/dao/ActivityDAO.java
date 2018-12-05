package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Activity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:13
 */

@Repository
public class ActivityDAO extends HibernateDao<Activity, String> {

    //分页查询
    public PagerList<Activity> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
        dc.addOrder(Order.desc("activityStatus"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Activity> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
        dc.addOrder(Order.desc("activityStatus"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据title查询
    public List<Activity> getListByName(String activityTitle){
        DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
        dc.add(Restrictions.eq("activityTitle", activityTitle));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Activity getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Activity.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
