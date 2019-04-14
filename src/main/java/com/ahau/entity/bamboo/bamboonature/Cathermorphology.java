package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;

/**
 * 实体类：（解剖性质_导管形态特征表）
 * Created by: 张理
 * 2018-11-3 14：32
 */
@Entity
public class Cathermorphology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chmId;

    /* 种的标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 导管长度 */
    private Double chmCatheterLenghtUnitMicrom;

    /* 导管直径 */
    private Double chmCatheterDiameterUnitMicrom;

    /* 导管密度 */
    private Double chmCatheterDensityUnitVcmidu;

    /* 导管形态指数 */
    private Double chmIndex;

    public Long getChmId() {
        return chmId;
    }

    public void setChmId(Long chmId) {
        this.chmId = chmId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Double getChmCatheterLenghtUnitMicrom() {
        return chmCatheterLenghtUnitMicrom;
    }

    public void setChmCatheterLenghtUnitMicrom(Double chmCatheterLenghtUnitMicrom) {
        this.chmCatheterLenghtUnitMicrom = chmCatheterLenghtUnitMicrom;
    }

    public Double getChmCatheterDiameterUnitMicrom() {
        return chmCatheterDiameterUnitMicrom;
    }

    public void setChmCatheterDiameterUnitMicrom(Double chmCatheterDiameterUnitMicrom) {
        this.chmCatheterDiameterUnitMicrom = chmCatheterDiameterUnitMicrom;
    }

    public Double getChmCatheterDensityUnitVcmidu() {
        return chmCatheterDensityUnitVcmidu;
    }

    public void setChmCatheterDensityUnitVcmidu(Double chmCatheterDensityUnitVcmidu) {
        this.chmCatheterDensityUnitVcmidu = chmCatheterDensityUnitVcmidu;
    }

    public Double getChmIndex() {
        return chmIndex;
    }

    public void setChmIndex(Double chmIndex) {
        this.chmIndex = chmIndex;
    }

    @Override
    public String toString() {
        return "Cathermorphology{" +
                "chmId=" + chmId +
                ", spec=" + spec +
                ", chmCatheterLenghtUnitMicrom=" + chmCatheterLenghtUnitMicrom +
                ", chmCatheterDiameterUnitMicrom=" + chmCatheterDiameterUnitMicrom +
                ", chmCatheterDensityUnitVcmidu=" + chmCatheterDensityUnitVcmidu +
                ", chmIndex=" + chmIndex +
                '}';
    }
}
