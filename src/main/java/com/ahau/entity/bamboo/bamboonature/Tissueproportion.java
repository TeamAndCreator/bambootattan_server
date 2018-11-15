package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;

/**
 * 实体类：（解剖性质_组织比量表）
 * Created by: 张理
 * 2018-11-3 15：19
 */
@Entity
public class Tissueproportion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tpId;

    /* 种标识：外键 */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Tissueproportion{" +
                "tpId=" + tpId +
                ", spec=" + spec +
                ", tpFiberPeoportionUnitPercent=" + tpFiberPeoportionUnitPercent +
                ", tpVesselProportionUnitPercent=" + tpVesselProportionUnitPercent +
                ", tpSieveTubeProportionUnitPercent=" + tpSieveTubeProportionUnitPercent +
                ", tpParenchymaCellProportionUnitPercent=" + tpParenchymaCellProportionUnitPercent +
                '}';
    }
}
