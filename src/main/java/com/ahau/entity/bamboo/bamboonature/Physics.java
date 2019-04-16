package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（物理性质表）
 * Created by: 张理
 * 2018-11-3 15：05
 */
@Entity
public class Physics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phyId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 相对含水率 */
    private Double phyRelativeUnitPercent;

    /* 绝对含水率 */
    private Double phyAbsoluteUnitPercent;

    /* 生材密度 */
    private Double phyGreenDensityUnitMidu;

    /* 基本密度 */
    private Double phyBasicDensityUnitMidu;

    /* 气干密度 */
    private Double phyAirDryDensityUnitMidu;

    /* 绝干密度 */
    private Double phyAbsoluteDryDensityUnitMidu;

    /* 湿材到气干（气干率） */
    private Double phyAirDryingLineUnitPercent;

    /* 湿材到全干（线干缩性） */
    private Double phyWholeDryLineUnitPercent;

    /* 湿材到气干（体积干缩性） */
    private Double phyAirDryVolumeUnitPercent;

    /* 湿材到全干（体积干缩性）% */
    private Double phyWholeDryVolumeUnitPercent;

    /* 气干缩率 */
    private Double phyAirShrinkageUnitPercent;

    /* 气干缩率（弦向） */
    private Double phyAirShrinkageChordwiseUnitPercent;

    /* 气干缩率（径向） */
    private Double phyAirShrinkageRadialUnitPercent;

    /* 气干缩率（纵向） */
    private Double phyAirShrinkageEdnwiseUnitPercent;

    /* 气干缩率（体积） */
    private Double phyAirShrinkageVolumeUnitPercent;

    /* 全干缩率（弦向） */
    private Double phyWholeShrinkageChordwiseUnitPercent;

    /* 全干缩率（径向） */
    private Double phyWholeShrinkageRadialUnitPercent;

    /* 全干缩率（纵向） */
    private Double phyWholeShrinkageEdnwiseUnitPercent;

    /* 全干缩率（体积） */
    private Double phyWholeShrinkageVolumeUnitPercent;

    public Long getPhyId() {
        return phyId;
    }

    public void setPhyId(Long phyId) {
        this.phyId = phyId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Double getPhyRelativeUnitPercent() {
        return phyRelativeUnitPercent;
    }

    public void setPhyRelativeUnitPercent(Double phyRelativeUnitPercent) {
        this.phyRelativeUnitPercent = phyRelativeUnitPercent;
    }

    public Double getPhyAbsoluteUnitPercent() {
        return phyAbsoluteUnitPercent;
    }

    public void setPhyAbsoluteUnitPercent(Double phyAbsoluteUnitPercent) {
        this.phyAbsoluteUnitPercent = phyAbsoluteUnitPercent;
    }

    public Double getPhyGreenDensityUnitMidu() {
        return phyGreenDensityUnitMidu;
    }

    public void setPhyGreenDensityUnitMidu(Double phyGreenDensityUnitMidu) {
        this.phyGreenDensityUnitMidu = phyGreenDensityUnitMidu;
    }

    public Double getPhyBasicDensityUnitMidu() {
        return phyBasicDensityUnitMidu;
    }

    public void setPhyBasicDensityUnitMidu(Double phyBasicDensityUnitMidu) {
        this.phyBasicDensityUnitMidu = phyBasicDensityUnitMidu;
    }

    public Double getPhyAirDryDensityUnitMidu() {
        return phyAirDryDensityUnitMidu;
    }

    public void setPhyAirDryDensityUnitMidu(Double phyAirDryDensityUnitMidu) {
        this.phyAirDryDensityUnitMidu = phyAirDryDensityUnitMidu;
    }

    public Double getPhyAbsoluteDryDensityUnitMidu() {
        return phyAbsoluteDryDensityUnitMidu;
    }

    public void setPhyAbsoluteDryDensityUnitMidu(Double phyAbsoluteDryDensityUnitMidu) {
        this.phyAbsoluteDryDensityUnitMidu = phyAbsoluteDryDensityUnitMidu;
    }

    public Double getPhyAirDryingLineUnitPercent() {
        return phyAirDryingLineUnitPercent;
    }

    public void setPhyAirDryingLineUnitPercent(Double phyAirDryingLineUnitPercent) {
        this.phyAirDryingLineUnitPercent = phyAirDryingLineUnitPercent;
    }

    public Double getPhyWholeDryLineUnitPercent() {
        return phyWholeDryLineUnitPercent;
    }

    public void setPhyWholeDryLineUnitPercent(Double phyWholeDryLineUnitPercent) {
        this.phyWholeDryLineUnitPercent = phyWholeDryLineUnitPercent;
    }

    public Double getPhyAirDryVolumeUnitPercent() {
        return phyAirDryVolumeUnitPercent;
    }

    public void setPhyAirDryVolumeUnitPercent(Double phyAirDryVolumeUnitPercent) {
        this.phyAirDryVolumeUnitPercent = phyAirDryVolumeUnitPercent;
    }

    public Double getPhyWholeDryVolumeUnitPercent() {
        return phyWholeDryVolumeUnitPercent;
    }

    public void setPhyWholeDryVolumeUnitPercent(Double phyWholeDryVolumeUnitPercent) {
        this.phyWholeDryVolumeUnitPercent = phyWholeDryVolumeUnitPercent;
    }

    public Double getPhyAirShrinkageUnitPercent() {
        return phyAirShrinkageUnitPercent;
    }

    public void setPhyAirShrinkageUnitPercent(Double phyAirShrinkageUnitPercent) {
        this.phyAirShrinkageUnitPercent = phyAirShrinkageUnitPercent;
    }

    public Double getPhyAirShrinkageChordwiseUnitPercent() {
        return phyAirShrinkageChordwiseUnitPercent;
    }

    public void setPhyAirShrinkageChordwiseUnitPercent(Double phyAirShrinkageChordwiseUnitPercent) {
        this.phyAirShrinkageChordwiseUnitPercent = phyAirShrinkageChordwiseUnitPercent;
    }

    public Double getPhyAirShrinkageRadialUnitPercent() {
        return phyAirShrinkageRadialUnitPercent;
    }

    public void setPhyAirShrinkageRadialUnitPercent(Double phyAirShrinkageRadialUnitPercent) {
        this.phyAirShrinkageRadialUnitPercent = phyAirShrinkageRadialUnitPercent;
    }

    public Double getPhyAirShrinkageEdnwiseUnitPercent() {
        return phyAirShrinkageEdnwiseUnitPercent;
    }

    public void setPhyAirShrinkageEdnwiseUnitPercent(Double phyAirShrinkageEdnwiseUnitPercent) {
        this.phyAirShrinkageEdnwiseUnitPercent = phyAirShrinkageEdnwiseUnitPercent;
    }

    public Double getPhyAirShrinkageVolumeUnitPercent() {
        return phyAirShrinkageVolumeUnitPercent;
    }

    public void setPhyAirShrinkageVolumeUnitPercent(Double phyAirShrinkageVolumeUnitPercent) {
        this.phyAirShrinkageVolumeUnitPercent = phyAirShrinkageVolumeUnitPercent;
    }

    public Double getPhyWholeShrinkageChordwiseUnitPercent() {
        return phyWholeShrinkageChordwiseUnitPercent;
    }

    public void setPhyWholeShrinkageChordwiseUnitPercent(Double phyWholeShrinkageChordwiseUnitPercent) {
        this.phyWholeShrinkageChordwiseUnitPercent = phyWholeShrinkageChordwiseUnitPercent;
    }

    public Double getPhyWholeShrinkageRadialUnitPercent() {
        return phyWholeShrinkageRadialUnitPercent;
    }

    public void setPhyWholeShrinkageRadialUnitPercent(Double phyWholeShrinkageRadialUnitPercent) {
        this.phyWholeShrinkageRadialUnitPercent = phyWholeShrinkageRadialUnitPercent;
    }

    public Double getPhyWholeShrinkageEdnwiseUnitPercent() {
        return phyWholeShrinkageEdnwiseUnitPercent;
    }

    public void setPhyWholeShrinkageEdnwiseUnitPercent(Double phyWholeShrinkageEdnwiseUnitPercent) {
        this.phyWholeShrinkageEdnwiseUnitPercent = phyWholeShrinkageEdnwiseUnitPercent;
    }

    public Double getPhyWholeShrinkageVolumeUnitPercent() {
        return phyWholeShrinkageVolumeUnitPercent;
    }

    public void setPhyWholeShrinkageVolumeUnitPercent(Double phyWholeShrinkageVolumeUnitPercent) {
        this.phyWholeShrinkageVolumeUnitPercent = phyWholeShrinkageVolumeUnitPercent;
    }

    @Override
    public String toString() {
        return "Physics{" +
                "phyId=" + phyId +
                ", spec=" + spec +
                ", phyRelativeUnitPercent=" + phyRelativeUnitPercent +
                ", phyAbsoluteUnitPercent=" + phyAbsoluteUnitPercent +
                ", phyGreenDensityUnitMidu=" + phyGreenDensityUnitMidu +
                ", phyBasicDensityUnitMidu=" + phyBasicDensityUnitMidu +
                ", phyAirDryDensityUnitMidu=" + phyAirDryDensityUnitMidu +
                ", phyAbsoluteDryDensityUnitMidu=" + phyAbsoluteDryDensityUnitMidu +
                ", phyAirDryingLineUnitPercent=" + phyAirDryingLineUnitPercent +
                ", phyWholeDryLineUnitPercent=" + phyWholeDryLineUnitPercent +
                ", phyAirDryVolumeUnitPercent=" + phyAirDryVolumeUnitPercent +
                ", phyWholeDryVolumeUnitPercent=" + phyWholeDryVolumeUnitPercent +
                ", phyAirShrinkageUnitPercent=" + phyAirShrinkageUnitPercent +
                ", phyAirShrinkageChordwiseUnitPercent=" + phyAirShrinkageChordwiseUnitPercent +
                ", phyAirShrinkageRadialUnitPercent=" + phyAirShrinkageRadialUnitPercent +
                ", phyAirShrinkageEdnwiseUnitPercent=" + phyAirShrinkageEdnwiseUnitPercent +
                ", phyAirShrinkageVolumeUnitPercent=" + phyAirShrinkageVolumeUnitPercent +
                ", phyWholeShrinkageChordwiseUnitPercent=" + phyWholeShrinkageChordwiseUnitPercent +
                ", phyWholeShrinkageRadialUnitPercent=" + phyWholeShrinkageRadialUnitPercent +
                ", phyWholeShrinkageEdnwiseUnitPercent=" + phyWholeShrinkageEdnwiseUnitPercent +
                ", phyWholeShrinkageVolumeUnitPercent=" + phyWholeShrinkageVolumeUnitPercent +
                '}';
    }
}
