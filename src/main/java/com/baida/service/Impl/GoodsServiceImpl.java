package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.GoodsDAO;
import com.baida.model.Goods;
import com.baida.service.GoodsService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:32
 */

public class GoodsServiceImpl implements GoodsService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    GoodsDAO goodsDAO;

    @Override
    public PagerList<Goods> getListByPage(int pageNum) {
        return goodsDAO.getListByPage(pageNum);
    }

    @Override
    public List<Goods> getList() {
        return goodsDAO.getList();
    }

    @Override
    public PagerList<Goods> getListByPageAndClass(int pageNum, String classId) {
        return goodsDAO.getListByPageAndClass(pageNum, classId);
    }

    @Override
    public List<Goods> getListByClass(String classId) {
        return goodsDAO.getListByClass(classId);
    }

    @Override
    public PagerList<Goods> getListByPageAndShop(int pageNum, String shopId) {
        return goodsDAO.getListByPageAndShop(pageNum, shopId);
    }

    @Override
    public List<Goods> getListByShop(String shopId) {
        return goodsDAO.getListByShop(shopId);
    }

    @Override
    public PagerList<Goods> getListByPageAndStatus(int pageNum, Integer goodsStatus) {
        return goodsDAO.getListByPageAndStatus(pageNum, goodsStatus);
    }

    @Override
    public List<Goods> getListByStatus(Integer goodsStatus) {
        return goodsDAO.getListByStatus(goodsStatus);
    }

    @Override
    public PagerList<Goods> getListByPageAndDiscount(int pageNum, Integer isDiscount) {
        return goodsDAO.getListByPageAndDiscount(pageNum, isDiscount);
    }

    @Override
    public List<Goods> getListByDiscount(Integer isDiscount) {
        return goodsDAO.getListByDiscount(isDiscount);
    }

    @Override
    public List<Goods> getListByName(String goodsName) {
        return goodsDAO.getListByName(goodsName);
    }

    @Override
    public MessageVo addGoods(Goods goods) {
        MessageVo messageVo = new MessageVo();
        goods.setCreateTime(DateUtils.getNowTimestamp());
        goodsDAO.save(goods);
        messageVo.setSuccess(true);
        messageVo.setMessage("添加成功！");
        logger.info(">>>>>>add  success>>>>>>{}"+goods.toString());
        return messageVo;
    }

    @Override
    public MessageVo changeGoods(Goods goods) {
        MessageVo messageVo = new MessageVo();
        if (goodsDAO.get(goods.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+goods.toString());
        }else {
            goods.setUpdateTime(DateUtils.getNowTimestamp());
            goodsDAO.update(goods);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+goods.toString());
        }
        return messageVo;
    }

    @Override
    public MessageVo deleteGoods(String id) {
        MessageVo messageVo = new MessageVo();
        Goods goods = goodsDAO.get(id);
        if (goods == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+goods.toString());
        }else {
            goodsDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+goods.toString());
        }
        return messageVo;
    }
}
