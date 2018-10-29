package com.ahau.entity.system.organization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（组织机构）
 * created by: 张理
 * 2018-10-28 19：23
 */
@Entity
public class OrganizationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 所属机构 */
    private String parentId;
    /* 机构名称 */
    private String orgName;
    /* 机构简称 */
    private String shortName;
    /* 是否有效 */
    private Integer activeFlag;
    /* 是否有效（查询上限） */
    private Integer beginActiveFlag;
    /* 是否有效（查询下限） */
    private Integer endActiveFlag;
    /* 机构备注 */
    private String orgRemark;
    /* 排序序号 */
    private Integer orderBy;
    /* 父组织名称 */
    private String parentOrgName;
    /* 企业公章 */
    private String orgSeal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getBeginActiveFlag() {
        return beginActiveFlag;
    }

    public void setBeginActiveFlag(Integer beginActiveFlag) {
        this.beginActiveFlag = beginActiveFlag;
    }

    public Integer getEndActiveFlag() {
        return endActiveFlag;
    }

    public void setEndActiveFlag(Integer endActiveFlag) {
        this.endActiveFlag = endActiveFlag;
    }

    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
    }

    public String getOrgSeal() {
        return orgSeal;
    }

    public void setOrgSeal(String orgSeal) {
        this.orgSeal = orgSeal;
    }
}
