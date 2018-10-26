package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（箨耳表）
 * created by: 张理
 * 2018-10-26 17：20
 */
@Entity
public class SheathearTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 箨耳发达情况 */
    private String sheathEarDev;
    /* 箨耳发达情况（模糊查询） */
    private String sheathEarDevLike;
    /* 箨耳形状 */
    private String sheathEarShape;
    /* 箨耳形状（模糊查询） */
    private String sheathEarShapeLike;
    /* 箨耳边缘繸毛 */
    private String sheathEarMargin;
    /* 箨耳边缘繸毛（模糊查询） */
    private String sheathEarMarginLike;

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

    public String getSheathEarDev() {
        return sheathEarDev;
    }

    public void setSheathEarDev(String sheathEarDev) {
        this.sheathEarDev = sheathEarDev;
    }

    public String getSheathEarDevLike() {
        return sheathEarDevLike;
    }

    public void setSheathEarDevLike(String sheathEarDevLike) {
        this.sheathEarDevLike = sheathEarDevLike;
    }

    public String getSheathEarShape() {
        return sheathEarShape;
    }

    public void setSheathEarShape(String sheathEarShape) {
        this.sheathEarShape = sheathEarShape;
    }

    public String getSheathEarShapeLike() {
        return sheathEarShapeLike;
    }

    public void setSheathEarShapeLike(String sheathEarShapeLike) {
        this.sheathEarShapeLike = sheathEarShapeLike;
    }

    public String getSheathEarMargin() {
        return sheathEarMargin;
    }

    public void setSheathEarMargin(String sheathEarMargin) {
        this.sheathEarMargin = sheathEarMargin;
    }

    public String getSheathEarMarginLike() {
        return sheathEarMarginLike;
    }

    public void setSheathEarMarginLike(String sheathEarMarginLike) {
        this.sheathEarMarginLike = sheathEarMarginLike;
    }
}
