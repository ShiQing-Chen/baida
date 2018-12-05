package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Address;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 18:14
 */

@Repository
public class AddressDAO extends HibernateDao<Address, String> {

    //分页查询
    public PagerList<Address> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Address.class);
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Address> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Address.class);
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据order查询
    public List<Address> getListByOrder(String orderId){
        DetachedCriteria dc = DetachedCriteria.forClass(Address.class);
        dc.add(Restrictions.eq("orderId", orderId));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Address getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Address.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }
}
