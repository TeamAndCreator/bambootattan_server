package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（藤箨舌表）
 * Created by: 张理
 * 2018-4-1
 */
@Entity
public class TSheathtongue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheTogId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 箨舌颜色 */
    private String sheathTongueColor;

    /* 箨舌高度 */
    private String sheathTongueHeight;

    /* 箨舌边缘形状 */
    private String sheathTongueMarginShape;

    /* 箨舌被毛被粉 */
    private String sheathTongueBackPowderv;

    public Long getSheTogId() {
        return sheTogId;
    }

    public void setSheTogId(Long sheTogId) {
        this.sheTogId = sheTogId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getSheathTongueColor() {
        return sheathTongueColor;
    }

    public void setSheathTongueColor(String sheathTongueColor) {
        this.sheathTongueColor = sheathTongueColor;
    }

    public String getSheathTongueHeight() {
        return sheathTongueHeight;
    }

    public void setSheathTongueHeight(String sheathTongueHeight) {
        this.sheathTongueHeight = sheathTongueHeight;
    }

    public String getSheathTongueMarginShape() {
        return sheathTongueMarginShape;
    }

    public void setSheathTongueMarginShape(String sheathTongueMarginShape) {
        this.sheathTongueMarginShape = sheathTongueMarginShape;
    }

    public String getSheathTongueBackPowderv() {
        return sheathTongueBackPowderv;
    }

    public void setSheathTongueBackPowderv(String sheathTongueBackPowderv) {
        this.sheathTongueBackPowderv = sheathTongueBackPowderv;
    }

    @Override
    public String toString() {
        return "TSheathtongue{" +
                "sheTogId=" + sheTogId +
                ", rattanSpec=" + rattanSpec +
                ", sheathTongueColor='" + sheathTongueColor + '\'' +
                ", sheathTongueHeight='" + sheathTongueHeight + '\'' +
                ", sheathTongueMarginShape='" + sheathTongueMarginShape + '\'' +
                ", sheathTongueBackPowderv='" + sheathTongueBackPowderv + '\'' +
                '}';
    }
}
