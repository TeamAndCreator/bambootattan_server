package com.ahau.entity.rattan.rattannature;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（解剖性质_维管束形态特征表）
 * Created by: 张理
 * 2018-11-3 16：17
 */
@Entity
public class TVascularbundelmorphology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vbmId;

    /* 外键：是种的标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 维管束径向直径 */
    private Double vbmRadialDiameterUnitMicrom;

    /* 维管束弦向直径 */
    private Double vbmChordDiameterUnitMicrom;

    /* 维管束密度 */
    private Double vbmDensityUnitVcmidu;

    public Long getVbmId() {
        return vbmId;
    }

    public void setVbmId(Long vbmId) {
        this.vbmId = vbmId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public Double getVbmRadialDiameterUnitMicrom() {
        return vbmRadialDiameterUnitMicrom;
    }

    public void setVbmRadialDiameterUnitMicrom(Double vbmRadialDiameterUnitMicrom) {
        this.vbmRadialDiameterUnitMicrom = vbmRadialDiameterUnitMicrom;
    }

    public Double getVbmChordDiameterUnitMicrom() {
        return vbmChordDiameterUnitMicrom;
    }

    public void setVbmChordDiameterUnitMicrom(Double vbmChordDiameterUnitMicrom) {
        this.vbmChordDiameterUnitMicrom = vbmChordDiameterUnitMicrom;
    }

    public Double getVbmDensityUnitVcmidu() {
        return vbmDensityUnitVcmidu;
    }

    public void setVbmDensityUnitVcmidu(Double vbmDensityUnitVcmidu) {
        this.vbmDensityUnitVcmidu = vbmDensityUnitVcmidu;
    }

    @Override
    public String toString() {
        return "TVascularbundelmorphology{" +
                "vbmId=" + vbmId +
                ", rattanSpec=" + rattanSpec +
                ", vbmRadialDiameterUnitMicrom=" + vbmRadialDiameterUnitMicrom +
                ", vbmChordDiameterUnitMicrom=" + vbmChordDiameterUnitMicrom +
                ", vbmDensityUnitVcmidu=" + vbmDensityUnitVcmidu +
                '}';
    }
}
