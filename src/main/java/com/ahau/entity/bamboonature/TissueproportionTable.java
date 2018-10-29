package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（解剖性质_组织比量表）
 * created by: 张理
 * 2018-10-26 21：55
 */
@Entity
public class TissueproportionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识：外键 */
    private String specId;
    /* 种标识：外键（模糊查询） */
    private String specIdLike;
    /* 纤维比量 */
    private Double tpFiberPeoportionUnitPercent;
    /* 纤维比量（查询上限） */
    private Double beginTpFiberPeoportionUnitPercent;
    /* 纤维比量（查询下限） */
    private Double endTpFiberPeoportionUnitPercent;
    /* 导管比量 */
    private Double tpVesselProportionUnitPercent;
    /* 导管比量（查询上限） */
    private Double beginTpVesselProportionUnitPercent;
    /* 导管比量（查询下限） */
    private Double endTpVesselProportionUnitPercent;
    /* 筛管比量 */
    private Double tpSieveTubeProportionUnitPercent;
    /* 筛管比量（查询上限） */
    private Double beginTpSieveTubeProportionUnitPercent;
    /* 筛管比量（查询下限） */
    private Double endTpSieveTubeProportionUnitPercent;
    /* 薄壁细胞比量 */
    private Double tpParenchymaCellProportionUnitPercent;
    /* 薄壁细胞比量（查询上限） */
    private Double beginTpParenchymaCellProportionUnitPercent;
    /* 薄壁细胞比量（查询下限） */
    private Double endTpParenchymaCellProportionUnitPercent;

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

    public Double getTpFiberPeoportionUnitPercent() {
        return tpFiberPeoportionUnitPercent;
    }

    public void setTpFiberPeoportionUnitPercent(Double tpFiberPeoportionUnitPercent) {
        this.tpFiberPeoportionUnitPercent = tpFiberPeoportionUnitPercent;
    }

    public Double getBeginTpFiberPeoportionUnitPercent() {
        return beginTpFiberPeoportionUnitPercent;
    }

    public void setBeginTpFiberPeoportionUnitPercent(Double beginTpFiberPeoportionUnitPercent) {
        this.beginTpFiberPeoportionUnitPercent = beginTpFiberPeoportionUnitPercent;
    }

    public Double getEndTpFiberPeoportionUnitPercent() {
        return endTpFiberPeoportionUnitPercent;
    }

    public void setEndTpFiberPeoportionUnitPercent(Double endTpFiberPeoportionUnitPercent) {
        this.endTpFiberPeoportionUnitPercent = endTpFiberPeoportionUnitPercent;
    }

    public Double getTpVesselProportionUnitPercent() {
        return tpVesselProportionUnitPercent;
    }

    public void setTpVesselProportionUnitPercent(Double tpVesselProportionUnitPercent) {
        this.tpVesselProportionUnitPercent = tpVesselProportionUnitPercent;
    }

    public Double getBeginTpVesselProportionUnitPercent() {
        return beginTpVesselProportionUnitPercent;
    }

    public void setBeginTpVesselProportionUnitPercent(Double beginTpVesselProportionUnitPercent) {
        this.beginTpVesselProportionUnitPercent = beginTpVesselProportionUnitPercent;
    }

    public Double getEndTpVesselProportionUnitPercent() {
        return endTpVesselProportionUnitPercent;
    }

    public void setEndTpVesselProportionUnitPercent(Double endTpVesselProportionUnitPercent) {
        this.endTpVesselProportionUnitPercent = endTpVesselProportionUnitPercent;
    }

    public Double getTpSieveTubeProportionUnitPercent() {
        return tpSieveTubeProportionUnitPercent;
    }

    public void setTpSieveTubeProportionUnitPercent(Double tpSieveTubeProportionUnitPercent) {
        this.tpSieveTubeProportionUnitPercent = tpSieveTubeProportionUnitPercent;
    }

    public Double getBeginTpSieveTubeProportionUnitPercent() {
        return beginTpSieveTubeProportionUnitPercent;
    }

    public void setBeginTpSieveTubeProportionUnitPercent(Double beginTpSieveTubeProportionUnitPercent) {
        this.beginTpSieveTubeProportionUnitPercent = beginTpSieveTubeProportionUnitPercent;
    }

    public Double getEndTpSieveTubeProportionUnitPercent() {
        return endTpSieveTubeProportionUnitPercent;
    }

    public void setEndTpSieveTubeProportionUnitPercent(Double endTpSieveTubeProportionUnitPercent) {
        this.endTpSieveTubeProportionUnitPercent = endTpSieveTubeProportionUnitPercent;
    }

    public Double getTpParenchymaCellProportionUnitPercent() {
        return tpParenchymaCellProportionUnitPercent;
    }

    public void setTpParenchymaCellProportionUnitPercent(Double tpParenchymaCellProportionUnitPercent) {
        this.tpParenchymaCellProportionUnitPercent = tpParenchymaCellProportionUnitPercent;
    }

    public Double getBeginTpParenchymaCellProportionUnitPercent() {
        return beginTpParenchymaCellProportionUnitPercent;
    }

    public void setBeginTpParenchymaCellProportionUnitPercent(Double beginTpParenchymaCellProportionUnitPercent) {
        this.beginTpParenchymaCellProportionUnitPercent = beginTpParenchymaCellProportionUnitPercent;
    }

    public Double getEndTpParenchymaCellProportionUnitPercent() {
        return endTpParenchymaCellProportionUnitPercent;
    }

    public void setEndTpParenchymaCellProportionUnitPercent(Double endTpParenchymaCellProportionUnitPercent) {
        this.endTpParenchymaCellProportionUnitPercent = endTpParenchymaCellProportionUnitPercent;
    }
}
