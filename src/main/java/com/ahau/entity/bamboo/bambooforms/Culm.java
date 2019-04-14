package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;

/**
 * 实体类：（竹秆表）
 * Created by: 张理
 * 2018-11-2 16：49
 */
@Entity
public class Culm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long culmId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 竿高度 */
    private String culmHeight;

    /* 竿直径 */
    private String culmDiameter;

    /* 竿颜色 */
    private String culmColor;

    /* 竿稍头 */
    private String culmTop;

    /* 竿身形态 */
    private String culmStem;

    /* 节间长度 */
    private String internodeLength;

    /* 节间形状 */
    private String internodeShape;

    /* 节间有无气生根 */
    private String internodeAerialRoot;

    /* 节间被毛 */
    private String internodeBack;

    /* 节间竿壁厚 */
    private String internodeCulmWall;

    /* 幼时竿被毛 */
    private String youngStemBack;

    /* 幼时竿被粉 */
    private String youngStemPowder;

    /* 竿环是否隆起 */
    private String culmNode;

    public Long getCulmId() {
        return culmId;
    }

    public void setCulmId(Long culmId) {
        this.culmId = culmId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getCulmHeight() {
        return culmHeight;
    }

    public void setCulmHeight(String culmHeight) {
        this.culmHeight = culmHeight;
    }

    public String getCulmDiameter() {
        return culmDiameter;
    }

    public void setCulmDiameter(String culmDiameter) {
        this.culmDiameter = culmDiameter;
    }

    public String getCulmColor() {
        return culmColor;
    }

    public void setCulmColor(String culmColor) {
        this.culmColor = culmColor;
    }

    public String getCulmTop() {
        return culmTop;
    }

    public void setCulmTop(String culmTop) {
        this.culmTop = culmTop;
    }

    public String getCulmStem() {
        return culmStem;
    }

    public void setCulmStem(String culmStem) {
        this.culmStem = culmStem;
    }

    public String getInternodeLength() {
        return internodeLength;
    }

    public void setInternodeLength(String internodeLength) {
        this.internodeLength = internodeLength;
    }

    public String getInternodeShape() {
        return internodeShape;
    }

    public void setInternodeShape(String internodeShape) {
        this.internodeShape = internodeShape;
    }

    public String getInternodeAerialRoot() {
        return internodeAerialRoot;
    }

    public void setInternodeAerialRoot(String internodeAerialRoot) {
        this.internodeAerialRoot = internodeAerialRoot;
    }

    public String getInternodeBack() {
        return internodeBack;
    }

    public void setInternodeBack(String internodeBack) {
        this.internodeBack = internodeBack;
    }

    public String getInternodeCulmWall() {
        return internodeCulmWall;
    }

    public void setInternodeCulmWall(String internodeCulmWall) {
        this.internodeCulmWall = internodeCulmWall;
    }

    public String getYoungStemBack() {
        return youngStemBack;
    }

    public void setYoungStemBack(String youngStemBack) {
        this.youngStemBack = youngStemBack;
    }

    public String getYoungStemPowder() {
        return youngStemPowder;
    }

    public void setYoungStemPowder(String youngStemPowder) {
        this.youngStemPowder = youngStemPowder;
    }

    public String getCulmNode() {
        return culmNode;
    }

    public void setCulmNode(String culmNode) {
        this.culmNode = culmNode;
    }

    @Override
    public String toString() {
        return "Culm{" +
                "culmId=" + culmId +
                ", spec=" + spec +
                ", culmHeight='" + culmHeight + '\'' +
                ", culmDiameter='" + culmDiameter + '\'' +
                ", culmColor='" + culmColor + '\'' +
                ", culmTop='" + culmTop + '\'' +
                ", culmStem='" + culmStem + '\'' +
                ", internodeLength='" + internodeLength + '\'' +
                ", internodeShape='" + internodeShape + '\'' +
                ", internodeAerialRoot='" + internodeAerialRoot + '\'' +
                ", internodeBack='" + internodeBack + '\'' +
                ", internodeCulmWall='" + internodeCulmWall + '\'' +
                ", youngStemBack='" + youngStemBack + '\'' +
                ", youngStemPowder='" + youngStemPowder + '\'' +
                ", culmNode='" + culmNode + '\'' +
                '}';
    }
}
