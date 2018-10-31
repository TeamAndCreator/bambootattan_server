package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（竹秆表）
 * Created by: 张理
 * 2018-10-26 15：30
 */
@Entity
public class CulmTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 竿高度 */
    private String culmHeight;
    /* 竿高度（模糊查询） */
    private String culmHeightLike;
    /* 竿直径 */
    private String culmDiameter;
    /* 竿直径（模糊查询） */
    private String culmDiameterLike;
    /* 竿颜色 */
    private String culmColor;
    /* 竿颜色（模糊查询） */
    private String culmColorLike;
    /* 竿稍头 */
    private String culmTop;
    /* 竿稍头（模糊查询） */
    private String culmTopLike;
    /* 竿身形态 */
    private String culmStem;
    /* 竿身形态（模糊查询） */
    private String culmStemLike;
    /* 节间长度 */
    private String internodeLength;
    /* 节间长度（模糊查询） */
    private String internodeLengthLike;
    /* 节间形状 */
    private String internodeShape;
    /* 节间形状（模糊查询） */
    private String internodeShapeLike;
    /* 节间有无气生根 */
    private String internodeAerialRoot;
    /* 节间有无气生根（模糊查询） */
    private String internodeAerialRootLike;
    /* 节间被毛 */
    private String internodeBack;
    /* 节间被毛（模糊查询） */
    private String internodeBackLike;
    /* 节间竿壁厚 */
    private String internodeCulmWall;
    /* 节间竿壁厚（模糊查询） */
    private String internodeCulmWallLike;
    /* 幼时竿被毛 */
    private String youngStemBack;
    /* 幼时竿被毛（模糊查询） */
    private String youngStemBackLike;
    /* 幼时竿被粉 */
    private String youngStemPowder;
    /* 幼时竿被粉（模糊查询） */
    private String youngStemPowderLike;
    /* 竿环是否隆起 */
    private String culmNode;
    /* 竿环是否隆起（模糊查询） */
    private String culmNodeLike;

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

    public String getCulmHeight() {
        return culmHeight;
    }

    public void setCulmHeight(String culmHeight) {
        this.culmHeight = culmHeight;
    }

    public String getCulmHeightLike() {
        return culmHeightLike;
    }

    public void setCulmHeightLike(String culmHeightLike) {
        this.culmHeightLike = culmHeightLike;
    }

    public String getCulmDiameter() {
        return culmDiameter;
    }

    public void setCulmDiameter(String culmDiameter) {
        this.culmDiameter = culmDiameter;
    }

    public String getCulmDiameterLike() {
        return culmDiameterLike;
    }

    public void setCulmDiameterLike(String culmDiameterLike) {
        this.culmDiameterLike = culmDiameterLike;
    }

    public String getCulmColor() {
        return culmColor;
    }

    public void setCulmColor(String culmColor) {
        this.culmColor = culmColor;
    }

    public String getCulmColorLike() {
        return culmColorLike;
    }

    public void setCulmColorLike(String culmColorLike) {
        this.culmColorLike = culmColorLike;
    }

    public String getCulmTop() {
        return culmTop;
    }

    public void setCulmTop(String culmTop) {
        this.culmTop = culmTop;
    }

    public String getCulmTopLike() {
        return culmTopLike;
    }

    public void setCulmTopLike(String culmTopLike) {
        this.culmTopLike = culmTopLike;
    }

    public String getCulmStem() {
        return culmStem;
    }

    public void setCulmStem(String culmStem) {
        this.culmStem = culmStem;
    }

    public String getCulmStemLike() {
        return culmStemLike;
    }

    public void setCulmStemLike(String culmStemLike) {
        this.culmStemLike = culmStemLike;
    }

    public String getInternodeLength() {
        return internodeLength;
    }

    public void setInternodeLength(String internodeLength) {
        this.internodeLength = internodeLength;
    }

    public String getInternodeLengthLike() {
        return internodeLengthLike;
    }

    public void setInternodeLengthLike(String internodeLengthLike) {
        this.internodeLengthLike = internodeLengthLike;
    }

    public String getInternodeShape() {
        return internodeShape;
    }

    public void setInternodeShape(String internodeShape) {
        this.internodeShape = internodeShape;
    }

    public String getInternodeShapeLike() {
        return internodeShapeLike;
    }

    public void setInternodeShapeLike(String internodeShapeLike) {
        this.internodeShapeLike = internodeShapeLike;
    }

    public String getInternodeAerialRoot() {
        return internodeAerialRoot;
    }

    public void setInternodeAerialRoot(String internodeAerialRoot) {
        this.internodeAerialRoot = internodeAerialRoot;
    }

    public String getInternodeAerialRootLike() {
        return internodeAerialRootLike;
    }

    public void setInternodeAerialRootLike(String internodeAerialRootLike) {
        this.internodeAerialRootLike = internodeAerialRootLike;
    }

    public String getInternodeBack() {
        return internodeBack;
    }

    public void setInternodeBack(String internodeBack) {
        this.internodeBack = internodeBack;
    }

    public String getInternodeBackLike() {
        return internodeBackLike;
    }

    public void setInternodeBackLike(String internodeBackLike) {
        this.internodeBackLike = internodeBackLike;
    }

    public String getInternodeCulmWall() {
        return internodeCulmWall;
    }

    public void setInternodeCulmWall(String internodeCulmWall) {
        this.internodeCulmWall = internodeCulmWall;
    }

    public String getInternodeCulmWallLike() {
        return internodeCulmWallLike;
    }

    public void setInternodeCulmWallLike(String internodeCulmWallLike) {
        this.internodeCulmWallLike = internodeCulmWallLike;
    }

    public String getYoungStemBack() {
        return youngStemBack;
    }

    public void setYoungStemBack(String youngStemBack) {
        this.youngStemBack = youngStemBack;
    }

    public String getYoungStemBackLike() {
        return youngStemBackLike;
    }

    public void setYoungStemBackLike(String youngStemBackLike) {
        this.youngStemBackLike = youngStemBackLike;
    }

    public String getYoungStemPowder() {
        return youngStemPowder;
    }

    public void setYoungStemPowder(String youngStemPowder) {
        this.youngStemPowder = youngStemPowder;
    }

    public String getYoungStemPowderLike() {
        return youngStemPowderLike;
    }

    public void setYoungStemPowderLike(String youngStemPowderLike) {
        this.youngStemPowderLike = youngStemPowderLike;
    }

    public String getCulmNode() {
        return culmNode;
    }

    public void setCulmNode(String culmNode) {
        this.culmNode = culmNode;
    }

    public String getCulmNodeLike() {
        return culmNodeLike;
    }

    public void setCulmNodeLike(String culmNodeLike) {
        this.culmNodeLike = culmNodeLike;
    }
}
