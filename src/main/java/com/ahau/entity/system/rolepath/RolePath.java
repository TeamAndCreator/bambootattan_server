package com.ahau.entity.system.rolepath;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（角色_路径）
 * created by: 张理
 * 2018-10-28 20：00
 */
@Entity
@Table(name = "aau_system_rolepath_table", schema = "bambootattan", catalog = "")
@IdClass(RolePathPK.class)
public class RolePath {
    private String roleId;
    private String pathId;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "PATH_ID")
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePath that = (RolePath) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(pathId, that.pathId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, pathId);
    }
}
