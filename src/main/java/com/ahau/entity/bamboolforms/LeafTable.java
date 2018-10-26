package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *实体类：（竹叶表）
 * created by: 张理
 * 2018-10-26 19：30
 */
@Entity
public class LeafTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 叶片形状 */
    private String leafShape;
    /* 叶片形状（模糊查询） */
    private String leafShapeLike;
    /* 叶片长度 */
    private String leafLength;
    /* 叶片长度（模糊查询） */
    private String leafLengthLike;
    /* 叶片宽度 */
    private String leafWidth;
    /* 叶片宽度（模糊查询） */
    private String leafWidthLike;
    /* 每小枝具叶片数目 */
    private String leafNum;
    /* 每小枝具叶片数目（模糊查询） */
    private String leafNumLike;
    /* 叶片背面被毛 */
    private String leafBack;
    /* 叶片背面被毛（模糊查询） */
    private String leafBackLike;
    /* 叶片边缘锯齿 */
    private String leafMargin;
    /* 叶片边缘锯齿（模糊查询） */
    private String leafMarginLike;
    /* 叶舌形状 */
    private String leafTongueShape;
    /* 叶舌形状（模糊查询） */
    private String leafTongueShapeLike;
    /* 叶舌高度 */
    private String leafTongueHeight;
    /* 叶舌高度（模糊查询） */
    private String leafTongueHeightLike;
    /* 叶柄长度 */
    private String leafStalkLength;
    /* 叶柄长度（模糊查询） */
    private String leafStalkLengthLike;
    /* 叶片基部形状 */
    private String leafBaseShape;
    /* 叶片基部形状（模糊查询） */
    private String leafBaseShapeLike;
    /* 叶尖形态 */
    private String leafTopShape;
    /* 叶尖形态（模糊查询） */
    private String leafTopShapeLike;

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

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    public String getLeafShapeLike() {
        return leafShapeLike;
    }

    public void setLeafShapeLike(String leafShapeLike) {
        this.leafShapeLike = leafShapeLike;
    }

    public String getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(String leafLength) {
        this.leafLength = leafLength;
    }

    public String getLeafLengthLike() {
        return leafLengthLike;
    }

    public void setLeafLengthLike(String leafLengthLike) {
        this.leafLengthLike = leafLengthLike;
    }

    public String getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(String leafWidth) {
        this.leafWidth = leafWidth;
    }

    public String getLeafWidthLike() {
        return leafWidthLike;
    }

    public void setLeafWidthLike(String leafWidthLike) {
        this.leafWidthLike = leafWidthLike;
    }

    public String getLeafNum() {
        return leafNum;
    }

    public void setLeafNum(String leafNum) {
        this.leafNum = leafNum;
    }

    public String getLeafNumLike() {
        return leafNumLike;
    }

    public void setLeafNumLike(String leafNumLike) {
        this.leafNumLike = leafNumLike;
    }

    public String getLeafBack() {
        return leafBack;
    }

    public void setLeafBack(String leafBack) {
        this.leafBack = leafBack;
    }

    public String getLeafBackLike() {
        return leafBackLike;
    }

    public void setLeafBackLike(String leafBackLike) {
        this.leafBackLike = leafBackLike;
    }

    public String getLeafMargin() {
        return leafMargin;
    }

    public void setLeafMargin(String leafMargin) {
        this.leafMargin = leafMargin;
    }

    public String getLeafMarginLike() {
        return leafMarginLike;
    }

    public void setLeafMarginLike(String leafMarginLike) {
        this.leafMarginLike = leafMarginLike;
    }

    public String getLeafTongueShape() {
        return leafTongueShape;
    }

    public void setLeafTongueShape(String leafTongueShape) {
        this.leafTongueShape = leafTongueShape;
    }

    public String getLeafTongueShapeLike() {
        return leafTongueShapeLike;
    }

    public void setLeafTongueShapeLike(String leafTongueShapeLike) {
        this.leafTongueShapeLike = leafTongueShapeLike;
    }

    public String getLeafTongueHeight() {
        return leafTongueHeight;
    }

    public void setLeafTongueHeight(String leafTongueHeight) {
        this.leafTongueHeight = leafTongueHeight;
    }

    public String getLeafTongueHeightLike() {
        return leafTongueHeightLike;
    }

    public void setLeafTongueHeightLike(String leafTongueHeightLike) {
        this.leafTongueHeightLike = leafTongueHeightLike;
    }

    public String getLeafStalkLength() {
        return leafStalkLength;
    }

    public void setLeafStalkLength(String leafStalkLength) {
        this.leafStalkLength = leafStalkLength;
    }

    public String getLeafStalkLengthLike() {
        return leafStalkLengthLike;
    }

    public void setLeafStalkLengthLike(String leafStalkLengthLike) {
        this.leafStalkLengthLike = leafStalkLengthLike;
    }

    public String getLeafBaseShape() {
        return leafBaseShape;
    }

    public void setLeafBaseShape(String leafBaseShape) {
        this.leafBaseShape = leafBaseShape;
    }

    public String getLeafBaseShapeLike() {
        return leafBaseShapeLike;
    }

    public void setLeafBaseShapeLike(String leafBaseShapeLike) {
        this.leafBaseShapeLike = leafBaseShapeLike;
    }

    public String getLeafTopShape() {
        return leafTopShape;
    }

    public void setLeafTopShape(String leafTopShape) {
        this.leafTopShape = leafTopShape;
    }

    public String getLeafTopShapeLike() {
        return leafTopShapeLike;
    }

    public void setLeafTopShapeLike(String leafTopShapeLike) {
        this.leafTopShapeLike = leafTopShapeLike;
    }
}
