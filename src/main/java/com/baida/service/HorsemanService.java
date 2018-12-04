package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Horseman;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:10
 */

public interface HorsemanService {

    //分页查询
    public PagerList<Horseman> getListByPage(int pageNum);

    //List查询
    public List<Horseman> getList();

    //根据名字查询
    public List<Horseman> getListByName(String manName);

    //添加
    MessageVo addHorseman(Horseman horseman);

    //修改
    MessageVo changeHorseman(Horseman horseman);

    //删除
    MessageVo deleteHorseman(String id);
}
