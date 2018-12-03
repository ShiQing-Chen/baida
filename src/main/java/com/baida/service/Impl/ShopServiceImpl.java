package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.ShopDAO;
import com.baida.model.Shop;
import com.baida.service.ShopService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.cert.TrustAnchor;
import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 16:41
 */

@Service
public class ShopServiceImpl implements ShopService{
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);


    @Autowired
    private ShopDAO shopDAO;

    @Override
    @Transactional(readOnly = true)
    public PagerList<Shop> getListByPage(int pageNum, boolean isOrder) {
        return shopDAO.getListByPage(pageNum, isOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getList(boolean isOrder) {
        return shopDAO.getList(isOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getListByName(String shopName) {
        return shopDAO.getListByName(shopName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shop> getListByAddress(String shopAddress) {
        return shopDAO.getListByAddress(shopAddress);
    }

    @Override
    @Transactional
    public MessageVo addShop(Shop shop) {
        MessageVo messageVo = new MessageVo();
        if (shopDAO.getListByName(shop.getShopName()).size()!=0){
            messageVo.setSuccess(false);
            messageVo.setMessage("添加失败！");
            logger.info(">>>>>>add  faild>>>>>>{}"+shop.toString());
        }else {
            shop.setCreateTime(DateUtils.getNowTimestamp());
            shopDAO.save(shop);
            messageVo.setSuccess(true);
            messageVo.setMessage("添加成功！");
            logger.info(">>>>>>add  success>>>>>>{}"+shop.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeShop(Shop shop) {
        MessageVo messageVo = new MessageVo();
        if (shopDAO.get(shop.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+shop.toString());
        }else {
            shop.setUpdateTime(DateUtils.getNowTimestamp());
            shopDAO.update(shop);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+shop.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteShop(String id) {
        MessageVo messageVo = new MessageVo();
        Shop shop = shopDAO.get(id);
        if (shop == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+shop.toString());
        }else {
            shopDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+shop.toString());
        }
        return messageVo;
    }
}
