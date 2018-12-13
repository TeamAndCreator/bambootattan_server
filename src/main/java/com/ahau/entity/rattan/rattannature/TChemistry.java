package com.ahau.entity.rattan.rattannature;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（化学性质表）
 * Created by: 张理
 * 2018-11-3 16：04
 */
@Entity
public class TChemistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chemId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 综纤维素 */
    private Double chemHolocelluloseUnitPercent;

    /* 纤维素 */
    private Double chemCelluloseUnitPercent;

    /* 半纤维素 */
    private Double chemHemicelluloseUnitPercent;

    /* a纤维素 */
    private Double chemACelluloseUnitPercent;

    /* 酸不溶木质素 */
    private Double chemAcidInsolubleLigninUnitPercent;

    /* 苯醇抽提物 */
    private Double chemBenzeneAlcoholExtractionUnitPercent;

    /* 热水抽提物 */
    private Double chemHotWaterExtractionUnitPercent;

    /* 冷抽提物 */
    private Double chemColdWaterExtractionUnitPercent;

    /* 灰分 */
    private Double chemAshContentUnitPercent;

    public Long getChemId() {
        return chemId;
    }

    public void setChemId(Long chemId) {
        this.chemId = chemId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public Double getChemHolocelluloseUnitPercent() {
        return chemHolocelluloseUnitPercent;
    }

    public void setChemHolocelluloseUnitPercent(Double chemHolocelluloseUnitPercent) {
        this.chemHolocelluloseUnitPercent = chemHolocelluloseUnitPercent;
    }

    public Double getChemCelluloseUnitPercent() {
        return chemCelluloseUnitPercent;
    }

    public void setChemCelluloseUnitPercent(Double chemCelluloseUnitPercent) {
        this.chemCelluloseUnitPercent = chemCelluloseUnitPercent;
    }

    public Double getChemHemicelluloseUnitPercent() {
        return chemHemicelluloseUnitPercent;
    }

    public void setChemHemicelluloseUnitPercent(Double chemHemicelluloseUnitPercent) {
        this.chemHemicelluloseUnitPercent = chemHemicelluloseUnitPercent;
    }

    public Double getChemACelluloseUnitPercent() {
        return chemACelluloseUnitPercent;
    }

    public void setChemACelluloseUnitPercent(Double chemACelluloseUnitPercent) {
        this.chemACelluloseUnitPercent = chemACelluloseUnitPercent;
    }

    public Double getChemAcidInsolubleLigninUnitPercent() {
        return chemAcidInsolubleLigninUnitPercent;
    }

    public void setChemAcidInsolubleLigninUnitPercent(Double chemAcidInsolubleLigninUnitPercent) {
        this.chemAcidInsolubleLigninUnitPercent = chemAcidInsolubleLigninUnitPercent;
    }

    public Double getChemBenzeneAlcoholExtractionUnitPercent() {
        return chemBenzeneAlcoholExtractionUnitPercent;
    }

    public void setChemBenzeneAlcoholExtractionUnitPercent(Double chemBenzeneAlcoholExtractionUnitPercent) {
        this.chemBenzeneAlcoholExtractionUnitPercent = chemBenzeneAlcoholExtractionUnitPercent;
    }

    public Double getChemHotWaterExtractionUnitPercent() {
        return chemHotWaterExtractionUnitPercent;
    }

    public void setChemHotWaterExtractionUnitPercent(Double chemHotWaterExtractionUnitPercent) {
        this.chemHotWaterExtractionUnitPercent = chemHotWaterExtractionUnitPercent;
    }

    public Double getChemColdWaterExtractionUnitPercent() {
        return chemColdWaterExtractionUnitPercent;
    }

    public void setChemColdWaterExtractionUnitPercent(Double chemColdWaterExtractionUnitPercent) {
        this.chemColdWaterExtractionUnitPercent = chemColdWaterExtractionUnitPercent;
    }

    public Double getChemAshContentUnitPercent() {
        return chemAshContentUnitPercent;
    }

    public void setChemAshContentUnitPercent(Double chemAshContentUnitPercent) {
        this.chemAshContentUnitPercent = chemAshContentUnitPercent;
    }

    @Override
    public String toString() {
        return "TChemistry{" +
                "chemId=" + chemId +
                ", rattanSpec=" + rattanSpec +
                ", chemHolocelluloseUnitPercent=" + chemHolocelluloseUnitPercent +
                ", chemCelluloseUnitPercent=" + chemCelluloseUnitPercent +
                ", chemHemicelluloseUnitPercent=" + chemHemicelluloseUnitPercent +
                ", chemACelluloseUnitPercent=" + chemACelluloseUnitPercent +
                ", chemAcidInsolubleLigninUnitPercent=" + chemAcidInsolubleLigninUnitPercent +
                ", chemBenzeneAlcoholExtractionUnitPercent=" + chemBenzeneAlcoholExtractionUnitPercent +
                ", chemHotWaterExtractionUnitPercent=" + chemHotWaterExtractionUnitPercent +
                ", chemColdWaterExtractionUnitPercent=" + chemColdWaterExtractionUnitPercent +
                ", chemAshContentUnitPercent=" + chemAshContentUnitPercent +
                '}';
    }
}
