package com.ahau.entity.system.rolepath;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 调用类
 * Created by: 张理
 * 2018-10-31 20：50
 */
public class RolePathPK implements Serializable {
    private String roleId;
    private String pathId;

    @Column(name = "ROLE_ID")
    @Id
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "PATH_ID")
    @Id
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
        RolePathPK that = (RolePathPK) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(pathId, that.pathId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, pathId);
    }
}
