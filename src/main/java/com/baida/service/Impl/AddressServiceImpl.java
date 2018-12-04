package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.AddressDAO;
import com.baida.model.Activity;
import com.baida.model.Address;
import com.baida.service.AddressService;
import com.baida.utils.DateUtils;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:31
 */

public class AddressServiceImpl implements AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    AddressDAO addressDAO;


    @Override
    public PagerList<Address> getListByPage(int pageNum) {
        return addressDAO.getListByPage(pageNum);
    }

    @Override
    public List<Address> getList() {
        return addressDAO.getList();
    }

    @Override
    public MessageVo addAddress(Address address) {
        MessageVo messageVo = new MessageVo();
        address.setCreateTime(DateUtils.getNowTimestamp());
        addressDAO.save(address);
        messageVo.setSuccess(true);
        messageVo.setMessage("添加成功！");
        logger.info(">>>>>>add  success>>>>>>{}"+address.toString());
        return messageVo;
    }

    @Override
    public MessageVo changeAddress(Address address) {
        MessageVo messageVo = new MessageVo();
        if (addressDAO.get(address.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+address.toString());
        }else {
            address.setUpdateTime(DateUtils.getNowTimestamp());
            addressDAO.update(address);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+address.toString());
        }
        return messageVo;
    }

    @Override
    public MessageVo deleteAddress(String id) {
        MessageVo messageVo = new MessageVo();
        Address address = addressDAO.get(id);
        if (address == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+address.toString());
        }else {
            addressDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+address.toString());
        }
        return messageVo;
    }
}
