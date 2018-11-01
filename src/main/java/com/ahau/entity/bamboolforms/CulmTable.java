package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（竹秆表）
 * Created by: 张理
 * 2018-10-26 15：30
 */
@Entity
@Table(name = "aau_bam_culm_table", schema = "bambootattan", catalog = "")
public class CulmTable {
    private String culmId;
    private String specId;
    private String culmHeight;
    private String culmDiameter;
    private String culmColor;
    private String culmTop;
    private String culmStem;
    private String internodeLength;
    private String internodeShape;
    private String internodeAerialRoot;
    private String internodeBack;
    private String internodeCulmWall;
    private String youngStemBack;
    private String youngStemPowder;
    private String culmNode;

    @Id
    @Column(name = "CULM_ID")
    public String getCulmId() {
        return culmId;
    }

    public void setCulmId(String culmId) {
        this.culmId = culmId;
    }

    @Basic
    @Column(name = "SPEC_ID")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "CULM_HEIGHT")
    public String getCulmHeight() {
        return culmHeight;
    }

    public void setCulmHeight(String culmHeight) {
        this.culmHeight = culmHeight;
    }

    @Basic
    @Column(name = "CULM_DIAMETER")
    public String getCulmDiameter() {
        return culmDiameter;
    }

    public void setCulmDiameter(String culmDiameter) {
        this.culmDiameter = culmDiameter;
    }

    @Basic
    @Column(name = "CULM_COLOR")
    public String getCulmColor() {
        return culmColor;
    }

    public void setCulmColor(String culmColor) {
        this.culmColor = culmColor;
    }

    @Basic
    @Column(name = "CULM_TOP")
    public String getCulmTop() {
        return culmTop;
    }

    public void setCulmTop(String culmTop) {
        this.culmTop = culmTop;
    }

    @Basic
    @Column(name = "CULM_STEM")
    public String getCulmStem() {
        return culmStem;
    }

    public void setCulmStem(String culmStem) {
        this.culmStem = culmStem;
    }

    @Basic
    @Column(name = "INTERNODE_LENGTH")
    public String getInternodeLength() {
        return internodeLength;
    }

    public void setInternodeLength(String internodeLength) {
        this.internodeLength = internodeLength;
    }

    @Basic
    @Column(name = "INTERNODE_SHAPE")
    public String getInternodeShape() {
        return internodeShape;
    }

    public void setInternodeShape(String internodeShape) {
        this.internodeShape = internodeShape;
    }

    @Basic
    @Column(name = "INTERNODE_AERIAL_ROOT")
    public String getInternodeAerialRoot() {
        return internodeAerialRoot;
    }

    public void setInternodeAerialRoot(String internodeAerialRoot) {
        this.internodeAerialRoot = internodeAerialRoot;
    }

    @Basic
    @Column(name = "INTERNODE_BACK")
    public String getInternodeBack() {
        return internodeBack;
    }

    public void setInternodeBack(String internodeBack) {
        this.internodeBack = internodeBack;
    }

    @Basic
    @Column(name = "INTERNODE_CULM_WALL")
    public String getInternodeCulmWall() {
        return internodeCulmWall;
    }

    public void setInternodeCulmWall(String internodeCulmWall) {
        this.internodeCulmWall = internodeCulmWall;
    }

    @Basic
    @Column(name = "YOUNG_STEM_BACK")
    public String getYoungStemBack() {
        return youngStemBack;
    }

    public void setYoungStemBack(String youngStemBack) {
        this.youngStemBack = youngStemBack;
    }

    @Basic
    @Column(name = "YOUNG_STEM_POWDER")
    public String getYoungStemPowder() {
        return youngStemPowder;
    }

    public void setYoungStemPowder(String youngStemPowder) {
        this.youngStemPowder = youngStemPowder;
    }

    @Basic
    @Column(name = "CULM_NODE")
    public String getCulmNode() {
        return culmNode;
    }

    public void setCulmNode(String culmNode) {
        this.culmNode = culmNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CulmTable that = (CulmTable) o;
        return Objects.equals(culmId, that.culmId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(culmHeight, that.culmHeight) &&
                Objects.equals(culmDiameter, that.culmDiameter) &&
                Objects.equals(culmColor, that.culmColor) &&
                Objects.equals(culmTop, that.culmTop) &&
                Objects.equals(culmStem, that.culmStem) &&
                Objects.equals(internodeLength, that.internodeLength) &&
                Objects.equals(internodeShape, that.internodeShape) &&
                Objects.equals(internodeAerialRoot, that.internodeAerialRoot) &&
                Objects.equals(internodeBack, that.internodeBack) &&
                Objects.equals(internodeCulmWall, that.internodeCulmWall) &&
                Objects.equals(youngStemBack, that.youngStemBack) &&
                Objects.equals(youngStemPowder, that.youngStemPowder) &&
                Objects.equals(culmNode, that.culmNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(culmId, specId, culmHeight, culmDiameter, culmColor, culmTop, culmStem, internodeLength, internodeShape, internodeAerialRoot, internodeBack, internodeCulmWall, youngStemBack, youngStemPowder, culmNode);
    }
}
