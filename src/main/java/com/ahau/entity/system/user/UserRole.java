package com.ahau.entity.system.user;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（用户角色）
 * created by: 张理
 * 2018-10-29 09：40
 */
@Entity
@Table(name = "aau_system_user_role", schema = "bambootattan", catalog = "")
@IdClass(UserRolePK.class)
public class UserRole {
    private String userId;
    private String roleId;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole that = (UserRole) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
