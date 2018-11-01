package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（解剖性质_纤维形态特征表）
 * Created by: 张理
 * 2018-11-1 16：24
 */
@Entity
@Table(name = "aau_tfibermorphology_table", schema = "bamboo_rattan", catalog = "")
public class TFibermorphologyTable {
    private String fmId;
    private String specId;
    private Double fmLengthUnitMicron;
    private Double fmWidthUnitMicron;
    private Double fmDwallThicknessUnitMicron;
    private Double fmLetWidthRatio;
    private Double fmCavityDeameterUnitMicrom;
    private Double fmWallCavityRatio;
    private Double fmCavityDiameterRatio;

    @Id
    @Column(name = "FM_ID")
    public String getFmId() {
        return fmId;
    }

    public void setFmId(String fmId) {
        this.fmId = fmId;
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
    @Column(name = "FM_LENGTH_UNIT_MICRON")
    public Double getFmLengthUnitMicron() {
        return fmLengthUnitMicron;
    }

    public void setFmLengthUnitMicron(Double fmLengthUnitMicron) {
        this.fmLengthUnitMicron = fmLengthUnitMicron;
    }

    @Basic
    @Column(name = "FM_WIDTH_UNIT_MICRON")
    public Double getFmWidthUnitMicron() {
        return fmWidthUnitMicron;
    }

    public void setFmWidthUnitMicron(Double fmWidthUnitMicron) {
        this.fmWidthUnitMicron = fmWidthUnitMicron;
    }

    @Basic
    @Column(name = "FM_DWALL_THICKNESS_UNIT_MICRON")
    public Double getFmDwallThicknessUnitMicron() {
        return fmDwallThicknessUnitMicron;
    }

    public void setFmDwallThicknessUnitMicron(Double fmDwallThicknessUnitMicron) {
        this.fmDwallThicknessUnitMicron = fmDwallThicknessUnitMicron;
    }

    @Basic
    @Column(name = "FM_LET_WIDTH_RATIO")
    public Double getFmLetWidthRatio() {
        return fmLetWidthRatio;
    }

    public void setFmLetWidthRatio(Double fmLetWidthRatio) {
        this.fmLetWidthRatio = fmLetWidthRatio;
    }

    @Basic
    @Column(name = "FM_CAVITY_DEAMETER_UNIT_MICROM")
    public Double getFmCavityDeameterUnitMicrom() {
        return fmCavityDeameterUnitMicrom;
    }

    public void setFmCavityDeameterUnitMicrom(Double fmCavityDeameterUnitMicrom) {
        this.fmCavityDeameterUnitMicrom = fmCavityDeameterUnitMicrom;
    }

    @Basic
    @Column(name = "FM_WALL_CAVITY_RATIO")
    public Double getFmWallCavityRatio() {
        return fmWallCavityRatio;
    }

    public void setFmWallCavityRatio(Double fmWallCavityRatio) {
        this.fmWallCavityRatio = fmWallCavityRatio;
    }

    @Basic
    @Column(name = "FM_CAVITY_DIAMETER_RATIO")
    public Double getFmCavityDiameterRatio() {
        return fmCavityDiameterRatio;
    }

    public void setFmCavityDiameterRatio(Double fmCavityDiameterRatio) {
        this.fmCavityDiameterRatio = fmCavityDiameterRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TFibermorphologyTable that = (TFibermorphologyTable) o;
        return Objects.equals(fmId, that.fmId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(fmLengthUnitMicron, that.fmLengthUnitMicron) &&
                Objects.equals(fmWidthUnitMicron, that.fmWidthUnitMicron) &&
                Objects.equals(fmDwallThicknessUnitMicron, that.fmDwallThicknessUnitMicron) &&
                Objects.equals(fmLetWidthRatio, that.fmLetWidthRatio) &&
                Objects.equals(fmCavityDeameterUnitMicrom, that.fmCavityDeameterUnitMicrom) &&
                Objects.equals(fmWallCavityRatio, that.fmWallCavityRatio) &&
                Objects.equals(fmCavityDiameterRatio, that.fmCavityDiameterRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fmId, specId, fmLengthUnitMicron, fmWidthUnitMicron, fmDwallThicknessUnitMicron, fmLetWidthRatio, fmCavityDeameterUnitMicrom, fmWallCavityRatio, fmCavityDiameterRatio);
    }
}
