package com.ahau.entity.system.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（用户权限）
 * Created by: zhangli
 * 2019-03-28
 */
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;

    /* 权限名称 */
    private String authName;
    /* 查看 */
    private int authView;
    /* 添加 */
    private int authCreate;
    /* 修改 */
    private int authEdit;
    /* 删除 */
    private int authDelete;

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public int getAuthView() {
        return authView;
    }

    public void setAuthView(int authView) {
        this.authView = authView;
    }

    public int getAuthCreate() {
        return authCreate;
    }

    public void setAuthCreate(int authCreate) {
        this.authCreate = authCreate;
    }

    public int getAuthEdit() {
        return authEdit;
    }

    public void setAuthEdit(int authEdit) {
        this.authEdit = authEdit;
    }

    public int getAuthDelete() {
        return authDelete;
    }

    public void setAuthDelete(int authDelete) {
        this.authDelete = authDelete;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authId=" + authId +
                ", authName='" + authName + '\'' +
                ", authView=" + authView +
                ", authCreate=" + authCreate +
                ", authEdit=" + authEdit +
                ", authDelete=" + authDelete +
                '}';
    }
}
