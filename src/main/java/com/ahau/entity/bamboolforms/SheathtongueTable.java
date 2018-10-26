package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（箨舌表）
 * created by: 张理
 * 2018-10-26 18：30
 */
@Entity
public class SheathtongueTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 箨舌颜色 */
    private String sheathTongueColor;
    /* 箨舌颜色（模糊查询） */
    private String sheathTongueColorLike;
    /* 箨舌高度 */
    private String sheathTongueHeight;
    /* 箨舌高度（模糊查询） */
    private String sheathTongueHeightLike;
    /* 箨舌边缘形状 */
    private String sheathTongueMarginShape;
    /* 箨舌边缘形状（模糊查询） */
    private String sheathTongueMarginShapeLike;
    /* 箨舌被毛被粉 */
    private String sheathTongueBackPowderv;
    /* 箨舌被毛被粉（模糊查询） */
    private String sheathTongueBackPowdervLike;

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

    public String getSheathTongueColor() {
        return sheathTongueColor;
    }

    public void setSheathTongueColor(String sheathTongueColor) {
        this.sheathTongueColor = sheathTongueColor;
    }

    public String getSheathTongueColorLike() {
        return sheathTongueColorLike;
    }

    public void setSheathTongueColorLike(String sheathTongueColorLike) {
        this.sheathTongueColorLike = sheathTongueColorLike;
    }

    public String getSheathTongueHeight() {
        return sheathTongueHeight;
    }

    public void setSheathTongueHeight(String sheathTongueHeight) {
        this.sheathTongueHeight = sheathTongueHeight;
    }

    public String getSheathTongueHeightLike() {
        return sheathTongueHeightLike;
    }

    public void setSheathTongueHeightLike(String sheathTongueHeightLike) {
        this.sheathTongueHeightLike = sheathTongueHeightLike;
    }

    public String getSheathTongueMarginShape() {
        return sheathTongueMarginShape;
    }

    public void setSheathTongueMarginShape(String sheathTongueMarginShape) {
        this.sheathTongueMarginShape = sheathTongueMarginShape;
    }

    public String getSheathTongueMarginShapeLike() {
        return sheathTongueMarginShapeLike;
    }

    public void setSheathTongueMarginShapeLike(String sheathTongueMarginShapeLike) {
        this.sheathTongueMarginShapeLike = sheathTongueMarginShapeLike;
    }

    public String getSheathTongueBackPowderv() {
        return sheathTongueBackPowderv;
    }

    public void setSheathTongueBackPowderv(String sheathTongueBackPowderv) {
        this.sheathTongueBackPowderv = sheathTongueBackPowderv;
    }

    public String getSheathTongueBackPowdervLike() {
        return sheathTongueBackPowdervLike;
    }

    public void setSheathTongueBackPowdervLike(String sheathTongueBackPowdervLike) {
        this.sheathTongueBackPowdervLike = sheathTongueBackPowdervLike;
    }
}
