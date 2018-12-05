package com.baida.dao;

import com.baida.common.hibernate.HibernateDao;
import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.Goods;
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
public class GoodsDAO extends HibernateDao<Goods, String> {

    //分页查询
    public PagerList<Goods> getListByPage(int pageNum){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.addOrder(Order.desc("goodsHeat"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //List查询
    public List<Goods> getList(){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据类别分页查询
    public PagerList<Goods> getListByPageAndClass(int pageNum, String classId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("classId", classId));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据类别list查询
    public List<Goods> getListByClass(String classId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("classId", classId));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据店铺分页查询
    public PagerList<Goods> getListByPageAndShop(int pageNum, String shopId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("shopId", shopId));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据店铺list查询
    public List<Goods> getListByShop(String shopId){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("shopId", shopId));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据商品状态分页查询
    public PagerList<Goods> getListByPageAndStatus(int pageNum, Integer goodsStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("goodsStatus", goodsStatus));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据商品状态list查询
    public List<Goods> getListByStatus(Integer goodsStatus){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("goodsStatus", goodsStatus));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据是否打折分页查询
    public PagerList<Goods> getListByPageAndDiscount(int pageNum, Integer isDiscount){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("isDiscount", isDiscount));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.pagerByCriteria(dc,pageNum, Constant.DEFAULT_PAGE_SIZE);
    }

    //根据是否打折list查询
    public List<Goods> getListByDiscount(Integer isDiscount){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("isDiscount", isDiscount));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据商品名字list查询
    public List<Goods> getListByName(String goodsName){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("goodsName", goodsName));
        dc.addOrder(Order.desc("goodsHeat"));
        return super.findByCriteria(dc, 0, Constant.MAX_PAGE_SIZE);
    }

    //根据ID查询
    public Goods getById(String id){
        DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
        dc.add(Restrictions.eq("id", id));
        return super.uniqueResult(dc);
    }

}
