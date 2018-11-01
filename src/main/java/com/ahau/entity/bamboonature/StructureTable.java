package com.ahau.entity.bamboonature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（结构性质表）
 * created by: 张理
 * 2018-10-26 20：00
 */
@Entity
@Table(name = "aau_structure_table", schema = "bambootattan", catalog = "")
public class StructureTable {
    private String stId;
    private String specId;
    private Double stStemDiameterUnitMm;
    private Double stWallThicknessUnitMm;
    private Double stMaximumInternodeLengthUnitCm;
    private Double stRattanDiameterUnitMm;

    @Id
    @Column(name = "ST_ID")
    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
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
    @Column(name = "ST_STEM_DIAMETER_UNIT_MM")
    public Double getStStemDiameterUnitMm() {
        return stStemDiameterUnitMm;
    }

    public void setStStemDiameterUnitMm(Double stStemDiameterUnitMm) {
        this.stStemDiameterUnitMm = stStemDiameterUnitMm;
    }

    @Basic
    @Column(name = "ST_WALL_THICKNESS_UNIT_MM")
    public Double getStWallThicknessUnitMm() {
        return stWallThicknessUnitMm;
    }

    public void setStWallThicknessUnitMm(Double stWallThicknessUnitMm) {
        this.stWallThicknessUnitMm = stWallThicknessUnitMm;
    }

    @Basic
    @Column(name = "ST_MAXIMUM_INTERNODE_LENGTH_UNIT_CM")
    public Double getStMaximumInternodeLengthUnitCm() {
        return stMaximumInternodeLengthUnitCm;
    }

    public void setStMaximumInternodeLengthUnitCm(Double stMaximumInternodeLengthUnitCm) {
        this.stMaximumInternodeLengthUnitCm = stMaximumInternodeLengthUnitCm;
    }

    @Basic
    @Column(name = "ST_RATTAN_DIAMETER_UNIT_MM")
    public Double getStRattanDiameterUnitMm() {
        return stRattanDiameterUnitMm;
    }

    public void setStRattanDiameterUnitMm(Double stRattanDiameterUnitMm) {
        this.stRattanDiameterUnitMm = stRattanDiameterUnitMm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructureTable that = (StructureTable) o;
        return Objects.equals(stId, that.stId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(stStemDiameterUnitMm, that.stStemDiameterUnitMm) &&
                Objects.equals(stWallThicknessUnitMm, that.stWallThicknessUnitMm) &&
                Objects.equals(stMaximumInternodeLengthUnitCm, that.stMaximumInternodeLengthUnitCm) &&
                Objects.equals(stRattanDiameterUnitMm, that.stRattanDiameterUnitMm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, specId, stStemDiameterUnitMm, stWallThicknessUnitMm, stMaximumInternodeLengthUnitCm, stRattanDiameterUnitMm);
    }
}
