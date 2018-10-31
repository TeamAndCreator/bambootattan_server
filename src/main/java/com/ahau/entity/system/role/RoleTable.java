package com.ahau.entity.system.role;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（role table）
 * created by: 张理
 * 2018-10-28 19：50
 */
@Entity
@Table(name = "aau_system_role_table", schema = "bambootattan", catalog = "")
public class RoleTable {
    private String roleId;
    private String roleName;
    private String remark;
    private Integer sortNum;
    private Byte canDel;

    @Id
    @Column(name = "ROLE_ID")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "SORT_NUM")
    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    @Basic
    @Column(name = "CAN_DEL")
    public Byte getCanDel() {
        return canDel;
    }

    public void setCanDel(Byte canDel) {
        this.canDel = canDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleTable that = (RoleTable) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(sortNum, that.sortNum) &&
                Objects.equals(canDel, that.canDel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, remark, sortNum, canDel);
    }
}
