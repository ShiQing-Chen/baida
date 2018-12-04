package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.config.Constant;
import com.baida.model.User;
import com.baida.vo.MessageVo;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:14
 */

public interface UserService {

    //分页查询
    public PagerList<User> getListByPage(int pageNum);

    //List查询
    public List<User> getList();

    //根据name查询
    public List<User> getListByName(String userName);

    //添加
    MessageVo addUser(User user);

    //修改
    MessageVo changeUser(User user);

    //删除
    MessageVo deleteUser(String id);
}
