package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */

@Entity
public class Horseman {
    private String id;
    private String manName;
    private Integer manStatus;
    private String manPhone;
    private Integer takeoutNum;
    private Double manMoney;
    private Timestamp manDesc;
    private String manUser;
    private String manPassword;
    private Timestamp createTime;
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
    @Column(name = "MAN_MONEY", nullable = true, precision = 2)
    public Double getManMoney() {
        return manMoney;
    }

    public void setManMoney(Double manMoney) {
        this.manMoney = manMoney;
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
        if (manMoney != null ? !manMoney.equals(horseman.manMoney) : horseman.manMoney != null) return false;
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
        result = 31 * result + (manMoney != null ? manMoney.hashCode() : 0);
        result = 31 * result + (manDesc != null ? manDesc.hashCode() : 0);
        result = 31 * result + (manUser != null ? manUser.hashCode() : 0);
        result = 31 * result + (manPassword != null ? manPassword.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
