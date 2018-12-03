package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 用户 */
@Entity
public class User {

    /** 用户id */
    private String id;

    /** 用户的唯一标识 */
    private String openid;

    /** UnionID机制 */
    private String unionid;

    /** 地址id//暂时不用 */
    private String addressId;

    /** 用户名称 */
    private String userName;

    /** 用户电话 */
    private String userPhone;

    /** 用户地址 */
    private String userAddress;

    /** 用户状态  0为禁用 1为正常 默认1*/
    private Integer userStatus;

    /** 用户描述 */
    private String userDesc;

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
    @Column(name = "OPENID", nullable = true, length = 36)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "UNIONID", nullable = true, length = 36)
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "ADDRESS_ID", nullable = true, length = 36)
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PHONE", nullable = true, length = 50)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "USER_ADDRESS", nullable = true, length = 200)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "USER_STATUS", nullable = true)
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "USER_DESC", nullable = true, length = 500)
    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
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

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (openid != null ? !openid.equals(user.openid) : user.openid != null) return false;
        if (unionid != null ? !unionid.equals(user.unionid) : user.unionid != null) return false;
        if (addressId != null ? !addressId.equals(user.addressId) : user.addressId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(user.userPhone) : user.userPhone != null) return false;
        if (userAddress != null ? !userAddress.equals(user.userAddress) : user.userAddress != null) return false;
        if (userStatus != null ? !userStatus.equals(user.userStatus) : user.userStatus != null) return false;
        if (userDesc != null ? !userDesc.equals(user.userDesc) : user.userDesc != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(user.updateTime) : user.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userDesc != null ? userDesc.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", addressId='" + addressId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userStatus=" + userStatus +
                ", userDesc='" + userDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
