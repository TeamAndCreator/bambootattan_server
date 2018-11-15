package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;

/**
 * 实体类：（箨舌表）
 * Created by: 张理
 * 2018-11-3 11：09
 */
@Entity
public class Sheathtongue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheTogId;

    /* 种标识 */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Sheathtongue{" +
                "sheTogId=" + sheTogId +
                ", spec='" + spec + '\'' +
                ", sheathTongueColor='" + sheathTongueColor + '\'' +
                ", sheathTongueHeight='" + sheathTongueHeight + '\'' +
                ", sheathTongueMarginShape='" + sheathTongueMarginShape + '\'' +
                ", sheathTongueBackPowderv='" + sheathTongueBackPowderv + '\'' +
                '}';
    }
}
