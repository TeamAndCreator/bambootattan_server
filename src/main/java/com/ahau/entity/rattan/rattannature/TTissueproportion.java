package com.ahau.entity.rattan.rattannature;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（解剖性质_组织比量表）
 * Created by: 张理
 * 2018-11-3 16：15
 */
@Entity
public class TTissueproportion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tpId;

    /* 种标识：外键 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 纤维比量 */
    private Double tpFiberPeoportionUnitPercent;

    /* 导管比量 */
    private Double tpVesselProportionUnitPercent;

    /* 筛管比量 */
    private Double tpSieveTubeProportionUnitPercent;

    /* 薄壁细胞比量 */
    private Double tpParenchymaCellProportionUnitPercent;

    public Long getTpId() {
        return tpId;
    }

    public void setTpId(Long tpId) {
        this.tpId = tpId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public Double getTpFiberPeoportionUnitPercent() {
        return tpFiberPeoportionUnitPercent;
    }

    public void setTpFiberPeoportionUnitPercent(Double tpFiberPeoportionUnitPercent) {
        this.tpFiberPeoportionUnitPercent = tpFiberPeoportionUnitPercent;
    }

    public Double getTpVesselProportionUnitPercent() {
        return tpVesselProportionUnitPercent;
    }

    public void setTpVesselProportionUnitPercent(Double tpVesselProportionUnitPercent) {
        this.tpVesselProportionUnitPercent = tpVesselProportionUnitPercent;
    }

    public Double getTpSieveTubeProportionUnitPercent() {
        return tpSieveTubeProportionUnitPercent;
    }

    public void setTpSieveTubeProportionUnitPercent(Double tpSieveTubeProportionUnitPercent) {
        this.tpSieveTubeProportionUnitPercent = tpSieveTubeProportionUnitPercent;
    }

    public Double getTpParenchymaCellProportionUnitPercent() {
        return tpParenchymaCellProportionUnitPercent;
    }

    public void setTpParenchymaCellProportionUnitPercent(Double tpParenchymaCellProportionUnitPercent) {
        this.tpParenchymaCellProportionUnitPercent = tpParenchymaCellProportionUnitPercent;
    }

    @Override
    public String toString() {
        return "TTissueproportion{" +
                "tpId=" + tpId +
                ", rattanSpec=" + rattanSpec +
                ", tpFiberPeoportionUnitPercent=" + tpFiberPeoportionUnitPercent +
                ", tpVesselProportionUnitPercent=" + tpVesselProportionUnitPercent +
                ", tpSieveTubeProportionUnitPercent=" + tpSieveTubeProportionUnitPercent +
                ", tpParenchymaCellProportionUnitPercent=" + tpParenchymaCellProportionUnitPercent +
                '}';
    }
}
