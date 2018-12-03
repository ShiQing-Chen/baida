package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */

/** 活动 */
@Entity
public class Activity {


    /** 活动id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 活动类型 0为平台活动 1位商铺活动 默认0*/
    private Integer activityType;

    /** 活动标题 */
    private String activityTitle;

    /** 活动状态  1为上线 0位下线 默认0*/
    private Integer activityStatus;

    /** 开始时间 */
    private Timestamp startTime;

    /** 结束时间 */
    private Timestamp endTime;

    /** 活动描述 */
    private String activityDesc;

    /** 活动logo */
    private String activityPath;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SHOP_ID", nullable = true, length = 36)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "ACTIVITY_TYPE", nullable = true)
    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    @Basic
    @Column(name = "ACTIVITY_TITLE", nullable = true, length = 50)
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Basic
    @Column(name = "ACTIVITY_STATUS", nullable = true)
    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Basic
    @Column(name = "START_TIME", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "END_TIME", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "ACTIVITY_DESC", nullable = true, length = 500)
    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    @Basic
    @Column(name = "ACTIVITY_PATH", nullable = true, length = 200)
    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != null ? !id.equals(activity.id) : activity.id != null) return false;
        if (shopId != null ? !shopId.equals(activity.shopId) : activity.shopId != null) return false;
        if (activityType != null ? !activityType.equals(activity.activityType) : activity.activityType != null)
            return false;
        if (activityTitle != null ? !activityTitle.equals(activity.activityTitle) : activity.activityTitle != null)
            return false;
        if (activityStatus != null ? !activityStatus.equals(activity.activityStatus) : activity.activityStatus != null)
            return false;
        if (startTime != null ? !startTime.equals(activity.startTime) : activity.startTime != null) return false;
        if (endTime != null ? !endTime.equals(activity.endTime) : activity.endTime != null) return false;
        if (activityDesc != null ? !activityDesc.equals(activity.activityDesc) : activity.activityDesc != null)
            return false;
        if (activityPath != null ? !activityPath.equals(activity.activityPath) : activity.activityPath != null)
            return false;
        if (createTime != null ? !createTime.equals(activity.createTime) : activity.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(activity.updateTime) : activity.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (activityType != null ? activityType.hashCode() : 0);
        result = 31 * result + (activityTitle != null ? activityTitle.hashCode() : 0);
        result = 31 * result + (activityStatus != null ? activityStatus.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (activityDesc != null ? activityDesc.hashCode() : 0);
        result = 31 * result + (activityPath != null ? activityPath.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", shopId='" + shopId + '\'' +
                ", activityType=" + activityType +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityStatus=" + activityStatus +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", activityDesc='" + activityDesc + '\'' +
                ", activityPath='" + activityPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
