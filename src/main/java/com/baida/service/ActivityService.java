package com.baida.service;

import com.baida.common.pager.PagerList;
import com.baida.model.Activity;
import com.baida.vo.MessageVo;


import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:09
 */

public interface ActivityService {


    //分页查询
    public PagerList<Activity> getListByPage(int pageNum);

    //List查询
    public List<Activity> getList();

    //根据title查询
    public List<Activity> getListByName(String activityTitle);

    //添加
    MessageVo addActivity(Activity activity);

    //修改
    MessageVo changeActivity(Activity activity);

    //删除
    MessageVo deleteActivity(String id);
}
