package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（结构性质表）
 * Created by: 张理
 * 2018-11-1 16：41
 */
@Entity
@Table(name = "aau_tstructure_table", schema = "bambootattan", catalog = "")
public class TStructureTable {
    private String stId;
    private String specId;
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
        TStructureTable that = (TStructureTable) o;
        return Objects.equals(stId, that.stId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(stMaximumInternodeLengthUnitCm, that.stMaximumInternodeLengthUnitCm) &&
                Objects.equals(stRattanDiameterUnitMm, that.stRattanDiameterUnitMm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, specId, stMaximumInternodeLengthUnitCm, stRattanDiameterUnitMm);
    }
}
