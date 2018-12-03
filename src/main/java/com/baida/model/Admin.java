package com.baida.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 17:53
 */

@Entity
public class Admin {
    private String id;
    private String adminName;
    private String adminPassword;
    private String adminPhone;
    private Integer adminStatus;
    private String adminDesc;
    private Timestamp createTime;
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
    @Column(name = "ADMIN_NAME", nullable = true, length = 50)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "ADMIN_PASSWORD", nullable = true, length = 50)
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Basic
    @Column(name = "ADMIN_PHONE", nullable = true, length = 50)
    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    @Basic
    @Column(name = "ADMIN_STATUS", nullable = true)
    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }

    @Basic
    @Column(name = "ADMIN_DESC", nullable = true, length = 500)
    public String getAdminDesc() {
        return adminDesc;
    }

    public void setAdminDesc(String adminDesc) {
        this.adminDesc = adminDesc;
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

        Admin admin = (Admin) o;

        if (id != null ? !id.equals(admin.id) : admin.id != null) return false;
        if (adminName != null ? !adminName.equals(admin.adminName) : admin.adminName != null) return false;
        if (adminPassword != null ? !adminPassword.equals(admin.adminPassword) : admin.adminPassword != null)
            return false;
        if (adminPhone != null ? !adminPhone.equals(admin.adminPhone) : admin.adminPhone != null) return false;
        if (adminStatus != null ? !adminStatus.equals(admin.adminStatus) : admin.adminStatus != null) return false;
        if (adminDesc != null ? !adminDesc.equals(admin.adminDesc) : admin.adminDesc != null) return false;
        if (createTime != null ? !createTime.equals(admin.createTime) : admin.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(admin.updateTime) : admin.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPassword != null ? adminPassword.hashCode() : 0);
        result = 31 * result + (adminPhone != null ? adminPhone.hashCode() : 0);
        result = 31 * result + (adminStatus != null ? adminStatus.hashCode() : 0);
        result = 31 * result + (adminDesc != null ? adminDesc.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminStatus=" + adminStatus +
                ", adminDesc='" + adminDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
