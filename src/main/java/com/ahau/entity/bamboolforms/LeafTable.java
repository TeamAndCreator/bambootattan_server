package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 *实体类：（竹叶表）
 * created by: 张理
 * 2018-10-26 19：30
 */
@Entity
@Table(name = "aau_bam_leaf_table", schema = "bambootattan", catalog = "")
public class LeafTable {
    private String leafId;
    private String specId;
    private String leafShape;
    private String leafLength;
    private String leafWidth;
    private String leafNum;
    private String leafBack;
    private String leafMargin;
    private String leafTongueShape;
    private String leafTongueHeight;
    private String leafStalkLength;
    private String leafBaseShape;
    private String leafTopShape;

    @Id
    @Column(name = "LEAF_ID")
    public String getLeafId() {
        return leafId;
    }

    public void setLeafId(String leafId) {
        this.leafId = leafId;
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
    @Column(name = "LEAF_SHAPE")
    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    @Basic
    @Column(name = "LEAF_LENGTH")
    public String getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(String leafLength) {
        this.leafLength = leafLength;
    }

    @Basic
    @Column(name = "LEAF_WIDTH")
    public String getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(String leafWidth) {
        this.leafWidth = leafWidth;
    }

    @Basic
    @Column(name = "LEAF_NUM")
    public String getLeafNum() {
        return leafNum;
    }

    public void setLeafNum(String leafNum) {
        this.leafNum = leafNum;
    }

    @Basic
    @Column(name = "LEAF_BACK")
    public String getLeafBack() {
        return leafBack;
    }

    public void setLeafBack(String leafBack) {
        this.leafBack = leafBack;
    }

    @Basic
    @Column(name = "LEAF_MARGIN")
    public String getLeafMargin() {
        return leafMargin;
    }

    public void setLeafMargin(String leafMargin) {
        this.leafMargin = leafMargin;
    }

    @Basic
    @Column(name = "LEAF_TONGUE_SHAPE")
    public String getLeafTongueShape() {
        return leafTongueShape;
    }

    public void setLeafTongueShape(String leafTongueShape) {
        this.leafTongueShape = leafTongueShape;
    }

    @Basic
    @Column(name = "LEAF_TONGUE_HEIGHT")
    public String getLeafTongueHeight() {
        return leafTongueHeight;
    }

    public void setLeafTongueHeight(String leafTongueHeight) {
        this.leafTongueHeight = leafTongueHeight;
    }

    @Basic
    @Column(name = "LEAF_STALK_LENGTH")
    public String getLeafStalkLength() {
        return leafStalkLength;
    }

    public void setLeafStalkLength(String leafStalkLength) {
        this.leafStalkLength = leafStalkLength;
    }

    @Basic
    @Column(name = "LEAF_BASE_SHAPE")
    public String getLeafBaseShape() {
        return leafBaseShape;
    }

    public void setLeafBaseShape(String leafBaseShape) {
        this.leafBaseShape = leafBaseShape;
    }

    @Basic
    @Column(name = "LEAF_TOP_SHAPE")
    public String getLeafTopShape() {
        return leafTopShape;
    }

    public void setLeafTopShape(String leafTopShape) {
        this.leafTopShape = leafTopShape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafTable that = (LeafTable) o;
        return Objects.equals(leafId, that.leafId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(leafShape, that.leafShape) &&
                Objects.equals(leafLength, that.leafLength) &&
                Objects.equals(leafWidth, that.leafWidth) &&
                Objects.equals(leafNum, that.leafNum) &&
                Objects.equals(leafBack, that.leafBack) &&
                Objects.equals(leafMargin, that.leafMargin) &&
                Objects.equals(leafTongueShape, that.leafTongueShape) &&
                Objects.equals(leafTongueHeight, that.leafTongueHeight) &&
                Objects.equals(leafStalkLength, that.leafStalkLength) &&
                Objects.equals(leafBaseShape, that.leafBaseShape) &&
                Objects.equals(leafTopShape, that.leafTopShape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leafId, specId, leafShape, leafLength, leafWidth, leafNum, leafBack, leafMargin, leafTongueShape, leafTongueHeight, leafStalkLength, leafBaseShape, leafTopShape);
    }
}
