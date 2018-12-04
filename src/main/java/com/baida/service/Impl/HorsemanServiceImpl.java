package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.HorsemanDAO;
import com.baida.model.Horseman;
import com.baida.service.HorsemanService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:32
 */

@Service
public class HorsemanServiceImpl implements HorsemanService {

    private static final Logger logger = LoggerFactory.getLogger(HorsemanServiceImpl.class);

    @Autowired
    HorsemanDAO horsemanDAO;


    @Override
    @Transactional(readOnly = true)
    public PagerList<Horseman> getListByPage(int pageNum) {
        return horsemanDAO.getListByPage(pageNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horseman> getList() {
        return horsemanDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horseman> getListByName(String manName) {
        return horsemanDAO.getListByName(manName);
    }

    @Override
    @Transactional
    public MessageVo addHorseman(Horseman horseman) {
        MessageVo messageVo = new MessageVo();
        if (horsemanDAO.getListByName(horseman.getManName()).size()!=0){
            messageVo.setSuccess(false);
            messageVo.setMessage("添加失败！");
            logger.info(">>>>>>add  faild>>>>>>{}"+horseman.toString());
        }else {
            horseman.setCreateTime(DateUtils.getNowTimestamp());
            horsemanDAO.save(horseman);
            messageVo.setSuccess(true);
            messageVo.setMessage("添加成功！");
            logger.info(">>>>>>add  success>>>>>>{}"+horseman.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeHorseman(Horseman horseman) {
        MessageVo messageVo = new MessageVo();
        if (horsemanDAO.get(horseman.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+horseman.toString());
        }else {
            horseman.setUpdateTime(DateUtils.getNowTimestamp());
            horsemanDAO.update(horseman);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+horseman.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteHorseman(String id) {
        MessageVo messageVo = new MessageVo();
        Horseman horseman = horsemanDAO.get(id);
        if (horseman == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+horseman.toString());
        }else {
            horsemanDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+horseman.toString());
        }
        return messageVo;
    }
}
