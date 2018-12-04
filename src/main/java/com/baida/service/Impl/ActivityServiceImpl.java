package com.baida.service.Impl;

import com.baida.common.pager.PagerList;
import com.baida.dao.ActivityDAO;
import com.baida.model.Activity;
import com.baida.service.ActivityService;
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
 * @date 2018/12/4 16:31
 */

@Service
public class ActivityServiceImpl implements ActivityService{

    private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Autowired
    ActivityDAO activityDAO;

    @Override
    @Transactional(readOnly = true)
    public PagerList<Activity> getListByPage(int pageNum) {
        return activityDAO.getListByPage(pageNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> getList() {
        return activityDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> getListByName(String activityTitle) {
        return activityDAO.getListByName(activityTitle);
    }

    @Override
    @Transactional
    public MessageVo addActivity(Activity activity) {
        MessageVo messageVo = new MessageVo();
        activity.setCreateTime(DateUtils.getNowTimestamp());
        activityDAO.save(activity);
        messageVo.setSuccess(true);
        messageVo.setMessage("添加成功！");
        logger.info(">>>>>>add  success>>>>>>{}"+activity.toString());
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo changeActivity(Activity activity) {
        MessageVo messageVo = new MessageVo();
        if (activityDAO.get(activity.getId()) == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("更新失败！");
            logger.info(">>>>>>update  faild>>>>>>{}"+activity.toString());
        }else {
            activity.setUpdateTime(DateUtils.getNowTimestamp());
            activityDAO.update(activity);
            messageVo.setSuccess(true);
            messageVo.setMessage("更新成功！");
            logger.info(">>>>>>update  success>>>>>>{}"+activity.toString());
        }
        return messageVo;
    }

    @Override
    @Transactional
    public MessageVo deleteActivity(String id) {
        MessageVo messageVo = new MessageVo();
        Activity activity = activityDAO.get(id);
        if (activity == null){
            messageVo.setSuccess(false);
            messageVo.setMessage("删除失败！");
            logger.info(">>>>>>delete  faild>>>>>>{}"+activity.toString());
        }else {
            activityDAO.delete(id);
            messageVo.setSuccess(true);
            messageVo.setMessage("删除成功！");
            logger.info(">>>>>>delete  success>>>>>>{}"+activity.toString());
        }
        return messageVo;
    }
}
