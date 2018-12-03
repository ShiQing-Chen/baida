package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */

@Entity
public class Address {
    private String id;
    private String userId;
    private String orderId;
    private String addressProvince;
    private String addressCity;
    private String addressXian;
    private String addresssTreet;
    private String addresssDetail;
    private String longitude;
    private String latitude;
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
    @Column(name = "USER_ID", nullable = true, length = 36)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ORDER_ID", nullable = true, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ADDRESS_PROVINCE", nullable = true, length = 36)
    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    @Basic
    @Column(name = "ADDRESS_CITY", nullable = true, length = 36)
    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Basic
    @Column(name = "ADDRESS_XIAN", nullable = true, length = 36)
    public String getAddressXian() {
        return addressXian;
    }

    public void setAddressXian(String addressXian) {
        this.addressXian = addressXian;
    }

    @Basic
    @Column(name = "ADDRESSS_TREET", nullable = true, length = 36)
    public String getAddresssTreet() {
        return addresssTreet;
    }

    public void setAddresssTreet(String addresssTreet) {
        this.addresssTreet = addresssTreet;
    }

    @Basic
    @Column(name = "ADDRESSS_DETAIL", nullable = true, length = 36)
    public String getAddresssDetail() {
        return addresssDetail;
    }

    public void setAddresssDetail(String addresssDetail) {
        this.addresssDetail = addresssDetail;
    }

    @Basic
    @Column(name = "LONGITUDE", nullable = true, length = 36)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "LATITUDE", nullable = true, length = 36)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (userId != null ? !userId.equals(address.userId) : address.userId != null) return false;
        if (orderId != null ? !orderId.equals(address.orderId) : address.orderId != null) return false;
        if (addressProvince != null ? !addressProvince.equals(address.addressProvince) : address.addressProvince != null)
            return false;
        if (addressCity != null ? !addressCity.equals(address.addressCity) : address.addressCity != null) return false;
        if (addressXian != null ? !addressXian.equals(address.addressXian) : address.addressXian != null) return false;
        if (addresssTreet != null ? !addresssTreet.equals(address.addresssTreet) : address.addresssTreet != null)
            return false;
        if (addresssDetail != null ? !addresssDetail.equals(address.addresssDetail) : address.addresssDetail != null)
            return false;
        if (longitude != null ? !longitude.equals(address.longitude) : address.longitude != null) return false;
        if (latitude != null ? !latitude.equals(address.latitude) : address.latitude != null) return false;
        if (createTime != null ? !createTime.equals(address.createTime) : address.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(address.updateTime) : address.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (addressProvince != null ? addressProvince.hashCode() : 0);
        result = 31 * result + (addressCity != null ? addressCity.hashCode() : 0);
        result = 31 * result + (addressXian != null ? addressXian.hashCode() : 0);
        result = 31 * result + (addresssTreet != null ? addresssTreet.hashCode() : 0);
        result = 31 * result + (addresssDetail != null ? addresssDetail.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", addressProvince='" + addressProvince + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressXian='" + addressXian + '\'' +
                ", addresssTreet='" + addresssTreet + '\'' +
                ", addresssDetail='" + addresssDetail + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
