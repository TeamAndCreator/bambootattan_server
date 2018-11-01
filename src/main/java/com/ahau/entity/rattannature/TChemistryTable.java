package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（化学性质表）
 * Created by: 张理
 * 2018-11-1 16：15
 */
@Entity
@Table(name = "aau_tchemistry_table", schema = "bambootattan", catalog = "")
public class TChemistryTable {
    private String chemId;
    private String specId;
    private Double chemHolocelluloseUnitPercent;
    private Double chemCelluloseUnitPercent;
    private Double chemHemicelluloseUnitPercent;
    private Double chemACelluloseUnitPercent;
    private Double chemAcidInsolubleLigninUnitPercent;
    private Double chemBenzeneAlcoholExtractionUnitPercent;
    private Double chemHotWaterExtractionUnitPercent;
    private Double chemColdWaterExtractionUnitPercent;
    private Double chemAshContentUnitPercent;

    @Id
    @Column(name = "CHEM_ID")
    public String getChemId() {
        return chemId;
    }

    public void setChemId(String chemId) {
        this.chemId = chemId;
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
    @Column(name = "CHEM_HOLOCELLULOSE_UNIT_PERCENT")
    public Double getChemHolocelluloseUnitPercent() {
        return chemHolocelluloseUnitPercent;
    }

    public void setChemHolocelluloseUnitPercent(Double chemHolocelluloseUnitPercent) {
        this.chemHolocelluloseUnitPercent = chemHolocelluloseUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_CELLULOSE_UNIT_PERCENT")
    public Double getChemCelluloseUnitPercent() {
        return chemCelluloseUnitPercent;
    }

    public void setChemCelluloseUnitPercent(Double chemCelluloseUnitPercent) {
        this.chemCelluloseUnitPercent = chemCelluloseUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_HEMICELLULOSE_UNIT_PERCENT")
    public Double getChemHemicelluloseUnitPercent() {
        return chemHemicelluloseUnitPercent;
    }

    public void setChemHemicelluloseUnitPercent(Double chemHemicelluloseUnitPercent) {
        this.chemHemicelluloseUnitPercent = chemHemicelluloseUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_A_CELLULOSE_UNIT_PERCENT")
    public Double getChemACelluloseUnitPercent() {
        return chemACelluloseUnitPercent;
    }

    public void setChemACelluloseUnitPercent(Double chemACelluloseUnitPercent) {
        this.chemACelluloseUnitPercent = chemACelluloseUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_ACID_INSOLUBLE_LIGNIN_UNIT_PERCENT")
    public Double getChemAcidInsolubleLigninUnitPercent() {
        return chemAcidInsolubleLigninUnitPercent;
    }

    public void setChemAcidInsolubleLigninUnitPercent(Double chemAcidInsolubleLigninUnitPercent) {
        this.chemAcidInsolubleLigninUnitPercent = chemAcidInsolubleLigninUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_BENZENE_ALCOHOL_EXTRACTION_UNIT_PERCENT")
    public Double getChemBenzeneAlcoholExtractionUnitPercent() {
        return chemBenzeneAlcoholExtractionUnitPercent;
    }

    public void setChemBenzeneAlcoholExtractionUnitPercent(Double chemBenzeneAlcoholExtractionUnitPercent) {
        this.chemBenzeneAlcoholExtractionUnitPercent = chemBenzeneAlcoholExtractionUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_HOT_WATER_EXTRACTION_UNIT_PERCENT")
    public Double getChemHotWaterExtractionUnitPercent() {
        return chemHotWaterExtractionUnitPercent;
    }

    public void setChemHotWaterExtractionUnitPercent(Double chemHotWaterExtractionUnitPercent) {
        this.chemHotWaterExtractionUnitPercent = chemHotWaterExtractionUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_COLD_WATER_EXTRACTION_UNIT_PERCENT")
    public Double getChemColdWaterExtractionUnitPercent() {
        return chemColdWaterExtractionUnitPercent;
    }

    public void setChemColdWaterExtractionUnitPercent(Double chemColdWaterExtractionUnitPercent) {
        this.chemColdWaterExtractionUnitPercent = chemColdWaterExtractionUnitPercent;
    }

    @Basic
    @Column(name = "CHEM_ASH_CONTENT_UNIT_PERCENT")
    public Double getChemAshContentUnitPercent() {
        return chemAshContentUnitPercent;
    }

    public void setChemAshContentUnitPercent(Double chemAshContentUnitPercent) {
        this.chemAshContentUnitPercent = chemAshContentUnitPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TChemistryTable that = (TChemistryTable) o;
        return Objects.equals(chemId, that.chemId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(chemHolocelluloseUnitPercent, that.chemHolocelluloseUnitPercent) &&
                Objects.equals(chemCelluloseUnitPercent, that.chemCelluloseUnitPercent) &&
                Objects.equals(chemHemicelluloseUnitPercent, that.chemHemicelluloseUnitPercent) &&
                Objects.equals(chemACelluloseUnitPercent, that.chemACelluloseUnitPercent) &&
                Objects.equals(chemAcidInsolubleLigninUnitPercent, that.chemAcidInsolubleLigninUnitPercent) &&
                Objects.equals(chemBenzeneAlcoholExtractionUnitPercent, that.chemBenzeneAlcoholExtractionUnitPercent) &&
                Objects.equals(chemHotWaterExtractionUnitPercent, that.chemHotWaterExtractionUnitPercent) &&
                Objects.equals(chemColdWaterExtractionUnitPercent, that.chemColdWaterExtractionUnitPercent) &&
                Objects.equals(chemAshContentUnitPercent, that.chemAshContentUnitPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chemId, specId, chemHolocelluloseUnitPercent, chemCelluloseUnitPercent, chemHemicelluloseUnitPercent, chemACelluloseUnitPercent, chemAcidInsolubleLigninUnitPercent, chemBenzeneAlcoholExtractionUnitPercent, chemHotWaterExtractionUnitPercent, chemColdWaterExtractionUnitPercent, chemAshContentUnitPercent);
    }
}
