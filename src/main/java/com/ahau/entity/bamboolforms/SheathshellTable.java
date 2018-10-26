package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（箨片表）
 * created by: 张理
 * 2018-10-26 19：00
 */
@Entity
public class SheathshellTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 箨片形状 */
    private String sheathShellShape;
    /* 箨片形状（模糊查询） */
    private String sheathShellShapeLike;
    /* 箨片颜色 */
    private String sheathShellColor;
    /* 箨片颜色（模糊查询） */
    private String sheathShellColorLike;
    /* 箨片是否易脱落 */
    private String sheathShellFall;
    /* 箨片是否易脱落（模糊查询） */
    private String sheathShellFallLike;
    /* 箨片先端形 */
    private String sheathShellTopShape;
    /* 箨片先端形（模糊查询） */
    private String sheathShellTopShapeLike;
    /* 箨片基部形状 */
    private String sheathShellBaseShape;
    /* 箨片基部形状（模糊查询） */
    private String sheathShellBaseShapeLike;
    /* 箨片边缘形态 */
    private String sheathShellMargin;
    /* 箨片边缘形态（模糊查询） */
    private String sheathShellMarginLike;
    /* 箨片背面被毛被粉 */
    private String sheathShellBackPowder;
    /* 箨片背面被毛被粉（模糊查询） */
    private String sheathShellBackPowderLike;
    /* 箨片基底与箨鞘宽度之比 */
    private Double sheathRatioOf;
    /* 箨片基底与箨鞘宽度之比（查询上限） */
    private Double beginSheathRatioOf;
    /* 箨片基底与箨鞘宽度之比（查询下限） */
    private Double endSheathRatioOf;

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

    public String getSheathShellShape() {
        return sheathShellShape;
    }

    public void setSheathShellShape(String sheathShellShape) {
        this.sheathShellShape = sheathShellShape;
    }

    public String getSheathShellShapeLike() {
        return sheathShellShapeLike;
    }

    public void setSheathShellShapeLike(String sheathShellShapeLike) {
        this.sheathShellShapeLike = sheathShellShapeLike;
    }

    public String getSheathShellColor() {
        return sheathShellColor;
    }

    public void setSheathShellColor(String sheathShellColor) {
        this.sheathShellColor = sheathShellColor;
    }

    public String getSheathShellColorLike() {
        return sheathShellColorLike;
    }

    public void setSheathShellColorLike(String sheathShellColorLike) {
        this.sheathShellColorLike = sheathShellColorLike;
    }

    public String getSheathShellFall() {
        return sheathShellFall;
    }

    public void setSheathShellFall(String sheathShellFall) {
        this.sheathShellFall = sheathShellFall;
    }

    public String getSheathShellFallLike() {
        return sheathShellFallLike;
    }

    public void setSheathShellFallLike(String sheathShellFallLike) {
        this.sheathShellFallLike = sheathShellFallLike;
    }

    public String getSheathShellTopShape() {
        return sheathShellTopShape;
    }

    public void setSheathShellTopShape(String sheathShellTopShape) {
        this.sheathShellTopShape = sheathShellTopShape;
    }

    public String getSheathShellTopShapeLike() {
        return sheathShellTopShapeLike;
    }

    public void setSheathShellTopShapeLike(String sheathShellTopShapeLike) {
        this.sheathShellTopShapeLike = sheathShellTopShapeLike;
    }

    public String getSheathShellBaseShape() {
        return sheathShellBaseShape;
    }

    public void setSheathShellBaseShape(String sheathShellBaseShape) {
        this.sheathShellBaseShape = sheathShellBaseShape;
    }

    public String getSheathShellBaseShapeLike() {
        return sheathShellBaseShapeLike;
    }

    public void setSheathShellBaseShapeLike(String sheathShellBaseShapeLike) {
        this.sheathShellBaseShapeLike = sheathShellBaseShapeLike;
    }

    public String getSheathShellMargin() {
        return sheathShellMargin;
    }

    public void setSheathShellMargin(String sheathShellMargin) {
        this.sheathShellMargin = sheathShellMargin;
    }

    public String getSheathShellMarginLike() {
        return sheathShellMarginLike;
    }

    public void setSheathShellMarginLike(String sheathShellMarginLike) {
        this.sheathShellMarginLike = sheathShellMarginLike;
    }

    public String getSheathShellBackPowder() {
        return sheathShellBackPowder;
    }

    public void setSheathShellBackPowder(String sheathShellBackPowder) {
        this.sheathShellBackPowder = sheathShellBackPowder;
    }

    public String getSheathShellBackPowderLike() {
        return sheathShellBackPowderLike;
    }

    public void setSheathShellBackPowderLike(String sheathShellBackPowderLike) {
        this.sheathShellBackPowderLike = sheathShellBackPowderLike;
    }

    public Double getSheathRatioOf() {
        return sheathRatioOf;
    }

    public void setSheathRatioOf(Double sheathRatioOf) {
        this.sheathRatioOf = sheathRatioOf;
    }

    public Double getBeginSheathRatioOf() {
        return beginSheathRatioOf;
    }

    public void setBeginSheathRatioOf(Double beginSheathRatioOf) {
        this.beginSheathRatioOf = beginSheathRatioOf;
    }

    public Double getEndSheathRatioOf() {
        return endSheathRatioOf;
    }

    public void setEndSheathRatioOf(Double endSheathRatioOf) {
        this.endSheathRatioOf = endSheathRatioOf;
    }
}
