package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Admin;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:55
 */

public interface AdminService {

    //分页查询
    public PagerList<Admin> getListByPage(int pageNum);

    //List查询
    public List<Admin> getList();

    //根据用户名查询
    public List<Admin> getListByName(String adminName);

    //添加
    MessageVo addAdmin(Admin admin);

    //修改
    MessageVo changeAdmin(Admin admin);

    //删除
    MessageVo deleteAdmin(String id);
}
