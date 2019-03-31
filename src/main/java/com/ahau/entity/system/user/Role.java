package com.ahau.entity.system.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 实体类：（角色）
 * Created by: 张理
 * 2018-12-13
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @OneToMany(mappedBy = "role",cascade =
            {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    @JsonManagedReference
    private Set<Authority> authorities = new HashSet<>();

    /* 角色名称 */
    private String roleName;
    /* 备注 */
    private String remark;
    /* 排序序号 */
    private Integer sortNum;
    /* 是否能删除 1--是 2--否 */
    private Byte canDel;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Byte getCanDel() {
        return canDel;
    }

    public void setCanDel(Byte canDel) {
        this.canDel = canDel;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", authorities=" + authorities +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", sortNum=" + sortNum +
                ", canDel=" + canDel +
                '}';
    }
}
