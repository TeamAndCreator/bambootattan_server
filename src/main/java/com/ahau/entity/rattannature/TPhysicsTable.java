package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（物理性质表）
 * Created by: 张理
 * 2018-11-1 16：36
 */
@Entity
@Table(name = "aau_tphysics_table", schema = "bambootattan", catalog = "")
public class TPhysicsTable {
    private String phyId;
    private String specId;
    private Double phyRelativeUnitPercent;
    private Double phyAbsoluteUnitPercent;
    private Double phyGreenDensityUnitMidu;
    private Double phyBasicDensityUnitMidu;
    private Double phyAirDryDensityUnitMidu;
    private Double phyAbsoluteDryDensityUnitMidu;
    private Double phyAirDryingLineUnitPercent;
    private Double phyWholeDryLineUnitPercent;
    private Double phyAirDryVolumeUnitPercent;
    private Double phyWholeDryVolumeUnitPercent;
    private Double phyAirShrinkageUnitPercent;
    private Double phyAirShrinkageChordwiseUnitPercent;
    private Double phyAirShrinkageRadialUnitPercent;
    private Double phyAirShrinkageEdnwiseUnitPercent;
    private Double phyAirShrinkageVolumeUnitPercent;
    private Double phyWholeShrinkageChordwiseUnitPercent;
    private Double phyWholeShrinkageRadialUnitPercent;
    private Double phyWholeShrinkageEdnwiseUnitPercent;
    private Double phyWholeShrinkageVolumeUnitPercent;

    @Id
    @Column(name = "PHY_ID")
    public String getPhyId() {
        return phyId;
    }

