package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.UserDAO;
import com.baida.model.User;
import com.baida.service.UserService;
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
 * @date 2018/12/4 16:33
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;


    @Override
    @Transactional(readOnly = true)
    public PagerList<User> getListByPage(int pageNum) {
        return userDAO.getListByPage(pageNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListByName(String userName) {
        return userDAO.getListByName(userName);
    }

    @Override
    @Transactional
    public MessageVo addUser(User user) {
        MessageVo messageVo = new MessageVo();
        if (userDAO.getListByName(user.getUserName()).size()!=0){
            messageVo.setSuccess(false);
            messageVo.setMessage("添加失败！");
            logger.info(">>>>>>add  faild>>>>>>{}"+user.toString());
        }else {
            user.setCreateTime(DateUtils.getNowTimestamp());
            userDAO.save(user);
            messageVo.setSuccess(true);
            messageVo.setMessage("添加成功！");
            logger.info(">>>>>>add  success>>>>>>{}"+user.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeUser(User user) {
        MessageVo messageVo = new MessageVo();
        if (userDAO.get(user.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+user.toString());
        }else {
            user.setUpdateTime(DateUtils.getNowTimestamp());
            userDAO.update(user);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+user.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteUser(String id) {
        MessageVo messageVo = new MessageVo();
        User user = userDAO.get(id);
        if (user == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+user.toString());
        }else {
            userDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+user.toString());
        }
        return messageVo;
    }
}
