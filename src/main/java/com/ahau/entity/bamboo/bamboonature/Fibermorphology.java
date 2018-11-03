package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;

/**
 * 实体类：（解剖性质_纤维形态特征表）
 * Created by: 张理
 * 2018-11-3 14：52
 */
@Entity
public class Fibermorphology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fmId;

    /* 外键：种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 纤维长度 */
    private Double fmLengthUnitMicron;

    /* 纤维宽度 */
    private Double fmWidthUnitMicron;

    /* 纤维双壁厚 */
    private Double fmDwallThicknessUnitMicron;

    /* 纤维长宽比 */
    private Double fmLetWidthRatio;

    /* 纤维腔径 */
    private Double fmCavityDeameterUnitMicrom;

    /* 纤维壁腔比 */
    private Double fmWallCavityRatio;

    /* 纤维腔径比 */
    private Double fmCavityDiameterRatio;

    public Long getFmId() {
        return fmId;
    }

    public void setFmId(Long fmId) {
        this.fmId = fmId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Double getFmLengthUnitMicron() {
        return fmLengthUnitMicron;
    }

    public void setFmLengthUnitMicron(Double fmLengthUnitMicron) {
        this.fmLengthUnitMicron = fmLengthUnitMicron;
    }

    public Double getFmWidthUnitMicron() {
        return fmWidthUnitMicron;
    }

    public void setFmWidthUnitMicron(Double fmWidthUnitMicron) {
        this.fmWidthUnitMicron = fmWidthUnitMicron;
    }

    public Double getFmDwallThicknessUnitMicron() {
        return fmDwallThicknessUnitMicron;
    }

    public void setFmDwallThicknessUnitMicron(Double fmDwallThicknessUnitMicron) {
        this.fmDwallThicknessUnitMicron = fmDwallThicknessUnitMicron;
    }

    public Double getFmLetWidthRatio() {
        return fmLetWidthRatio;
    }

    public void setFmLetWidthRatio(Double fmLetWidthRatio) {
        this.fmLetWidthRatio = fmLetWidthRatio;
    }

    public Double getFmCavityDeameterUnitMicrom() {
        return fmCavityDeameterUnitMicrom;
    }

    public void setFmCavityDeameterUnitMicrom(Double fmCavityDeameterUnitMicrom) {
        this.fmCavityDeameterUnitMicrom = fmCavityDeameterUnitMicrom;
    }

    public Double getFmWallCavityRatio() {
        return fmWallCavityRatio;
    }

    public void setFmWallCavityRatio(Double fmWallCavityRatio) {
        this.fmWallCavityRatio = fmWallCavityRatio;
    }

    public Double getFmCavityDiameterRatio() {
        return fmCavityDiameterRatio;
    }

    public void setFmCavityDiameterRatio(Double fmCavityDiameterRatio) {
        this.fmCavityDiameterRatio = fmCavityDiameterRatio;
    }

    @Override
    public String toString() {
        return "Fibermorphology{" +
                "fmId=" + fmId +
                ", spec=" + spec +
                ", fmLengthUnitMicron=" + fmLengthUnitMicron +
                ", fmWidthUnitMicron=" + fmWidthUnitMicron +
                ", fmDwallThicknessUnitMicron=" + fmDwallThicknessUnitMicron +
                ", fmLetWidthRatio=" + fmLetWidthRatio +
                ", fmCavityDeameterUnitMicrom=" + fmCavityDeameterUnitMicrom +
                ", fmWallCavityRatio=" + fmWallCavityRatio +
                ", fmCavityDiameterRatio=" + fmCavityDiameterRatio +
                '}';
    }
}