    public void setPhyId(String phyId) {
        this.phyId = phyId;
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
    @Column(name = "PHY_RELATIVE_UNIT_PERCENT")
    public Double getPhyRelativeUnitPercent() {
        return phyRelativeUnitPercent;
    }

    public void setPhyRelativeUnitPercent(Double phyRelativeUnitPercent) {
        this.phyRelativeUnitPercent = phyRelativeUnitPercent;
    }

    @Basic
    @Column(name = "PHY_ABSOLUTE_UNIT_PERCENT")
    public Double getPhyAbsoluteUnitPercent() {
        return phyAbsoluteUnitPercent;
    }

    public void setPhyAbsoluteUnitPercent(Double phyAbsoluteUnitPercent) {
        this.phyAbsoluteUnitPercent = phyAbsoluteUnitPercent;
    }

    @Basic
    @Column(name = "PHY_GREEN_DENSITY_UNIT_MIDU")
    public Double getPhyGreenDensityUnitMidu() {
        return phyGreenDensityUnitMidu;
    }

    public void setPhyGreenDensityUnitMidu(Double phyGreenDensityUnitMidu) {
        this.phyGreenDensityUnitMidu = phyGreenDensityUnitMidu;
    }

    @Basic
    @Column(name = "PHY_BASIC_DENSITY_UNIT_MIDU")
    public Double getPhyBasicDensityUnitMidu() {
        return phyBasicDensityUnitMidu;
    }

    public void setPhyBasicDensityUnitMidu(Double phyBasicDensityUnitMidu) {
        this.phyBasicDensityUnitMidu = phyBasicDensityUnitMidu;
    }

    @Basic
    @Column(name = "PHY_AIR_DRY_DENSITY_UNIT_MIDU")
    public Double getPhyAirDryDensityUnitMidu() {
        return phyAirDryDensityUnitMidu;
    }

    public void setPhyAirDryDensityUnitMidu(Double phyAirDryDensityUnitMidu) {
        this.phyAirDryDensityUnitMidu = phyAirDryDensityUnitMidu;
    }

    @Basic
    @Column(name = "PHY_ABSOLUTE_DRY_DENSITY_UNIT_MIDU")
    public Double getPhyAbsoluteDryDensityUnitMidu() {
        return phyAbsoluteDryDensityUnitMidu;
    }

    public void setPhyAbsoluteDryDensityUnitMidu(Double phyAbsoluteDryDensityUnitMidu) {
        this.phyAbsoluteDryDensityUnitMidu = phyAbsoluteDryDensityUnitMidu;
    }

    @Basic
    @Column(name = "PHY_AIR_DRYING_LINE_UNIT_PERCENT")
    public Double getPhyAirDryingLineUnitPercent() {
        return phyAirDryingLineUnitPercent;
    }

    public void setPhyAirDryingLineUnitPercent(Double phyAirDryingLineUnitPercent) {
        this.phyAirDryingLineUnitPercent = phyAirDryingLineUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_DRY_LINE_UNIT_PERCENT")
    public Double getPhyWholeDryLineUnitPercent() {
        return phyWholeDryLineUnitPercent;
    }

    public void setPhyWholeDryLineUnitPercent(Double phyWholeDryLineUnitPercent) {
        this.phyWholeDryLineUnitPercent = phyWholeDryLineUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_DRY_VOLUME_UNIT_PERCENT")
    public Double getPhyAirDryVolumeUnitPercent() {
        return phyAirDryVolumeUnitPercent;
    }

    public void setPhyAirDryVolumeUnitPercent(Double phyAirDryVolumeUnitPercent) {
        this.phyAirDryVolumeUnitPercent = phyAirDryVolumeUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_DRY_VOLUME_UNIT_PERCENT")
    public Double getPhyWholeDryVolumeUnitPercent() {
        return phyWholeDryVolumeUnitPercent;
    }

    public void setPhyWholeDryVolumeUnitPercent(Double phyWholeDryVolumeUnitPercent) {
        this.phyWholeDryVolumeUnitPercent = phyWholeDryVolumeUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_SHRINKAGE_UNIT_PERCENT")
    public Double getPhyAirShrinkageUnitPercent() {
        return phyAirShrinkageUnitPercent;
    }

    public void setPhyAirShrinkageUnitPercent(Double phyAirShrinkageUnitPercent) {
        this.phyAirShrinkageUnitPercent = phyAirShrinkageUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_SHRINKAGE_CHORDWISE_UNIT_PERCENT")
    public Double getPhyAirShrinkageChordwiseUnitPercent() {
        return phyAirShrinkageChordwiseUnitPercent;
    }

    public void setPhyAirShrinkageChordwiseUnitPercent(Double phyAirShrinkageChordwiseUnitPercent) {
        this.phyAirShrinkageChordwiseUnitPercent = phyAirShrinkageChordwiseUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_SHRINKAGE_RADIAL_UNIT_PERCENT")
    public Double getPhyAirShrinkageRadialUnitPercent() {
        return phyAirShrinkageRadialUnitPercent;
    }

    public void setPhyAirShrinkageRadialUnitPercent(Double phyAirShrinkageRadialUnitPercent) {
        this.phyAirShrinkageRadialUnitPercent = phyAirShrinkageRadialUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_SHRINKAGE_EDNWISE_UNIT_PERCENT")
    public Double getPhyAirShrinkageEdnwiseUnitPercent() {
        return phyAirShrinkageEdnwiseUnitPercent;
    }

    public void setPhyAirShrinkageEdnwiseUnitPercent(Double phyAirShrinkageEdnwiseUnitPercent) {
        this.phyAirShrinkageEdnwiseUnitPercent = phyAirShrinkageEdnwiseUnitPercent;
    }

    @Basic
    @Column(name = "PHY_AIR_SHRINKAGE_VOLUME_UNIT_PERCENT")
    public Double getPhyAirShrinkageVolumeUnitPercent() {
        return phyAirShrinkageVolumeUnitPercent;
    }

    public void setPhyAirShrinkageVolumeUnitPercent(Double phyAirShrinkageVolumeUnitPercent) {
        this.phyAirShrinkageVolumeUnitPercent = phyAirShrinkageVolumeUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_SHRINKAGE_CHORDWISE_UNIT_PERCENT")
    public Double getPhyWholeShrinkageChordwiseUnitPercent() {
        return phyWholeShrinkageChordwiseUnitPercent;
    }

    public void setPhyWholeShrinkageChordwiseUnitPercent(Double phyWholeShrinkageChordwiseUnitPercent) {
        this.phyWholeShrinkageChordwiseUnitPercent = phyWholeShrinkageChordwiseUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_SHRINKAGE_RADIAL_UNIT_PERCENT")
    public Double getPhyWholeShrinkageRadialUnitPercent() {
        return phyWholeShrinkageRadialUnitPercent;
    }

    public void setPhyWholeShrinkageRadialUnitPercent(Double phyWholeShrinkageRadialUnitPercent) {
        this.phyWholeShrinkageRadialUnitPercent = phyWholeShrinkageRadialUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_SHRINKAGE_EDNWISE_UNIT_PERCENT")
    public Double getPhyWholeShrinkageEdnwiseUnitPercent() {
        return phyWholeShrinkageEdnwiseUnitPercent;
    }

    public void setPhyWholeShrinkageEdnwiseUnitPercent(Double phyWholeShrinkageEdnwiseUnitPercent) {
        this.phyWholeShrinkageEdnwiseUnitPercent = phyWholeShrinkageEdnwiseUnitPercent;
    }

    @Basic
    @Column(name = "PHY_WHOLE_SHRINKAGE_VOLUME_UNIT_PERCENT")
    public Double getPhyWholeShrinkageVolumeUnitPercent() {
        return phyWholeShrinkageVolumeUnitPercent;
    }

    public void setPhyWholeShrinkageVolumeUnitPercent(Double phyWholeShrinkageVolumeUnitPercent) {
        this.phyWholeShrinkageVolumeUnitPercent = phyWholeShrinkageVolumeUnitPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPhysicsTable that = (TPhysicsTable) o;
        return Objects.equals(phyId, that.phyId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(phyRelativeUnitPercent, that.phyRelativeUnitPercent) &&
                Objects.equals(phyAbsoluteUnitPercent, that.phyAbsoluteUnitPercent) &&
                Objects.equals(phyGreenDensityUnitMidu, that.phyGreenDensityUnitMidu) &&
                Objects.equals(phyBasicDensityUnitMidu, that.phyBasicDensityUnitMidu) &&
                Objects.equals(phyAirDryDensityUnitMidu, that.phyAirDryDensityUnitMidu) &&
                Objects.equals(phyAbsoluteDryDensityUnitMidu, that.phyAbsoluteDryDensityUnitMidu) &&
                Objects.equals(phyAirDryingLineUnitPercent, that.phyAirDryingLineUnitPercent) &&
                Objects.equals(phyWholeDryLineUnitPercent, that.phyWholeDryLineUnitPercent) &&
                Objects.equals(phyAirDryVolumeUnitPercent, that.phyAirDryVolumeUnitPercent) &&
                Objects.equals(phyWholeDryVolumeUnitPercent, that.phyWholeDryVolumeUnitPercent) &&
                Objects.equals(phyAirShrinkageUnitPercent, that.phyAirShrinkageUnitPercent) &&
                Objects.equals(phyAirShrinkageChordwiseUnitPercent, that.phyAirShrinkageChordwiseUnitPercent) &&
                Objects.equals(phyAirShrinkageRadialUnitPercent, that.phyAirShrinkageRadialUnitPercent) &&
                Objects.equals(phyAirShrinkageEdnwiseUnitPercent, that.phyAirShrinkageEdnwiseUnitPercent) &&
                Objects.equals(phyAirShrinkageVolumeUnitPercent, that.phyAirShrinkageVolumeUnitPercent) &&
                Objects.equals(phyWholeShrinkageChordwiseUnitPercent, that.phyWholeShrinkageChordwiseUnitPercent) &&
                Objects.equals(phyWholeShrinkageRadialUnitPercent, that.phyWholeShrinkageRadialUnitPercent) &&
                Objects.equals(phyWholeShrinkageEdnwiseUnitPercent, that.phyWholeShrinkageEdnwiseUnitPercent) &&
                Objects.equals(phyWholeShrinkageVolumeUnitPercent, that.phyWholeShrinkageVolumeUnitPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phyId, specId, phyRelativeUnitPercent, phyAbsoluteUnitPercent, phyGreenDensityUnitMidu, phyBasicDensityUnitMidu, phyAirDryDensityUnitMidu, phyAbsoluteDryDensityUnitMidu, phyAirDryingLineUnitPercent, phyWholeDryLineUnitPercent, phyAirDryVolumeUnitPercent, phyWholeDryVolumeUnitPercent, phyAirShrinkageUnitPercent, phyAirShrinkageChordwiseUnitPercent, phyAirShrinkageRadialUnitPercent, phyAirShrinkageEdnwiseUnitPercent, phyAirShrinkageVolumeUnitPercent, phyWholeShrinkageChordwiseUnitPercent, phyWholeShrinkageRadialUnitPercent, phyWholeShrinkageEdnwiseUnitPercent, phyWholeShrinkageVolumeUnitPercent);
    }
}
