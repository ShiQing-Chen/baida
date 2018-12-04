package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:53
 */

public class UserDAO extends HibernateDao<User, String> {

    //分页查询
    public PagerList<User> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<User> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据name查询
    public List<User> getListByName(String userName){
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("userName", userName));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public User getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
