package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;

/**
 * 实体类：（结构性质表）
 * Created by: 张理
 * 2018-11-3 15：13
 */
@Entity
public class Structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Structure{" +
                "stId=" + stId +
                ", spec=" + spec +
                ", stStemDiameterUnitMm=" + stStemDiameterUnitMm +
                ", stWallThicknessUnitMm=" + stWallThicknessUnitMm +
                ", stMaximumInternodeLengthUnitCm=" + stMaximumInternodeLengthUnitCm +
                ", stRattanDiameterUnitMm=" + stRattanDiameterUnitMm +
                '}';
    }
}
