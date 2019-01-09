package com.ahau.entity.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（角色）
 * Created by: 张理
 * 2018-12-13
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    /* 角色名称 */
    private String roleName;
    /* 备注 */
    private String remark;
    /* 排序序号 */
    private Integer sortNum;
    /* 是否能删除 1--是 2--否 */
    private Byte canDel;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
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

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", sortNum=" + sortNum +
                ", canDel=" + canDel +
                '}';
    }
}
