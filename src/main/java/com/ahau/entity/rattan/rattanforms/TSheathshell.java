package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（藤箨片表）
 * Created by: 张理
 * 2018-4-1
 */
@Entity
public class TSheathshell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheShellId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 箨片形状 */
    private String sheathShellShape;

    /* 箨片颜色 */
    private String sheathShellColor;

    /* 箨片是否易脱落 */
    private String sheathShellFall;

    /* 箨片先端形 */
    private String sheathShellTopShape;

    /* 箨片基部形状 */
    private String sheathShellBaseShape;

    /* 箨片边缘形态 */
    private String sheathShellMargin;

    /* 箨片背面被毛被粉 */
    private String sheathShellBackPowder;

    /* 箨片基底与箨鞘宽度之比 */
    private Double sheathRatioOf;

    public Long getSheShellId() {
        return sheShellId;
    }

    public void setSheShellId(Long sheShellId) {
        this.sheShellId = sheShellId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getSheathShellShape() {
        return sheathShellShape;
    }

    public void setSheathShellShape(String sheathShellShape) {
        this.sheathShellShape = sheathShellShape;
    }

    public String getSheathShellColor() {
        return sheathShellColor;
    }

    public void setSheathShellColor(String sheathShellColor) {
        this.sheathShellColor = sheathShellColor;
    }

    public String getSheathShellFall() {
        return sheathShellFall;
    }

    public void setSheathShellFall(String sheathShellFall) {
        this.sheathShellFall = sheathShellFall;
    }

    public String getSheathShellTopShape() {
        return sheathShellTopShape;
    }

    public void setSheathShellTopShape(String sheathShellTopShape) {
        this.sheathShellTopShape = sheathShellTopShape;
    }

    public String getSheathShellBaseShape() {
        return sheathShellBaseShape;
    }

    public void setSheathShellBaseShape(String sheathShellBaseShape) {
        this.sheathShellBaseShape = sheathShellBaseShape;
    }

    public String getSheathShellMargin() {
        return sheathShellMargin;
    }

    public void setSheathShellMargin(String sheathShellMargin) {
        this.sheathShellMargin = sheathShellMargin;
    }

    public String getSheathShellBackPowder() {
        return sheathShellBackPowder;
    }

    public void setSheathShellBackPowder(String sheathShellBackPowder) {
        this.sheathShellBackPowder = sheathShellBackPowder;
    }

    public Double getSheathRatioOf() {
        return sheathRatioOf;
    }

    public void setSheathRatioOf(Double sheathRatioOf) {
        this.sheathRatioOf = sheathRatioOf;
    }

    @Override
    public String toString() {
        return "TSheathshell{" +
                "sheShellId=" + sheShellId +
                ", rattanSpec=" + rattanSpec +
                ", sheathShellShape='" + sheathShellShape + '\'' +
                ", sheathShellColor='" + sheathShellColor + '\'' +
                ", sheathShellFall='" + sheathShellFall + '\'' +
                ", sheathShellTopShape='" + sheathShellTopShape + '\'' +
                ", sheathShellBaseShape='" + sheathShellBaseShape + '\'' +
                ", sheathShellMargin='" + sheathShellMargin + '\'' +
                ", sheathShellBackPowder='" + sheathShellBackPowder + '\'' +
                ", sheathRatioOf=" + sheathRatioOf +
                '}';
    }
}
