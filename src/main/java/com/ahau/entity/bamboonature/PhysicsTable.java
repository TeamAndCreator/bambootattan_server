package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（物理性质表）
 * created by: 张理
 * 2018-10-26 21：00
 */
@Entity
public class PhysicsTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 相对含水率 */
    private Double phyRelativeUnitPercent;
    /* 相对含水率（查询上限） */
    private Double beginPhyRelativeUnitPercent;
    /* 相对含水率（查询下限） */
    private Double endPhyRelativeUnitPercent;
    /* 绝对含水率 */
    private Double phyAbsoluteUnitPercent;
    /* 绝对含水率（查询上限） */
    private Double beginPhyAbsoluteUnitPercent;
    /* 绝对含水率（查询下限） */
    private Double endPhyAbsoluteUnitPercent;
    /* 生材密度 */
    private Double phyGreenDensityUnitMidu;
    /* 生材密度（查询上限） */
    private Double beginPhyGreenDensityUnitMidu;
    /* 生材密度（查询下限） */
    private Double endPhyGreenDensityUnitMidu;
    /* 基本密度 */
    private Double phyBasicDensityUnitMidu;
    /* 基本密度（查询上限） */
    private Double beginPhyBasicDensityUnitMidu;
    /* 基本密度（查询下限） */
    private Double endPhyBasicDensityUnitMidu;
    /* 气干密度 */
    private Double phyAirDryDensityUnitMidu;
    /* 气干密度（查询上限） */
    private Double beginPhyAirDryDensityUnitMidu;
    /* 气干密度（查询下限） */
    private Double endPhyAirDryDensityUnitMidu;
    /* 绝干密度 */
    private Double phyAbsoluteDryDensityUnitMidu;
    /* 绝干密度（查询上限） */
    private Double beginPhyAbsoluteDryDensityUnitMidu;
    /* 绝干密度（查询下限） */
    private Double endPhyAbsoluteDryDensityUnitMidu;
    /* 湿材到气干（气干率） */
    private Double phyAirDryingLineUnitPercent;
    /* 湿材到气干（气干率）（查询上限） */
    private Double beginPhyAirDryingLineUnitPercent;
    /* 湿材到气干（气干率）（查询下限） */
    private Double endPhyAirDryingLineUnitPercent;
    /* 湿材到全干（线干缩性） */
    private Double phyWholeDryLineUnitPercent;
    /* 湿材到全干（线干缩性）（查询上限） */
    private Double beginPhyWholeDryLineUnitPercent;
    /* 湿材到全干（线干缩性）（查询下限） */
    private Double endPhyWholeDryLineUnitPercent;
    /* 湿材到气干（体积干缩性） */
    private Double phyAirDryVolumeUnitPercent;
    /* 湿材到气干（体积干缩性）（查询上限） */
    private Double beginPhyAirDryVolumeUnitPercent;
    /* 湿材到气干（体积干缩性）（查询下限） */
    private Double endPhyAirDryVolumeUnitPercent;
    /* 湿材到全干（体积干缩性）% */
    private Double phyWholeDryVolumeUnitPercent;
    /* 湿材到全干（体积干缩性）%（查询上限） */
    private Double beginPhyWholeDryVolumeUnitPercent;
    /* 湿材到全干（体积干缩性）%（查询下限） */
    private Double endPhyWholeDryVolumeUnitPercent;
    /* 气干缩率 */
    private Double phyAirShrinkageUnitPercent;
    /* 气干缩率（查询上限） */
    private Double beginPhyAirShrinkageUnitPercent;
    /* 气干缩率（查询下限） */
    private Double endPhyAirShrinkageUnitPercent;
    /* 气干缩率（弦向） */
    private Double phyAirShrinkageChordwiseUnitPercent;
    /* 气干缩率（弦向）（查询上限） */
    private Double beginPhyAirShrinkageChordwiseUnitPercent;
    /* 气干缩率（弦向）（查询下限） */
    private Double endPhyAirShrinkageChordwiseUnitPercent;
    /* 气干缩率（径向） */
    private Double phyAirShrinkageRadialUnitPercent;
    /* 气干缩率（径向）（查询上限） */
    private Double beginPhyAirShrinkageRadialUnitPercent;
    /* 气干缩率（径向）（查询下限） */
    private Double endPhyAirShrinkageRadialUnitPercent;
    /* 气干缩率（纵向） */
    private Double phyAirShrinkageEdnwiseUnitPercent;
    /* 气干缩率（纵向）（查询上限） */
    private Double beginPhyAirShrinkageEdnwiseUnitPercent;
    /* 气干缩率（纵向）（查询下限） */
    private Double endPhyAirShrinkageEdnwiseUnitPercent;
    /* 气干缩率（体积） */
    private Double phyAirShrinkageVolumeUnitPercent;
    /* 气干缩率（体积）（查询上限） */
    private Double beginPhyAirShrinkageVolumeUnitPercent;
    /* 气干缩率（体积）（查询下限） */
    private Double endPhyAirShrinkageVolumeUnitPercent;
    /* 全干缩率（弦向） */
    private Double phyWholeShrinkageChordwiseUnitPercent;
    /* 全干缩率（弦向）（查询上限） */
    private Double beginPhyWholeShrinkageChordwiseUnitPercent;
    /* 全干缩率（弦向）（查询下限） */
    private Double endPhyWholeShrinkageChordwiseUnitPercent;
    /* 全干缩率（径向） */
    private Double phyWholeShrinkageRadialUnitPercent;
    /* 全干缩率（径向）（查询上限） */
    private Double beginPhyWholeShrinkageRadialUnitPercent;
    /* 全干缩率（径向）（查询下限） */
    private Double endPhyWholeShrinkageRadialUnitPercent;
    /* 全干缩率（纵向） */
    private Double phyWholeShrinkageEdnwiseUnitPercent;
    /* 全干缩率（纵向）（查询上限） */
    private Double beginPhyWholeShrinkageEdnwiseUnitPercent;
    /* 全干缩率（纵向）（查询下限） */
    private Double endPhyWholeShrinkageEdnwiseUnitPercent;
    /* 全干缩率（体积） */
    private Double phyWholeShrinkageVolumeUnitPercent;
    /* 全干缩率（体积）（查询上限） */
    private Double beginPhyWholeShrinkageVolumeUnitPercent;
    /* 全干缩率（体积）（查询下限） */
    private Double endPhyWholeShrinkageVolumeUnitPercent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecIdLike() {
        return specIdLike;
    }

    public void setSpecIdLike(String specIdLike) {
        this.specIdLike = specIdLike;
    }

    public Double getPhyRelativeUnitPercent() {
        return phyRelativeUnitPercent;
    }

    public void setPhyRelativeUnitPercent(Double phyRelativeUnitPercent) {
        this.phyRelativeUnitPercent = phyRelativeUnitPercent;
    }

    public Double getBeginPhyRelativeUnitPercent() {
        return beginPhyRelativeUnitPercent;
    }

    public void setBeginPhyRelativeUnitPercent(Double beginPhyRelativeUnitPercent) {
        this.beginPhyRelativeUnitPercent = beginPhyRelativeUnitPercent;
    }

    public Double getEndPhyRelativeUnitPercent() {
        return endPhyRelativeUnitPercent;
    }

    public void setEndPhyRelativeUnitPercent(Double endPhyRelativeUnitPercent) {
        this.endPhyRelativeUnitPercent = endPhyRelativeUnitPercent;
    }

    public Double getPhyAbsoluteUnitPercent() {
        return phyAbsoluteUnitPercent;
    }

    public void setPhyAbsoluteUnitPercent(Double phyAbsoluteUnitPercent) {
        this.phyAbsoluteUnitPercent = phyAbsoluteUnitPercent;
    }

    public Double getBeginPhyAbsoluteUnitPercent() {
        return beginPhyAbsoluteUnitPercent;
    }

    public void setBeginPhyAbsoluteUnitPercent(Double beginPhyAbsoluteUnitPercent) {
        this.beginPhyAbsoluteUnitPercent = beginPhyAbsoluteUnitPercent;
    }

    public Double getEndPhyAbsoluteUnitPercent() {
        return endPhyAbsoluteUnitPercent;
    }

    public void setEndPhyAbsoluteUnitPercent(Double endPhyAbsoluteUnitPercent) {
        this.endPhyAbsoluteUnitPercent = endPhyAbsoluteUnitPercent;
    }

    public Double getPhyGreenDensityUnitMidu() {
        return phyGreenDensityUnitMidu;
    }

    public void setPhyGreenDensityUnitMidu(Double phyGreenDensityUnitMidu) {
        this.phyGreenDensityUnitMidu = phyGreenDensityUnitMidu;
    }

    public Double getBeginPhyGreenDensityUnitMidu() {
        return beginPhyGreenDensityUnitMidu;
    }

    public void setBeginPhyGreenDensityUnitMidu(Double beginPhyGreenDensityUnitMidu) {
        this.beginPhyGreenDensityUnitMidu = beginPhyGreenDensityUnitMidu;
    }

    public Double getEndPhyGreenDensityUnitMidu() {
        return endPhyGreenDensityUnitMidu;
    }

    public void setEndPhyGreenDensityUnitMidu(Double endPhyGreenDensityUnitMidu) {
        this.endPhyGreenDensityUnitMidu = endPhyGreenDensityUnitMidu;
    }

    public Double getPhyBasicDensityUnitMidu() {
        return phyBasicDensityUnitMidu;
    }

    public void setPhyBasicDensityUnitMidu(Double phyBasicDensityUnitMidu) {
        this.phyBasicDensityUnitMidu = phyBasicDensityUnitMidu;
    }

    public Double getBeginPhyBasicDensityUnitMidu() {
        return beginPhyBasicDensityUnitMidu;
    }

    public void setBeginPhyBasicDensityUnitMidu(Double beginPhyBasicDensityUnitMidu) {
        this.beginPhyBasicDensityUnitMidu = beginPhyBasicDensityUnitMidu;
    }

    public Double getEndPhyBasicDensityUnitMidu() {
        return endPhyBasicDensityUnitMidu;
    }

    public void setEndPhyBasicDensityUnitMidu(Double endPhyBasicDensityUnitMidu) {
        this.endPhyBasicDensityUnitMidu = endPhyBasicDensityUnitMidu;
    }

    public Double getPhyAirDryDensityUnitMidu() {
        return phyAirDryDensityUnitMidu;
    }

    public void setPhyAirDryDensityUnitMidu(Double phyAirDryDensityUnitMidu) {
        this.phyAirDryDensityUnitMidu = phyAirDryDensityUnitMidu;
    }

    public Double getBeginPhyAirDryDensityUnitMidu() {
        return beginPhyAirDryDensityUnitMidu;
    }

    public void setBeginPhyAirDryDensityUnitMidu(Double beginPhyAirDryDensityUnitMidu) {
        this.beginPhyAirDryDensityUnitMidu = beginPhyAirDryDensityUnitMidu;
    }

    public Double getEndPhyAirDryDensityUnitMidu() {
        return endPhyAirDryDensityUnitMidu;
    }

    public void setEndPhyAirDryDensityUnitMidu(Double endPhyAirDryDensityUnitMidu) {
        this.endPhyAirDryDensityUnitMidu = endPhyAirDryDensityUnitMidu;
    }

    public Double getPhyAbsoluteDryDensityUnitMidu() {
        return phyAbsoluteDryDensityUnitMidu;
    }

    public void setPhyAbsoluteDryDensityUnitMidu(Double phyAbsoluteDryDensityUnitMidu) {
        this.phyAbsoluteDryDensityUnitMidu = phyAbsoluteDryDensityUnitMidu;
    }

    public Double getBeginPhyAbsoluteDryDensityUnitMidu() {
        return beginPhyAbsoluteDryDensityUnitMidu;
    }

    public void setBeginPhyAbsoluteDryDensityUnitMidu(Double beginPhyAbsoluteDryDensityUnitMidu) {
        this.beginPhyAbsoluteDryDensityUnitMidu = beginPhyAbsoluteDryDensityUnitMidu;
    }

    public Double getEndPhyAbsoluteDryDensityUnitMidu() {
        return endPhyAbsoluteDryDensityUnitMidu;
    }

    public void setEndPhyAbsoluteDryDensityUnitMidu(Double endPhyAbsoluteDryDensityUnitMidu) {
        this.endPhyAbsoluteDryDensityUnitMidu = endPhyAbsoluteDryDensityUnitMidu;
    }

    public Double getPhyAirDryingLineUnitPercent() {
        return phyAirDryingLineUnitPercent;
    }

    public void setPhyAirDryingLineUnitPercent(Double phyAirDryingLineUnitPercent) {
        this.phyAirDryingLineUnitPercent = phyAirDryingLineUnitPercent;
    }

    public Double getBeginPhyAirDryingLineUnitPercent() {
        return beginPhyAirDryingLineUnitPercent;
    }

    public void setBeginPhyAirDryingLineUnitPercent(Double beginPhyAirDryingLineUnitPercent) {
        this.beginPhyAirDryingLineUnitPercent = beginPhyAirDryingLineUnitPercent;
    }

    public Double getEndPhyAirDryingLineUnitPercent() {
        return endPhyAirDryingLineUnitPercent;
    }

    public void setEndPhyAirDryingLineUnitPercent(Double endPhyAirDryingLineUnitPercent) {
        this.endPhyAirDryingLineUnitPercent = endPhyAirDryingLineUnitPercent;
    }

    public Double getPhyWholeDryLineUnitPercent() {
        return phyWholeDryLineUnitPercent;
    }

    public void setPhyWholeDryLineUnitPercent(Double phyWholeDryLineUnitPercent) {
        this.phyWholeDryLineUnitPercent = phyWholeDryLineUnitPercent;
    }

    public Double getBeginPhyWholeDryLineUnitPercent() {
        return beginPhyWholeDryLineUnitPercent;
    }

    public void setBeginPhyWholeDryLineUnitPercent(Double beginPhyWholeDryLineUnitPercent) {
        this.beginPhyWholeDryLineUnitPercent = beginPhyWholeDryLineUnitPercent;
    }

    public Double getEndPhyWholeDryLineUnitPercent() {
        return endPhyWholeDryLineUnitPercent;
    }

    public void setEndPhyWholeDryLineUnitPercent(Double endPhyWholeDryLineUnitPercent) {
        this.endPhyWholeDryLineUnitPercent = endPhyWholeDryLineUnitPercent;
    }

    public Double getPhyAirDryVolumeUnitPercent() {
        return phyAirDryVolumeUnitPercent;
    }

    public void setPhyAirDryVolumeUnitPercent(Double phyAirDryVolumeUnitPercent) {
        this.phyAirDryVolumeUnitPercent = phyAirDryVolumeUnitPercent;
    }

    public Double getBeginPhyAirDryVolumeUnitPercent() {
        return beginPhyAirDryVolumeUnitPercent;
    }

    public void setBeginPhyAirDryVolumeUnitPercent(Double beginPhyAirDryVolumeUnitPercent) {
        this.beginPhyAirDryVolumeUnitPercent = beginPhyAirDryVolumeUnitPercent;
    }

    public Double getEndPhyAirDryVolumeUnitPercent() {
        return endPhyAirDryVolumeUnitPercent;
    }

    public void setEndPhyAirDryVolumeUnitPercent(Double endPhyAirDryVolumeUnitPercent) {
        this.endPhyAirDryVolumeUnitPercent = endPhyAirDryVolumeUnitPercent;
    }

    public Double getPhyWholeDryVolumeUnitPercent() {
        return phyWholeDryVolumeUnitPercent;
    }

    public void setPhyWholeDryVolumeUnitPercent(Double phyWholeDryVolumeUnitPercent) {
        this.phyWholeDryVolumeUnitPercent = phyWholeDryVolumeUnitPercent;
    }

    public Double getBeginPhyWholeDryVolumeUnitPercent() {
        return beginPhyWholeDryVolumeUnitPercent;
    }

    public void setBeginPhyWholeDryVolumeUnitPercent(Double beginPhyWholeDryVolumeUnitPercent) {
        this.beginPhyWholeDryVolumeUnitPercent = beginPhyWholeDryVolumeUnitPercent;
    }

    public Double getEndPhyWholeDryVolumeUnitPercent() {
        return endPhyWholeDryVolumeUnitPercent;
    }

    public void setEndPhyWholeDryVolumeUnitPercent(Double endPhyWholeDryVolumeUnitPercent) {
        this.endPhyWholeDryVolumeUnitPercent = endPhyWholeDryVolumeUnitPercent;
    }

    public Double getPhyAirShrinkageUnitPercent() {
        return phyAirShrinkageUnitPercent;
    }

    public void setPhyAirShrinkageUnitPercent(Double phyAirShrinkageUnitPercent) {
        this.phyAirShrinkageUnitPercent = phyAirShrinkageUnitPercent;
    }

    public Double getBeginPhyAirShrinkageUnitPercent() {
        return beginPhyAirShrinkageUnitPercent;
    }

    public void setBeginPhyAirShrinkageUnitPercent(Double beginPhyAirShrinkageUnitPercent) {
        this.beginPhyAirShrinkageUnitPercent = beginPhyAirShrinkageUnitPercent;
    }

    public Double getEndPhyAirShrinkageUnitPercent() {
        return endPhyAirShrinkageUnitPercent;
    }

    public void setEndPhyAirShrinkageUnitPercent(Double endPhyAirShrinkageUnitPercent) {
        this.endPhyAirShrinkageUnitPercent = endPhyAirShrinkageUnitPercent;
    }

    public Double getPhyAirShrinkageChordwiseUnitPercent() {
        return phyAirShrinkageChordwiseUnitPercent;
    }

    public void setPhyAirShrinkageChordwiseUnitPercent(Double phyAirShrinkageChordwiseUnitPercent) {
        this.phyAirShrinkageChordwiseUnitPercent = phyAirShrinkageChordwiseUnitPercent;
    }

    public Double getBeginPhyAirShrinkageChordwiseUnitPercent() {
        return beginPhyAirShrinkageChordwiseUnitPercent;
    }

    public void setBeginPhyAirShrinkageChordwiseUnitPercent(Double beginPhyAirShrinkageChordwiseUnitPercent) {
        this.beginPhyAirShrinkageChordwiseUnitPercent = beginPhyAirShrinkageChordwiseUnitPercent;
    }

    public Double getEndPhyAirShrinkageChordwiseUnitPercent() {
        return endPhyAirShrinkageChordwiseUnitPercent;
    }

    public void setEndPhyAirShrinkageChordwiseUnitPercent(Double endPhyAirShrinkageChordwiseUnitPercent) {
        this.endPhyAirShrinkageChordwiseUnitPercent = endPhyAirShrinkageChordwiseUnitPercent;
    }

    public Double getPhyAirShrinkageRadialUnitPercent() {
        return phyAirShrinkageRadialUnitPercent;
    }

    public void setPhyAirShrinkageRadialUnitPercent(Double phyAirShrinkageRadialUnitPercent) {
        this.phyAirShrinkageRadialUnitPercent = phyAirShrinkageRadialUnitPercent;
    }

    public Double getBeginPhyAirShrinkageRadialUnitPercent() {
        return beginPhyAirShrinkageRadialUnitPercent;
    }

    public void setBeginPhyAirShrinkageRadialUnitPercent(Double beginPhyAirShrinkageRadialUnitPercent) {
        this.beginPhyAirShrinkageRadialUnitPercent = beginPhyAirShrinkageRadialUnitPercent;
    }

    public Double getEndPhyAirShrinkageRadialUnitPercent() {
        return endPhyAirShrinkageRadialUnitPercent;
    }

    public void setEndPhyAirShrinkageRadialUnitPercent(Double endPhyAirShrinkageRadialUnitPercent) {
        this.endPhyAirShrinkageRadialUnitPercent = endPhyAirShrinkageRadialUnitPercent;
    }

    public Double getPhyAirShrinkageEdnwiseUnitPercent() {
        return phyAirShrinkageEdnwiseUnitPercent;
    }

    public void setPhyAirShrinkageEdnwiseUnitPercent(Double phyAirShrinkageEdnwiseUnitPercent) {
        this.phyAirShrinkageEdnwiseUnitPercent = phyAirShrinkageEdnwiseUnitPercent;
    }

    public Double getBeginPhyAirShrinkageEdnwiseUnitPercent() {
        return beginPhyAirShrinkageEdnwiseUnitPercent;
    }

    public void setBeginPhyAirShrinkageEdnwiseUnitPercent(Double beginPhyAirShrinkageEdnwiseUnitPercent) {
        this.beginPhyAirShrinkageEdnwiseUnitPercent = beginPhyAirShrinkageEdnwiseUnitPercent;
    }

    public Double getEndPhyAirShrinkageEdnwiseUnitPercent() {
        return endPhyAirShrinkageEdnwiseUnitPercent;
    }

    public void setEndPhyAirShrinkageEdnwiseUnitPercent(Double endPhyAirShrinkageEdnwiseUnitPercent) {
        this.endPhyAirShrinkageEdnwiseUnitPercent = endPhyAirShrinkageEdnwiseUnitPercent;
    }

    public Double getPhyAirShrinkageVolumeUnitPercent() {
        return phyAirShrinkageVolumeUnitPercent;
    }

    public void setPhyAirShrinkageVolumeUnitPercent(Double phyAirShrinkageVolumeUnitPercent) {
        this.phyAirShrinkageVolumeUnitPercent = phyAirShrinkageVolumeUnitPercent;
    }

    public Double getBeginPhyAirShrinkageVolumeUnitPercent() {
        return beginPhyAirShrinkageVolumeUnitPercent;
    }

    public void setBeginPhyAirShrinkageVolumeUnitPercent(Double beginPhyAirShrinkageVolumeUnitPercent) {
        this.beginPhyAirShrinkageVolumeUnitPercent = beginPhyAirShrinkageVolumeUnitPercent;
    }

    public Double getEndPhyAirShrinkageVolumeUnitPercent() {
        return endPhyAirShrinkageVolumeUnitPercent;
    }

    public void setEndPhyAirShrinkageVolumeUnitPercent(Double endPhyAirShrinkageVolumeUnitPercent) {
        this.endPhyAirShrinkageVolumeUnitPercent = endPhyAirShrinkageVolumeUnitPercent;
    }

    public Double getPhyWholeShrinkageChordwiseUnitPercent() {
        return phyWholeShrinkageChordwiseUnitPercent;
    }

    public void setPhyWholeShrinkageChordwiseUnitPercent(Double phyWholeShrinkageChordwiseUnitPercent) {
        this.phyWholeShrinkageChordwiseUnitPercent = phyWholeShrinkageChordwiseUnitPercent;
    }

    public Double getBeginPhyWholeShrinkageChordwiseUnitPercent() {
        return beginPhyWholeShrinkageChordwiseUnitPercent;
    }

    public void setBeginPhyWholeShrinkageChordwiseUnitPercent(Double beginPhyWholeShrinkageChordwiseUnitPercent) {
        this.beginPhyWholeShrinkageChordwiseUnitPercent = beginPhyWholeShrinkageChordwiseUnitPercent;
    }

    public Double getEndPhyWholeShrinkageChordwiseUnitPercent() {
        return endPhyWholeShrinkageChordwiseUnitPercent;
    }

    public void setEndPhyWholeShrinkageChordwiseUnitPercent(Double endPhyWholeShrinkageChordwiseUnitPercent) {
        this.endPhyWholeShrinkageChordwiseUnitPercent = endPhyWholeShrinkageChordwiseUnitPercent;
    }

    public Double getPhyWholeShrinkageRadialUnitPercent() {
        return phyWholeShrinkageRadialUnitPercent;
    }

    public void setPhyWholeShrinkageRadialUnitPercent(Double phyWholeShrinkageRadialUnitPercent) {
        this.phyWholeShrinkageRadialUnitPercent = phyWholeShrinkageRadialUnitPercent;
    }

    public Double getBeginPhyWholeShrinkageRadialUnitPercent() {
        return beginPhyWholeShrinkageRadialUnitPercent;
    }

    public void setBeginPhyWholeShrinkageRadialUnitPercent(Double beginPhyWholeShrinkageRadialUnitPercent) {
        this.beginPhyWholeShrinkageRadialUnitPercent = beginPhyWholeShrinkageRadialUnitPercent;
    }

    public Double getEndPhyWholeShrinkageRadialUnitPercent() {
        return endPhyWholeShrinkageRadialUnitPercent;
    }

    public void setEndPhyWholeShrinkageRadialUnitPercent(Double endPhyWholeShrinkageRadialUnitPercent) {
        this.endPhyWholeShrinkageRadialUnitPercent = endPhyWholeShrinkageRadialUnitPercent;
    }

    public Double getPhyWholeShrinkageEdnwiseUnitPercent() {
        return phyWholeShrinkageEdnwiseUnitPercent;
    }

    public void setPhyWholeShrinkageEdnwiseUnitPercent(Double phyWholeShrinkageEdnwiseUnitPercent) {
        this.phyWholeShrinkageEdnwiseUnitPercent = phyWholeShrinkageEdnwiseUnitPercent;
    }

    public Double getBeginPhyWholeShrinkageEdnwiseUnitPercent() {
        return beginPhyWholeShrinkageEdnwiseUnitPercent;
    }

    public void setBeginPhyWholeShrinkageEdnwiseUnitPercent(Double beginPhyWholeShrinkageEdnwiseUnitPercent) {
        this.beginPhyWholeShrinkageEdnwiseUnitPercent = beginPhyWholeShrinkageEdnwiseUnitPercent;
    }

    public Double getEndPhyWholeShrinkageEdnwiseUnitPercent() {
        return endPhyWholeShrinkageEdnwiseUnitPercent;
    }

    public void setEndPhyWholeShrinkageEdnwiseUnitPercent(Double endPhyWholeShrinkageEdnwiseUnitPercent) {
        this.endPhyWholeShrinkageEdnwiseUnitPercent = endPhyWholeShrinkageEdnwiseUnitPercent;
    }

    public Double getPhyWholeShrinkageVolumeUnitPercent() {
        return phyWholeShrinkageVolumeUnitPercent;
    }

    public void setPhyWholeShrinkageVolumeUnitPercent(Double phyWholeShrinkageVolumeUnitPercent) {
        this.phyWholeShrinkageVolumeUnitPercent = phyWholeShrinkageVolumeUnitPercent;
    }

    public Double getBeginPhyWholeShrinkageVolumeUnitPercent() {
        return beginPhyWholeShrinkageVolumeUnitPercent;
    }

    public void setBeginPhyWholeShrinkageVolumeUnitPercent(Double beginPhyWholeShrinkageVolumeUnitPercent) {
        this.beginPhyWholeShrinkageVolumeUnitPercent = beginPhyWholeShrinkageVolumeUnitPercent;
    }

    public Double getEndPhyWholeShrinkageVolumeUnitPercent() {
        return endPhyWholeShrinkageVolumeUnitPercent;
    }

    public void setEndPhyWholeShrinkageVolumeUnitPercent(Double endPhyWholeShrinkageVolumeUnitPercent) {
        this.endPhyWholeShrinkageVolumeUnitPercent = endPhyWholeShrinkageVolumeUnitPercent;
    }
}
