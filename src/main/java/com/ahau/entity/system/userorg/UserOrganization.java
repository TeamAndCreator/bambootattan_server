package com.ahau.entity.system.userorg;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体：（用户-组织机构）
 * created by: 张理
 * 2018-10-29 09：30
 */
@Entity
@Table(name = "aau_system_user_org", schema = "bambootattan", catalog = "")
@IdClass(UserOrganizationPK.class)
public class UserOrganization {
    private String userId;
    private String orgId;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "ORG_ID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrganization that = (UserOrganization) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, orgId);
    }
}
