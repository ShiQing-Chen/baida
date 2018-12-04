package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Address;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:10
 */

public interface AddressService {

    //分页查询
    public PagerList<Address> getListByPage(int pageNum);

    //List查询
    public List<Address> getList();

    //添加
    MessageVo addAddress(Address address);

    //修改
    MessageVo changeAddress(Address address);

    //删除
    MessageVo deleteAddress(String id);
}
