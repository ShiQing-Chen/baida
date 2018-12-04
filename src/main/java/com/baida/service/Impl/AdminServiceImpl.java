package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.AdminDAO;
import com.baida.model.Admin;
import com.baida.service.AdminService;
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

public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminDAO adminDAO;


    @Override
    public PagerList<Admin> getListByPage(int pageNum) {
        return adminDAO.getListByPage(pageNum);
    }

    @Override
    public List<Admin> getList() {
        return adminDAO.getList();
    }

    @Override
    public List<Admin> getListByName(String adminName) {
        return adminDAO.getListByName(adminName);
    }

    @Override
    public MessageVo addAdmin(Admin admin) {
        MessageVo messageVo = new MessageVo();
        if (adminDAO.getListByName(admin.getAdminName()).size()!=0){
            messageVo.setSuccess(false);
            messageVo.setMessage("添加失败！");
            logger.info(">>>>>>add  faild>>>>>>{}"+admin.toString());
        }else {
            admin.setCreateTime(DateUtils.getNowTimestamp());
            adminDAO.save(admin);
            messageVo.setSuccess(true);
            messageVo.setMessage("添加成功！");
            logger.info(">>>>>>add  success>>>>>>{}"+admin.toString());
        }
        return messageVo;
    }

    @Override
    public MessageVo changeAdmin(Admin admin) {
        MessageVo messageVo = new MessageVo();
        if (adminDAO.get(admin.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+admin.toString());
        }else {
            admin.setUpdateTime(DateUtils.getNowTimestamp());
            adminDAO.update(admin);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+admin.toString());
        }
        return messageVo;
    }

    @Override
    public MessageVo deleteAdmin(String id) {
        MessageVo messageVo = new MessageVo();
        Admin admin = adminDAO.get(id);
        if (admin == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+admin.toString());
        }else {
            adminDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+admin.toString());
        }
        return messageVo;
    }
}
