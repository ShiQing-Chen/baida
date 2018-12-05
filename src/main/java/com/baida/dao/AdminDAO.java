package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Admin;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:16
 */

@Repository
public class AdminDAO extends HibernateDao<Admin, String> {

    //分页查询
    public PagerList<Admin> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Admin> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据用户名查询
    public List<Admin> getListByName(String adminName){
        DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
        dc.add(Restrictions.eq("adminName", adminName));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Admin getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
