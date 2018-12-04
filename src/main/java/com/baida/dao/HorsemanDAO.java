package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Horseman;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:52
 */

public class HorsemanDAO extends HibernateDao<Horseman, String> {

    //分页查询
    public PagerList<Horseman> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Horseman.class);
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Horseman> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Horseman.class);
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据名字查询
    public List<Horseman> getListByName(String manName){
        DetachedCriteria dc = DetachedCriteria.forClass(Horseman.class);
        dc.add(Restrictions.eq("manName", manName));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Horseman getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Horseman.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
