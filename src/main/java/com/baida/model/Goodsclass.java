package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */

/** 菜单类别表 */
@Entity
public class Goodsclass {

    /** 菜单类别id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 类型名称 */
    private String className;

    /** 类别状态  1为使用 0为不使用 默认1*/
    private Integer classStatus;

    /** 类别顺序 */
    private Integer classNum;

    /** 类别描述 */
    private String classDesc;

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
    @Column(name = "CLASS_NAME", nullable = true, length = 50)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "CLASS_STATUS", nullable = true)
    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

    @Basic
    @Column(name = "CLASS_NUM", nullable = true)
    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    @Basic
    @Column(name = "CLASS_DESC", nullable = true, length = 500)
    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
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

        Goodsclass that = (Goodsclass) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (classStatus != null ? !classStatus.equals(that.classStatus) : that.classStatus != null) return false;
        if (classNum != null ? !classNum.equals(that.classNum) : that.classNum != null) return false;
        if (classDesc != null ? !classDesc.equals(that.classDesc) : that.classDesc != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (classStatus != null ? classStatus.hashCode() : 0);
        result = 31 * result + (classNum != null ? classNum.hashCode() : 0);
        result = 31 * result + (classDesc != null ? classDesc.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goodsclass{" +
                "id='" + id + '\'' +
                ", shopId='" + shopId + '\'' +
                ", className='" + className + '\'' +
                ", classStatus=" + classStatus +
                ", classNum=" + classNum +
                ", classDesc='" + classDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
