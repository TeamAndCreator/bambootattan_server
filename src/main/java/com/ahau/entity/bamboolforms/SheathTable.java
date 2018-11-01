package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（箨鞘表）
 * created by: 张理
 * 2018-10-26 17：10
 */
@Entity
@Table(name = "aau_bam_sheath_table", schema = "bambootattan", catalog = "")
public class SheathTable {
    private String sheId;
    private String specId;
    private String sheathShedTime;
    private String sheathChar;
    private String sheathTopForm;
    private String sheathBackPowder;
    private String sheathMarginForm;

    @Id
    @Column(name = "SHE_ID")
    public String getSheId() {
        return sheId;
    }

    public void setSheId(String sheId) {
        this.sheId = sheId;
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
    @Column(name = "SHEATH_SHED_TIME")
    public String getSheathShedTime() {
        return sheathShedTime;
    }

    public void setSheathShedTime(String sheathShedTime) {
        this.sheathShedTime = sheathShedTime;
    }

    @Basic
    @Column(name = "SHEATH_CHAR")
    public String getSheathChar() {
        return sheathChar;
    }

    public void setSheathChar(String sheathChar) {
        this.sheathChar = sheathChar;
    }

    @Basic
    @Column(name = "SHEATH_TOP_FORM")
    public String getSheathTopForm() {
        return sheathTopForm;
    }

    public void setSheathTopForm(String sheathTopForm) {
        this.sheathTopForm = sheathTopForm;
    }

    @Basic
    @Column(name = "SHEATH_BACK_POWDER")
    public String getSheathBackPowder() {
        return sheathBackPowder;
    }

    public void setSheathBackPowder(String sheathBackPowder) {
        this.sheathBackPowder = sheathBackPowder;
    }

    @Basic
    @Column(name = "SHEATH_MARGIN_FORM")
    public String getSheathMarginForm() {
        return sheathMarginForm;
    }

    public void setSheathMarginForm(String sheathMarginForm) {
        this.sheathMarginForm = sheathMarginForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheathTable that = (SheathTable) o;
        return Objects.equals(sheId, that.sheId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(sheathShedTime, that.sheathShedTime) &&
                Objects.equals(sheathChar, that.sheathChar) &&
                Objects.equals(sheathTopForm, that.sheathTopForm) &&
                Objects.equals(sheathBackPowder, that.sheathBackPowder) &&
                Objects.equals(sheathMarginForm, that.sheathMarginForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheId, specId, sheathShedTime, sheathChar, sheathTopForm, sheathBackPowder, sheathMarginForm);
    }
}
