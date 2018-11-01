package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（箨片表）
 * created by: 张理
 * 2018-10-26 19：00
 */
@Entity
@Table(name = "aau_bam_sheathshell_table", schema = "bambootattan", catalog = "")
public class SheathshellTable {
    private String sheShellId;
    private String specId;
    private String sheathShellShape;
    private String sheathShellColor;
    private String sheathShellFall;
    private String sheathShellTopShape;
    private String sheathShellBaseShape;
    private String sheathShellMargin;
    private String sheathShellBackPowder;
    private Double sheathRatioOf;

    @Id
    @Column(name = "SHE_SHELL_ID")
    public String getSheShellId() {
        return sheShellId;
    }

    public void setSheShellId(String sheShellId) {
        this.sheShellId = sheShellId;
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
    @Column(name = "SHEATH_SHELL_SHAPE")
    public String getSheathShellShape() {
        return sheathShellShape;
    }

    public void setSheathShellShape(String sheathShellShape) {
        this.sheathShellShape = sheathShellShape;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_COLOR")
    public String getSheathShellColor() {
        return sheathShellColor;
    }

    public void setSheathShellColor(String sheathShellColor) {
        this.sheathShellColor = sheathShellColor;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_FALL")
    public String getSheathShellFall() {
        return sheathShellFall;
    }

    public void setSheathShellFall(String sheathShellFall) {
        this.sheathShellFall = sheathShellFall;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_TOP_SHAPE")
    public String getSheathShellTopShape() {
        return sheathShellTopShape;
    }

    public void setSheathShellTopShape(String sheathShellTopShape) {
        this.sheathShellTopShape = sheathShellTopShape;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_BASE_SHAPE")
    public String getSheathShellBaseShape() {
        return sheathShellBaseShape;
    }

    public void setSheathShellBaseShape(String sheathShellBaseShape) {
        this.sheathShellBaseShape = sheathShellBaseShape;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_MARGIN")
    public String getSheathShellMargin() {
        return sheathShellMargin;
    }

    public void setSheathShellMargin(String sheathShellMargin) {
        this.sheathShellMargin = sheathShellMargin;
    }

    @Basic
    @Column(name = "SHEATH_SHELL_BACK_POWDER")
    public String getSheathShellBackPowder() {
        return sheathShellBackPowder;
    }

    public void setSheathShellBackPowder(String sheathShellBackPowder) {
        this.sheathShellBackPowder = sheathShellBackPowder;
    }

    @Basic
    @Column(name = "SHEATH_RATIO_OF")
    public Double getSheathRatioOf() {
        return sheathRatioOf;
    }

    public void setSheathRatioOf(Double sheathRatioOf) {
        this.sheathRatioOf = sheathRatioOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheathshellTable that = (SheathshellTable) o;
        return Objects.equals(sheShellId, that.sheShellId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(sheathShellShape, that.sheathShellShape) &&
                Objects.equals(sheathShellColor, that.sheathShellColor) &&
                Objects.equals(sheathShellFall, that.sheathShellFall) &&
                Objects.equals(sheathShellTopShape, that.sheathShellTopShape) &&
                Objects.equals(sheathShellBaseShape, that.sheathShellBaseShape) &&
                Objects.equals(sheathShellMargin, that.sheathShellMargin) &&
                Objects.equals(sheathShellBackPowder, that.sheathShellBackPowder) &&
                Objects.equals(sheathRatioOf, that.sheathRatioOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheShellId, specId, sheathShellShape, sheathShellColor, sheathShellFall, sheathShellTopShape, sheathShellBaseShape, sheathShellMargin, sheathShellBackPowder, sheathRatioOf);
    }
}
