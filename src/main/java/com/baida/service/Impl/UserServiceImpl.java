package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.UserDAO;
import com.baida.model.User;
import com.baida.service.UserService;
import com.baida.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 16:33
 */

public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;


    @Override
    public PagerList<User> getListByPage(int pageNum) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public List<User> getListByName(String userName) {
        return null;
    }

    @Override
    public MessageVo addUser(User user) {
        return null;
    }

    @Override
    public MessageVo changeUser(User user) {
        return null;
    }

    @Override
    public MessageVo deleteUser(String id) {
        return null;
    }
}
