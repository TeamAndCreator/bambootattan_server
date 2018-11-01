package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（箨舌表）
 * created by: 张理
 * 2018-10-26 18：30
 */
@Entity
@Table(name = "aau_bam_sheathtongue_table", schema = "bambootattan", catalog = "")
public class SheathtongueTable {
    private String sheTogId;
    private String specId;
    private String sheathTongueColor;
    private String sheathTongueHeight;
    private String sheathTongueMarginShape;
    private String sheathTongueBackPowderv;

    @Id
    @Column(name = "SHE_TOG_ID")
    public String getSheTogId() {
        return sheTogId;
    }

    public void setSheTogId(String sheTogId) {
        this.sheTogId = sheTogId;
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
    @Column(name = "SHEATH_TONGUE_COLOR")
    public String getSheathTongueColor() {
        return sheathTongueColor;
    }

    public void setSheathTongueColor(String sheathTongueColor) {
        this.sheathTongueColor = sheathTongueColor;
    }

    @Basic
    @Column(name = "SHEATH_TONGUE_HEIGHT")
    public String getSheathTongueHeight() {
        return sheathTongueHeight;
    }

    public void setSheathTongueHeight(String sheathTongueHeight) {
        this.sheathTongueHeight = sheathTongueHeight;
    }

    @Basic
    @Column(name = "SHEATH_TONGUE_MARGIN_SHAPE")
    public String getSheathTongueMarginShape() {
        return sheathTongueMarginShape;
    }

    public void setSheathTongueMarginShape(String sheathTongueMarginShape) {
        this.sheathTongueMarginShape = sheathTongueMarginShape;
    }

    @Basic
    @Column(name = "SHEATH_TONGUE_BACK_POWDERV")
    public String getSheathTongueBackPowderv() {
        return sheathTongueBackPowderv;
    }

    public void setSheathTongueBackPowderv(String sheathTongueBackPowderv) {
        this.sheathTongueBackPowderv = sheathTongueBackPowderv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheathtongueTable that = (SheathtongueTable) o;
        return Objects.equals(sheTogId, that.sheTogId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(sheathTongueColor, that.sheathTongueColor) &&
                Objects.equals(sheathTongueHeight, that.sheathTongueHeight) &&
                Objects.equals(sheathTongueMarginShape, that.sheathTongueMarginShape) &&
                Objects.equals(sheathTongueBackPowderv, that.sheathTongueBackPowderv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheTogId, specId, sheathTongueColor, sheathTongueHeight, sheathTongueMarginShape, sheathTongueBackPowderv);
    }
}
