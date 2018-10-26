package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（箨环表）
 * created by: 张理
 * 2018-10-26 17：00
 */
@Entity
public class SheathnodeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 箨环是否隆起 */
    private String sheathNode;
    /* 箨环是否隆起（模糊查询） */
    private String sheathNodeLike;
    /* 箨环被毛 */
    private String sheathNodeBack;
    /* 箨环被毛（模糊查询） */
    private String sheathNodeBackLike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecIdLike() {
        return specIdLike;
    }

    public void setSpecIdLike(String specIdLike) {
        this.specIdLike = specIdLike;
    }

    public String getSheathNode() {
        return sheathNode;
    }

    public void setSheathNode(String sheathNode) {
        this.sheathNode = sheathNode;
    }

    public String getSheathNodeLike() {
        return sheathNodeLike;
    }

    public void setSheathNodeLike(String sheathNodeLike) {
        this.sheathNodeLike = sheathNodeLike;
    }

    public String getSheathNodeBack() {
        return sheathNodeBack;
    }

    public void setSheathNodeBack(String sheathNodeBack) {
        this.sheathNodeBack = sheathNodeBack;
    }

    public String getSheathNodeBackLike() {
        return sheathNodeBackLike;
    }

    public void setSheathNodeBackLike(String sheathNodeBackLike) {
        this.sheathNodeBackLike = sheathNodeBackLike;
    }
}
