package com.ahau.entity.system.role;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 实体类：（role table）
 * created by: 张理
 * 2018-10-28 19：50
 */
@Entity
public class RoleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

//    private List<SecurityProperties.User> userList;

//    private List<RolePath> permList;

    /* 标识 用户是否具有此角色 */
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static final String TABLE_CACHE_PREFIX = "ANDJI_SYSTEM_ROLE_BASE-";
    /* 角色名称 */
    private String roleName;
    /* 角色名称（模糊查询） */
    private String roleNameLike;
    /* 备注 */
    private String remark;
    /* 备注（模糊查询） */
    private String remarkLike;
    /* 排序序号 */
    private Integer sortNum;
    /* 排序序号（查询上限） */
    private Integer beginSortNum;
    /* 排序序号（查询下限） */
    private Integer endSortNum;
    /* 是否能删除 */
    private Integer canDel;
    /* 是否能删除（查询上限） */
    private Integer beginCanDel;
    /* 是否能删除（查询下限） */
    private Integer endCanDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public List<SecurityProperties.User> getUserList() {
//        return userList;
//    }

//    public void setUserList(List<SecurityProperties.User> userList) {
//        this.userList = userList;
//    }
//
//    public List<RolePath> getPermList() {
//        return permList;
//    }

//    public void setPermList(List<RolePath> permList) {
//        this.permList = permList;
//    }

    public static String getTableCachePrefix() {
        return TABLE_CACHE_PREFIX;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameLike() {
        return roleNameLike;
    }

    public void setRoleNameLike(String roleNameLike) {
        this.roleNameLike = roleNameLike;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkLike() {
        return remarkLike;
    }

    public void setRemarkLike(String remarkLike) {
        this.remarkLike = remarkLike;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getBeginSortNum() {
        return beginSortNum;
    }

    public void setBeginSortNum(Integer beginSortNum) {
        this.beginSortNum = beginSortNum;
    }

    public Integer getEndSortNum() {
        return endSortNum;
    }

    public void setEndSortNum(Integer endSortNum) {
        this.endSortNum = endSortNum;
    }

    public Integer getCanDel() {
        return canDel;
    }

    public void setCanDel(Integer canDel) {
        this.canDel = canDel;
    }

    public Integer getBeginCanDel() {
        return beginCanDel;
    }

    public void setBeginCanDel(Integer beginCanDel) {
        this.beginCanDel = beginCanDel;
    }

    public Integer getEndCanDel() {
        return endCanDel;
    }

    public void setEndCanDel(Integer endCanDel) {
        this.endCanDel = endCanDel;
    }
}
