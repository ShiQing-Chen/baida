package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.GoodsclassDAO;
import com.baida.model.Goodsclass;
import com.baida.service.GoodsclassService;
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

public class GoodsclassServiceImpl implements GoodsclassService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsclassServiceImpl.class);

    @Autowired
    GoodsclassDAO goodsclassDAO;


    @Override
    public PagerList<Goodsclass> getListByPage(int pageNum) {
        return goodsclassDAO.getListByPage(pageNum);
    }

    @Override
    public List<Goodsclass> getList() {
        return goodsclassDAO.getList();
    }

    @Override
    public PagerList<Goodsclass> getListByPageAndStatus(int pageNum, Integer classStatus) {
        return goodsclassDAO.getListByPageAndStatus(pageNum, classStatus);
    }

    @Override
    public List<Goodsclass> getListByStatus(Integer classStatus) {
        return goodsclassDAO.getListByStatus(classStatus);
    }

    @Override
    public List<Goodsclass> getListByName(String className) {
        return goodsclassDAO.getListByName(className);
    }

    @Override
    public PagerList<Goodsclass> getListByPageAndShop(int pageNum, String shopId) {
        return goodsclassDAO.getListByPageAndShop(pageNum, shopId);
    }

    @Override
    public List<Goodsclass> getListByShop(String shopId) {
        return goodsclassDAO.getListByShop(shopId);
    }

    @Override
    public MessageVo addGoodsclass(Goodsclass goodsclass) {
        MessageVo messageVo = new MessageVo();
        goodsclass.setCreateTime(DateUtils.getNowTimestamp());
        goodsclassDAO.save(goodsclass);
        messageVo.setSuccess(true);
        messageVo.setMessage("添加成功！");
        logger.info(">>>>>>add  success>>>>>>{}"+goodsclass.toString());
        return messageVo;
    }

    @Override
    public MessageVo changeGoodsclass(Goodsclass goodsclass) {
        MessageVo messageVo = new MessageVo();
        if (goodsclassDAO.get(goodsclass.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+goodsclass.toString());
        }else {
            goodsclass.setUpdateTime(DateUtils.getNowTimestamp());
            goodsclassDAO.update(goodsclass);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+goodsclass.toString());
        }
        return messageVo;
    }

    @Override
    public MessageVo deleteGoodsclass(String id) {
        MessageVo messageVo = new MessageVo();
        Goodsclass goodsclass = goodsclassDAO.get(id);
        if (goodsclass == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+goodsclass.toString());
        }else {
            goodsclassDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+goodsclass.toString());
        }
        return messageVo;
    }
}
