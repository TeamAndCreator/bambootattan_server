package com.ahau.entity.system.userorg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体：（用户-组织机构）
 * created by: 张理
 * 2018-10-29 09：30
 */
@Entity
public class UserOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 用户ID */
    private String userId;
    /* 组织机构ID */
    private String orgId;
    /* 组织机构信息 */
//    private Organization organization;
//    /* 用户信息 */
//    private User user;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
