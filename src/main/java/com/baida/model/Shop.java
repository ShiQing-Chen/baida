package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 店铺 */
@Entity
public class Shop {

    /** 店铺id */
    private String id;

    /** 店铺名字 */
    private String shopName;

    /** 店铺地址 */
    private String shopAddress;

    /** 店铺log */
    private String shopPath;

    /** 店铺状态  1为上线 0为下线 默认0*/
    private Integer shopStatus;

    /** 店铺描述 */
    private String shopDesc;

    /** 店铺电话 */
    private String shopPhone;

    /** 起送费 */
    private Double startFee;

    /** 营业开始时间 */
    private Timestamp startTime;

    /** 营业结束时间 */
    private Timestamp endTime;

    /** 店铺活动 */
    private String shopActivity;

    /** 店铺热度 */
    private Integer shopHeat;

    /** 店铺地址经度 */
    private BigDecimal longitude;

    /** 店铺地址纬度 */
    private BigDecimal latitude;

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
    @Column(name = "SHOP_NAME", nullable = true, length = 50)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "SHOP_ADDRESS", nullable = true, length = 100)
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Basic
    @Column(name = "SHOP_PATH", nullable = true, length = 200)
    public String getShopPath() {
        return shopPath;
    }

    public void setShopPath(String shopPath) {
        this.shopPath = shopPath;
    }

    @Basic
    @Column(name = "SHOP_STATUS", nullable = true)
    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Basic
    @Column(name = "SHOP_DESC", nullable = true, length = 500)
    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    @Basic
    @Column(name = "SHOP_PHONE", nullable = true, length = 50)
    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    @Basic
    @Column(name = "START_FEE", nullable = true, precision = 2)
    public Double getStartFee() {
        return startFee;
    }

    public void setStartFee(Double startFee) {
        this.startFee = startFee;
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
    @Column(name = "SHOP_ACTIVITY", nullable = true, length = 500)
    public String getShopActivity() {
        return shopActivity;
    }

    public void setShopActivity(String shopActivity) {
        this.shopActivity = shopActivity;
    }

    @Basic
    @Column(name = "SHOP_HEAT", nullable = true)
    public Integer getShopHeat() {
        return shopHeat;
    }

    public void setShopHeat(Integer shopHeat) {
        this.shopHeat = shopHeat;
    }

    @Basic
    @Column(name = "LONGITUDE", nullable = true, precision = 6)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "LATITUDE", nullable = true, precision = 6)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
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

        Shop shop = (Shop) o;

        if (id != null ? !id.equals(shop.id) : shop.id != null) return false;
        if (shopName != null ? !shopName.equals(shop.shopName) : shop.shopName != null) return false;
        if (shopAddress != null ? !shopAddress.equals(shop.shopAddress) : shop.shopAddress != null) return false;
        if (shopPath != null ? !shopPath.equals(shop.shopPath) : shop.shopPath != null) return false;
        if (shopStatus != null ? !shopStatus.equals(shop.shopStatus) : shop.shopStatus != null) return false;
        if (shopDesc != null ? !shopDesc.equals(shop.shopDesc) : shop.shopDesc != null) return false;
        if (shopPhone != null ? !shopPhone.equals(shop.shopPhone) : shop.shopPhone != null) return false;
        if (startFee != null ? !startFee.equals(shop.startFee) : shop.startFee != null) return false;
        if (startTime != null ? !startTime.equals(shop.startTime) : shop.startTime != null) return false;
        if (endTime != null ? !endTime.equals(shop.endTime) : shop.endTime != null) return false;
        if (shopActivity != null ? !shopActivity.equals(shop.shopActivity) : shop.shopActivity != null) return false;
        if (shopHeat != null ? !shopHeat.equals(shop.shopHeat) : shop.shopHeat != null) return false;
        if (longitude != null ? !longitude.equals(shop.longitude) : shop.longitude != null) return false;
        if (latitude != null ? !latitude.equals(shop.latitude) : shop.latitude != null) return false;
        if (createTime != null ? !createTime.equals(shop.createTime) : shop.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(shop.updateTime) : shop.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (shopAddress != null ? shopAddress.hashCode() : 0);
        result = 31 * result + (shopPath != null ? shopPath.hashCode() : 0);
        result = 31 * result + (shopStatus != null ? shopStatus.hashCode() : 0);
        result = 31 * result + (shopDesc != null ? shopDesc.hashCode() : 0);
        result = 31 * result + (shopPhone != null ? shopPhone.hashCode() : 0);
        result = 31 * result + (startFee != null ? startFee.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (shopActivity != null ? shopActivity.hashCode() : 0);
        result = 31 * result + (shopHeat != null ? shopHeat.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
