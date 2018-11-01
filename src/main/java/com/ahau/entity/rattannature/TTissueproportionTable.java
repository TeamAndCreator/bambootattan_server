package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（解剖性质_组织比量表）
 * Created by: 张理
 * 2018-11-1 16：45
 */
@Entity
@Table(name = "aau_ttissueproportion_table", schema = "bambootattan", catalog = "")
public class TTissueproportionTable {
    private String tpId;
    private String specId;
    private Double tpFiberPeoportionUnitPercent;
    private Double tpVesselProportionUnitPercent;
    private Double tpSieveTubeProportionUnitPercent;
    private Double tpParenchymaCellProportionUnitPercent;

    @Id
    @Column(name = "TP_ID")
    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
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
    @Column(name = "TP_FIBER_PEOPORTION_UNIT_PERCENT")
    public Double getTpFiberPeoportionUnitPercent() {
        return tpFiberPeoportionUnitPercent;
    }

    public void setTpFiberPeoportionUnitPercent(Double tpFiberPeoportionUnitPercent) {
        this.tpFiberPeoportionUnitPercent = tpFiberPeoportionUnitPercent;
    }

    @Basic
    @Column(name = "TP_VESSEL_PROPORTION_UNIT_PERCENT")
    public Double getTpVesselProportionUnitPercent() {
        return tpVesselProportionUnitPercent;
    }

    public void setTpVesselProportionUnitPercent(Double tpVesselProportionUnitPercent) {
        this.tpVesselProportionUnitPercent = tpVesselProportionUnitPercent;
    }

    @Basic
    @Column(name = "TP_SIEVE_TUBE_PROPORTION_UNIT_PERCENT")
    public Double getTpSieveTubeProportionUnitPercent() {
        return tpSieveTubeProportionUnitPercent;
    }

    public void setTpSieveTubeProportionUnitPercent(Double tpSieveTubeProportionUnitPercent) {
        this.tpSieveTubeProportionUnitPercent = tpSieveTubeProportionUnitPercent;
    }

    @Basic
    @Column(name = "TP_PARENCHYMA_CELL_PROPORTION_UNIT_PERCENT")
    public Double getTpParenchymaCellProportionUnitPercent() {
        return tpParenchymaCellProportionUnitPercent;
    }

    public void setTpParenchymaCellProportionUnitPercent(Double tpParenchymaCellProportionUnitPercent) {
        this.tpParenchymaCellProportionUnitPercent = tpParenchymaCellProportionUnitPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTissueproportionTable that = (TTissueproportionTable) o;
        return Objects.equals(tpId, that.tpId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(tpFiberPeoportionUnitPercent, that.tpFiberPeoportionUnitPercent) &&
                Objects.equals(tpVesselProportionUnitPercent, that.tpVesselProportionUnitPercent) &&
                Objects.equals(tpSieveTubeProportionUnitPercent, that.tpSieveTubeProportionUnitPercent) &&
                Objects.equals(tpParenchymaCellProportionUnitPercent, that.tpParenchymaCellProportionUnitPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tpId, specId, tpFiberPeoportionUnitPercent, tpVesselProportionUnitPercent, tpSieveTubeProportionUnitPercent, tpParenchymaCellProportionUnitPercent);
    }
}
