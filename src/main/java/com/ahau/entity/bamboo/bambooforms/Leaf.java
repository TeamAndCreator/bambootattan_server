package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;

/**
 * 实体类：（竹叶表）
 * Created by: 张理
 * 2018-11-2 17：07
 */
@Entity
public class Leaf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leafId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 叶片形状 */
    private String leafShape;

    /* 叶片长度 */
    private String leafLength;

    /* 叶片宽度 */
    private String leafWidth;

    /* 每小枝具叶片数目 */
    private String leafNum;

    /* 叶片背面被毛 */
    private String leafBack;

    /* 叶片边缘锯齿 */
    private String leafMargin;

    /* 叶舌形状 */
    private String leafTongueShape;

    /* 叶舌高度 */
    private String leafTongueHeight;

    /* 叶柄长度 */
    private String leafStalkLength;

    /* 叶片基部形状 */
    private String leafBaseShape;

    /* 叶尖形态 */
    private String leafTopShape;

    public Long getLeafId() {
        return leafId;
    }

    public void setLeafId(Long leafId) {
        this.leafId = leafId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    public String getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(String leafLength) {
        this.leafLength = leafLength;
    }

    public String getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(String leafWidth) {
        this.leafWidth = leafWidth;
    }

    public String getLeafNum() {
        return leafNum;
    }

    public void setLeafNum(String leafNum) {
        this.leafNum = leafNum;
    }

    public String getLeafBack() {
        return leafBack;
    }

    public void setLeafBack(String leafBack) {
        this.leafBack = leafBack;
    }

    public String getLeafMargin() {
        return leafMargin;
    }

    public void setLeafMargin(String leafMargin) {
        this.leafMargin = leafMargin;
    }

    public String getLeafTongueShape() {
        return leafTongueShape;
    }

    public void setLeafTongueShape(String leafTongueShape) {
        this.leafTongueShape = leafTongueShape;
    }

    public String getLeafTongueHeight() {
        return leafTongueHeight;
    }

    public void setLeafTongueHeight(String leafTongueHeight) {
        this.leafTongueHeight = leafTongueHeight;
    }

    public String getLeafStalkLength() {
        return leafStalkLength;
    }

    public void setLeafStalkLength(String leafStalkLength) {
        this.leafStalkLength = leafStalkLength;
    }

    public String getLeafBaseShape() {
        return leafBaseShape;
    }

    public void setLeafBaseShape(String leafBaseShape) {
        this.leafBaseShape = leafBaseShape;
    }

    public String getLeafTopShape() {
        return leafTopShape;
    }

    public void setLeafTopShape(String leafTopShape) {
        this.leafTopShape = leafTopShape;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "leafId=" + leafId +
                ", spec=" + spec +
                ", leafShape='" + leafShape + '\'' +
                ", leafLength='" + leafLength + '\'' +
                ", leafWidth='" + leafWidth + '\'' +
                ", leafNum='" + leafNum + '\'' +
                ", leafBack='" + leafBack + '\'' +
                ", leafMargin='" + leafMargin + '\'' +
                ", leafTongueShape='" + leafTongueShape + '\'' +
                ", leafTongueHeight='" + leafTongueHeight + '\'' +
                ", leafStalkLength='" + leafStalkLength + '\'' +
                ", leafBaseShape='" + leafBaseShape + '\'' +
                ", leafTopShape='" + leafTopShape + '\'' +
                '}';
    }
}
