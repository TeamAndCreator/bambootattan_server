package com.ahau.entity.rattan.rattannature;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（结构性质表）
 * Created by: 张理
 * 2018-11-3 16：13
 */
@Entity
public class TStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 胸高处的秆径 */
    private Double stStemDiameterUnitMm;

    /* 竹筒壁厚 */
    private Double stWallThicknessUnitMm;

    /* 最长节间长 */
    private Double stMaximumInternodeLengthUnitCm;

    /* 2m处的藤径(mm) */
    private Double stRattanDiameterUnitMm;

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public Double getStStemDiameterUnitMm() {
        return stStemDiameterUnitMm;
    }

    public void setStStemDiameterUnitMm(Double stStemDiameterUnitMm) {
        this.stStemDiameterUnitMm = stStemDiameterUnitMm;
    }

    public Double getStWallThicknessUnitMm() {
        return stWallThicknessUnitMm;
    }

    public void setStWallThicknessUnitMm(Double stWallThicknessUnitMm) {
        this.stWallThicknessUnitMm = stWallThicknessUnitMm;
    }

    public Double getStMaximumInternodeLengthUnitCm() {
        return stMaximumInternodeLengthUnitCm;
    }

    public void setStMaximumInternodeLengthUnitCm(Double stMaximumInternodeLengthUnitCm) {
        this.stMaximumInternodeLengthUnitCm = stMaximumInternodeLengthUnitCm;
    }

    public Double getStRattanDiameterUnitMm() {
        return stRattanDiameterUnitMm;
    }

    public void setStRattanDiameterUnitMm(Double stRattanDiameterUnitMm) {
        this.stRattanDiameterUnitMm = stRattanDiameterUnitMm;
    }

    @Override
    public String toString() {
        return "TStructure{" +
                "stId=" + stId +
                ", rattanSpec=" + rattanSpec +
                ", stStemDiameterUnitMm=" + stStemDiameterUnitMm +
                ", stWallThicknessUnitMm=" + stWallThicknessUnitMm +
                ", stMaximumInternodeLengthUnitCm=" + stMaximumInternodeLengthUnitCm +
                ", stRattanDiameterUnitMm=" + stRattanDiameterUnitMm +
                '}';
    }
}
