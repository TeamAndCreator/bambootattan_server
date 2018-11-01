package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（箨耳表）
 * created by: 张理
 * 2018-10-26 17：20
 */
@Entity
@Table(name = "aau_bam_sheathear_table", schema = "bambootattan", catalog = "")
public class SheathearTable {
    private String sheEarId;
    private String specId;
    private String sheathEarDev;
    private String sheathEarShape;
    private String sheathEarMargin;

    @Id
    @Column(name = "SHE_EAR_ID")
    public String getSheEarId() {
        return sheEarId;
    }

    public void setSheEarId(String sheEarId) {
        this.sheEarId = sheEarId;
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
    @Column(name = "SHEATH_EAR_DEV")
    public String getSheathEarDev() {
        return sheathEarDev;
    }

    public void setSheathEarDev(String sheathEarDev) {
        this.sheathEarDev = sheathEarDev;
    }

    @Basic
    @Column(name = "SHEATH_EAR_SHAPE")
    public String getSheathEarShape() {
        return sheathEarShape;
    }

    public void setSheathEarShape(String sheathEarShape) {
        this.sheathEarShape = sheathEarShape;
    }

    @Basic
    @Column(name = "SHEATH_EAR_MARGIN")
    public String getSheathEarMargin() {
        return sheathEarMargin;
    }

    public void setSheathEarMargin(String sheathEarMargin) {
        this.sheathEarMargin = sheathEarMargin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheathearTable that = (SheathearTable) o;
        return Objects.equals(sheEarId, that.sheEarId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(sheathEarDev, that.sheathEarDev) &&
                Objects.equals(sheathEarShape, that.sheathEarShape) &&
                Objects.equals(sheathEarMargin, that.sheathEarMargin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheEarId, specId, sheathEarDev, sheathEarShape, sheathEarMargin);
    }
}
