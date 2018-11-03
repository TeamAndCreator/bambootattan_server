package com.ahau.entity.bamboo.bambooforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String specId;

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

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
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
                ", specId='" + specId + '\'' +
                ", sheathTongueColor='" + sheathTongueColor + '\'' +
                ", sheathTongueHeight='" + sheathTongueHeight + '\'' +
                ", sheathTongueMarginShape='" + sheathTongueMarginShape + '\'' +
                ", sheathTongueBackPowderv='" + sheathTongueBackPowderv + '\'' +
                '}';
    }
}
