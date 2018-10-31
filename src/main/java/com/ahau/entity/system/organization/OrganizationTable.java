package com.ahau.entity.system.organization;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（组织机构）
 * created by: 张理
 * 2018-10-28 19：23
 */
@Entity
@Table(name = "aau_system_organization_table", schema = "bambootattan", catalog = "")
public class OrganizationTable {
    private String orgId;
    private String parentId;
    private String orgName;
    private String shortName;
    private byte activeFlag;
    private String orgRemark;
    private Integer orderBy;
    private String orgSeal;

    @Id
    @Column(name = "ORG_ID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "PARENT_ID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "ORG_NAME")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "SHORT_NAME")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "ACTIVE_FLAG")
    public byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Basic
    @Column(name = "ORG_REMARK")
    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark;
    }

    @Basic
    @Column(name = "ORDER_BY")
    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    @Basic
    @Column(name = "ORG_SEAL")
    public String getOrgSeal() {
        return orgSeal;
    }

    public void setOrgSeal(String orgSeal) {
        this.orgSeal = orgSeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationTable that = (OrganizationTable) o;
        return activeFlag == that.activeFlag &&
                Objects.equals(orgId, that.orgId) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(orgRemark, that.orgRemark) &&
                Objects.equals(orderBy, that.orderBy) &&
                Objects.equals(orgSeal, that.orgSeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId, parentId, orgName, shortName, activeFlag, orgRemark, orderBy, orgSeal);
    }
}
