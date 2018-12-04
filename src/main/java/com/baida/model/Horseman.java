package com.baida.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/12/4 14:24
 */

/** 骑手 */
@Entity
public class Horseman {

    /** 骑手id */
    private String id;

    /** 骑手名字 */
    private String manName;

    /** 骑手状态 0为休息 1为工作 默认为0 */
    private Integer manStatus;

    /** 骑手电话 */
    private String manPhone;

    /** 接单数量 */
    private Integer takeoutNum;

    /** 完成订单数量 */
    private Integer finishNum;

    /** 接单金额 */
    private Double manTakemoney;

    /** 完成订单金额 */
    private Double manFinishmoney;

    /** 骑手描述 */
    private Timestamp manDesc;

    /** 登录用户名 */
    private String manUser;

    /** 登录密码 */
    private String manPassword;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    @Id
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MAN_NAME", nullable = true, length = 50)
    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    @Basic
    @Column(name = "MAN_STATUS", nullable = true)
    public Integer getManStatus() {
        return manStatus;
    }

    public void setManStatus(Integer manStatus) {
        this.manStatus = manStatus;
    }

    @Basic
    @Column(name = "MAN_PHONE", nullable = true, length = 50)
    public String getManPhone() {
        return manPhone;
    }

    public void setManPhone(String manPhone) {
        this.manPhone = manPhone;
    }

    @Basic
    @Column(name = "TAKEOUT_NUM", nullable = true)
    public Integer getTakeoutNum() {
        return takeoutNum;
    }

    public void setTakeoutNum(Integer takeoutNum) {
        this.takeoutNum = takeoutNum;
    }

    @Basic
    @Column(name = "FINISH_NUM", nullable = true)
    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    @Basic
    @Column(name = "MAN_TAKEMONEY", nullable = true, precision = 2)
    public Double getManTakemoney() {
        return manTakemoney;
    }

    public void setManTakemoney(Double manTakemoney) {
        this.manTakemoney = manTakemoney;
    }

    @Basic
    @Column(name = "MAN_FINISHMONEY", nullable = true, precision = 2)
    public Double getManFinishmoney() {
        return manFinishmoney;
    }

    public void setManFinishmoney(Double manFinishmoney) {
        this.manFinishmoney = manFinishmoney;
    }

    @Basic
    @Column(name = "MAN_DESC", nullable = true)
    public Timestamp getManDesc() {
        return manDesc;
    }

    public void setManDesc(Timestamp manDesc) {
        this.manDesc = manDesc;
    }

    @Basic
    @Column(name = "MAN_USER", nullable = false, length = 36)
    public String getManUser() {
        return manUser;
    }

    public void setManUser(String manUser) {
        this.manUser = manUser;
    }

    @Basic
    @Column(name = "MAN_PASSWORD", nullable = false, length = 36)
    public String getManPassword() {
        return manPassword;
    }

    public void setManPassword(String manPassword) {
        this.manPassword = manPassword;
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

        Horseman horseman = (Horseman) o;

        if (id != null ? !id.equals(horseman.id) : horseman.id != null) return false;
        if (manName != null ? !manName.equals(horseman.manName) : horseman.manName != null) return false;
        if (manStatus != null ? !manStatus.equals(horseman.manStatus) : horseman.manStatus != null) return false;
        if (manPhone != null ? !manPhone.equals(horseman.manPhone) : horseman.manPhone != null) return false;
        if (takeoutNum != null ? !takeoutNum.equals(horseman.takeoutNum) : horseman.takeoutNum != null) return false;
        if (finishNum != null ? !finishNum.equals(horseman.finishNum) : horseman.finishNum != null) return false;
        if (manTakemoney != null ? !manTakemoney.equals(horseman.manTakemoney) : horseman.manTakemoney != null)
            return false;
        if (manFinishmoney != null ? !manFinishmoney.equals(horseman.manFinishmoney) : horseman.manFinishmoney != null)
            return false;
        if (manDesc != null ? !manDesc.equals(horseman.manDesc) : horseman.manDesc != null) return false;
        if (manUser != null ? !manUser.equals(horseman.manUser) : horseman.manUser != null) return false;
        if (manPassword != null ? !manPassword.equals(horseman.manPassword) : horseman.manPassword != null)
            return false;
        if (createTime != null ? !createTime.equals(horseman.createTime) : horseman.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(horseman.updateTime) : horseman.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manName != null ? manName.hashCode() : 0);
        result = 31 * result + (manStatus != null ? manStatus.hashCode() : 0);
        result = 31 * result + (manPhone != null ? manPhone.hashCode() : 0);
        result = 31 * result + (takeoutNum != null ? takeoutNum.hashCode() : 0);
        result = 31 * result + (finishNum != null ? finishNum.hashCode() : 0);
        result = 31 * result + (manTakemoney != null ? manTakemoney.hashCode() : 0);
        result = 31 * result + (manFinishmoney != null ? manFinishmoney.hashCode() : 0);
        result = 31 * result + (manDesc != null ? manDesc.hashCode() : 0);
        result = 31 * result + (manUser != null ? manUser.hashCode() : 0);
        result = 31 * result + (manPassword != null ? manPassword.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Horseman{" +
                "id='" + id + '\'' +
                ", manName='" + manName + '\'' +
                ", manStatus=" + manStatus +
                ", manPhone='" + manPhone + '\'' +
                ", takeoutNum=" + takeoutNum +
                ", finishNum=" + finishNum +
                ", manTakemoney=" + manTakemoney +
                ", manFinishmoney=" + manFinishmoney +
                ", manDesc=" + manDesc +
                ", manUser='" + manUser + '\'' +
                ", manPassword='" + manPassword + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
