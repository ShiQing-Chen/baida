package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Shop;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 14:23
 */

@Repository
public class ShopDAO extends HibernateDao<Shop, String> {

    //分页查询 排序
    public PagerList<Shop> getListByPage(int pageNum, boolean isOrder){
        DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
        if (isOrder == true){
            dc.addOrder(Order.asc("shopHeat"));
        }
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询 排序
    public List<Shop> getList(boolean isOrder){
        DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
        if (isOrder == true){
            dc.addOrder(Order.asc("shopHeat"));
        }
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据名字查询
    public List<Shop> getListByName(String shopName){
        DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
        dc.add(Restrictions.eq("shopName", shopName));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据地区查询
    public List<Shop> getListByAddress(String shopAddress){
        DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
        dc.add(Restrictions.eq("shopAddress", shopAddress));
        dc.addOrder(Order.asc("shopHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Shop getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }

}
