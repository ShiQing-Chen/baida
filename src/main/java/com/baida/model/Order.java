package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */

@Entity
public class Order {
    private String id;
    private String userId;
    private String manId;
    private String addressId;
    private String orderName;
    private Timestamp placeTime;
    private Timestamp takingTime;
    private Timestamp finishTime;
    private Integer orderType;
    private Integer orderStatus;
    private String receiverInfo;
    private String receiverPhone;
    private String orderAddress;
    private Double orderTotal;
    private Double realTotal;
    private Integer payWay;
    private Integer orderIsdiscount;
    private Double orderDiscount;
    private Double sendCost;
    private Double boxCost;
    private String orderDesc;
    private String orderText;
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
    @Column(name = "MAN_ID", nullable = true, length = 36)
    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId;
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
    @Column(name = "ORDER_NAME", nullable = true, length = 100)
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "PLACE_TIME", nullable = true)
    public Timestamp getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Timestamp placeTime) {
        this.placeTime = placeTime;
    }

    @Basic
    @Column(name = "TAKING_TIME", nullable = true)
    public Timestamp getTakingTime() {
        return takingTime;
    }

    public void setTakingTime(Timestamp takingTime) {
        this.takingTime = takingTime;
    }

    @Basic
    @Column(name = "FINISH_TIME", nullable = true)
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "ORDER_TYPE", nullable = true)
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Basic
    @Column(name = "ORDER_STATUS", nullable = true)
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "RECEIVER_INFO", nullable = true, length = 50)
    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    @Basic
    @Column(name = "RECEIVER_PHONE", nullable = true, length = 50)
    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Basic
    @Column(name = "ORDER_ADDRESS", nullable = true, length = 200)
    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Basic
    @Column(name = "ORDER_TOTAL", nullable = true, precision = 2)
    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Basic
    @Column(name = "REAL_TOTAL", nullable = true, precision = 2)
    public Double getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(Double realTotal) {
        this.realTotal = realTotal;
    }

    @Basic
    @Column(name = "PAY_WAY", nullable = true)
    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    @Basic
    @Column(name = "ORDER_ISDISCOUNT", nullable = true)
    public Integer getOrderIsdiscount() {
        return orderIsdiscount;
    }

    public void setOrderIsdiscount(Integer orderIsdiscount) {
        this.orderIsdiscount = orderIsdiscount;
    }

    @Basic
    @Column(name = "ORDER_DISCOUNT", nullable = true, precision = 2)
    public Double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    @Basic
    @Column(name = "SEND_COST", nullable = true, precision = 2)
    public Double getSendCost() {
        return sendCost;
    }

    public void setSendCost(Double sendCost) {
        this.sendCost = sendCost;
    }

    @Basic
    @Column(name = "BOX_COST", nullable = true, precision = 2)
    public Double getBoxCost() {
        return boxCost;
    }

    public void setBoxCost(Double boxCost) {
        this.boxCost = boxCost;
    }

    @Basic
    @Column(name = "ORDER_DESC", nullable = true, length = 500)
    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Basic
    @Column(name = "ORDER_TEXT", nullable = true, length = 500)
    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
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

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (manId != null ? !manId.equals(order.manId) : order.manId != null) return false;
        if (addressId != null ? !addressId.equals(order.addressId) : order.addressId != null) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;
        if (placeTime != null ? !placeTime.equals(order.placeTime) : order.placeTime != null) return false;
        if (takingTime != null ? !takingTime.equals(order.takingTime) : order.takingTime != null) return false;
        if (finishTime != null ? !finishTime.equals(order.finishTime) : order.finishTime != null) return false;
        if (orderType != null ? !orderType.equals(order.orderType) : order.orderType != null) return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (receiverInfo != null ? !receiverInfo.equals(order.receiverInfo) : order.receiverInfo != null) return false;
        if (receiverPhone != null ? !receiverPhone.equals(order.receiverPhone) : order.receiverPhone != null)
            return false;
        if (orderAddress != null ? !orderAddress.equals(order.orderAddress) : order.orderAddress != null) return false;
        if (orderTotal != null ? !orderTotal.equals(order.orderTotal) : order.orderTotal != null) return false;
        if (realTotal != null ? !realTotal.equals(order.realTotal) : order.realTotal != null) return false;
        if (payWay != null ? !payWay.equals(order.payWay) : order.payWay != null) return false;
        if (orderIsdiscount != null ? !orderIsdiscount.equals(order.orderIsdiscount) : order.orderIsdiscount != null)
            return false;
        if (orderDiscount != null ? !orderDiscount.equals(order.orderDiscount) : order.orderDiscount != null)
            return false;
        if (sendCost != null ? !sendCost.equals(order.sendCost) : order.sendCost != null) return false;
        if (boxCost != null ? !boxCost.equals(order.boxCost) : order.boxCost != null) return false;
        if (orderDesc != null ? !orderDesc.equals(order.orderDesc) : order.orderDesc != null) return false;
        if (orderText != null ? !orderText.equals(order.orderText) : order.orderText != null) return false;
        if (createTime != null ? !createTime.equals(order.createTime) : order.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(order.updateTime) : order.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (manId != null ? manId.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        result = 31 * result + (placeTime != null ? placeTime.hashCode() : 0);
        result = 31 * result + (takingTime != null ? takingTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (receiverInfo != null ? receiverInfo.hashCode() : 0);
        result = 31 * result + (receiverPhone != null ? receiverPhone.hashCode() : 0);
        result = 31 * result + (orderAddress != null ? orderAddress.hashCode() : 0);
        result = 31 * result + (orderTotal != null ? orderTotal.hashCode() : 0);
        result = 31 * result + (realTotal != null ? realTotal.hashCode() : 0);
        result = 31 * result + (payWay != null ? payWay.hashCode() : 0);
        result = 31 * result + (orderIsdiscount != null ? orderIsdiscount.hashCode() : 0);
        result = 31 * result + (orderDiscount != null ? orderDiscount.hashCode() : 0);
        result = 31 * result + (sendCost != null ? sendCost.hashCode() : 0);
        result = 31 * result + (boxCost != null ? boxCost.hashCode() : 0);
        result = 31 * result + (orderDesc != null ? orderDesc.hashCode() : 0);
        result = 31 * result + (orderText != null ? orderText.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", manId='" + manId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", placeTime=" + placeTime +
                ", takingTime=" + takingTime +
                ", finishTime=" + finishTime +
                ", orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                ", receiverInfo='" + receiverInfo + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderTotal=" + orderTotal +
                ", realTotal=" + realTotal +
                ", payWay=" + payWay +
                ", orderIsdiscount=" + orderIsdiscount +
                ", orderDiscount=" + orderDiscount +
                ", sendCost=" + sendCost +
                ", boxCost=" + boxCost +
                ", orderDesc='" + orderDesc + '\'' +
                ", orderText='" + orderText + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
