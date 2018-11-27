package com.baida.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 12:01
 */


/** 商品 */
@Entity
public class Goods {

    /** 商品id */
    private String id;

    /** 店铺id */
    private String shopId;

    /** 类别id */
    private String classId;

    /** 商品名字 */
    private String goodsName;

    /** 商品价格 */
    private Double goodsPrice;

    /** 商品状态  1为上架 0为下架 默认1*/
    private Integer goodsStatus;

    /** 商品描述 */
    private String goodsDesc;

    /** 商品热度 */
    private Integer goodsHeat;

    /** 商品logo */
    private String goodsPath;

    /** 是否打折  1为是 0为否 默认0*/
    private Integer isDiscount;

    /** 折扣 折扣 默认为1 不打折*/
    private Double goodsDiscount;

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
    @Column(name = "CLASS_ID", nullable = true, length = 36)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "GOODS_NAME", nullable = true, length = 100)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "GOODS_PRICE", nullable = true, precision = 2)
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "GOODS_STATUS", nullable = true)
    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    @Basic
    @Column(name = "GOODS_DESC", nullable = true, length = 500)
    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    @Basic
    @Column(name = "GOODS_HEAT", nullable = true)
    public Integer getGoodsHeat() {
        return goodsHeat;
    }

    public void setGoodsHeat(Integer goodsHeat) {
        this.goodsHeat = goodsHeat;
    }

    @Basic
    @Column(name = "GOODS_PATH", nullable = true, length = 200)
    public String getGoodsPath() {
        return goodsPath;
    }

    public void setGoodsPath(String goodsPath) {
        this.goodsPath = goodsPath;
    }

    @Basic
    @Column(name = "IS_DISCOUNT", nullable = true)
    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    @Basic
    @Column(name = "GOODS_DISCOUNT", nullable = true, precision = 2)
    public Double getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Double goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
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

        Goods goods = (Goods) o;

        if (id != null ? !id.equals(goods.id) : goods.id != null) return false;
        if (shopId != null ? !shopId.equals(goods.shopId) : goods.shopId != null) return false;
        if (classId != null ? !classId.equals(goods.classId) : goods.classId != null) return false;
        if (goodsName != null ? !goodsName.equals(goods.goodsName) : goods.goodsName != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(goods.goodsPrice) : goods.goodsPrice != null) return false;
        if (goodsStatus != null ? !goodsStatus.equals(goods.goodsStatus) : goods.goodsStatus != null) return false;
        if (goodsDesc != null ? !goodsDesc.equals(goods.goodsDesc) : goods.goodsDesc != null) return false;
        if (goodsHeat != null ? !goodsHeat.equals(goods.goodsHeat) : goods.goodsHeat != null) return false;
        if (goodsPath != null ? !goodsPath.equals(goods.goodsPath) : goods.goodsPath != null) return false;
        if (isDiscount != null ? !isDiscount.equals(goods.isDiscount) : goods.isDiscount != null) return false;
        if (goodsDiscount != null ? !goodsDiscount.equals(goods.goodsDiscount) : goods.goodsDiscount != null)
            return false;
        if (createTime != null ? !createTime.equals(goods.createTime) : goods.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(goods.updateTime) : goods.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (goodsStatus != null ? goodsStatus.hashCode() : 0);
        result = 31 * result + (goodsDesc != null ? goodsDesc.hashCode() : 0);
        result = 31 * result + (goodsHeat != null ? goodsHeat.hashCode() : 0);
        result = 31 * result + (goodsPath != null ? goodsPath.hashCode() : 0);
        result = 31 * result + (isDiscount != null ? isDiscount.hashCode() : 0);
        result = 31 * result + (goodsDiscount != null ? goodsDiscount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
