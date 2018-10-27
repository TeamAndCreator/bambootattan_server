package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（解剖性质_维管束形态特征表）
 * created by: 张理
 * 2018-10-26 21：42
 */
@Entity
public class VascularbundelmorphologyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 外键：是种的标识 */
    private String specId;
    /* 外键：是种的标识（模糊查询）*/
    private String specIdLike;
    /* 维管束径向直径 */
    private Double vbmRadialDiameterUnitMicrom;
    /* 维管束径向直径（查询上限）*/
    private Double beginVbmRadialDiameterUnitMicrom;
    /* 维管束径向直径（查询下限）*/
    private Double endVbmRadialDiameterUnitMicrom;
    /* 维管束弦向直径 */
    private Double vbmChordDiameterUnitMicrom;
    /* 维管束弦向直径（查询上限）*/
    private Double beginVbmChordDiameterUnitMicrom;
    /* 维管束弦向直径（查询下限）*/
    private Double endVbmChordDiameterUnitMicrom;
    /* 维管束密度 */
    private Double vbmDensityUnitVcmidu;
    /* 维管束密度（查询上限）*/
    private Double beginVbmDensityUnitVcmidu;
    /* 维管束密度（查询下限）*/
    private Double endVbmDensityUnitVcmidu;

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

    public Double getVbmRadialDiameterUnitMicrom() {
        return vbmRadialDiameterUnitMicrom;
    }

    public void setVbmRadialDiameterUnitMicrom(Double vbmRadialDiameterUnitMicrom) {
        this.vbmRadialDiameterUnitMicrom = vbmRadialDiameterUnitMicrom;
    }

    public Double getBeginVbmRadialDiameterUnitMicrom() {
        return beginVbmRadialDiameterUnitMicrom;
    }

    public void setBeginVbmRadialDiameterUnitMicrom(Double beginVbmRadialDiameterUnitMicrom) {
        this.beginVbmRadialDiameterUnitMicrom = beginVbmRadialDiameterUnitMicrom;
    }

    public Double getEndVbmRadialDiameterUnitMicrom() {
        return endVbmRadialDiameterUnitMicrom;
    }

    public void setEndVbmRadialDiameterUnitMicrom(Double endVbmRadialDiameterUnitMicrom) {
        this.endVbmRadialDiameterUnitMicrom = endVbmRadialDiameterUnitMicrom;
    }

    public Double getVbmChordDiameterUnitMicrom() {
        return vbmChordDiameterUnitMicrom;
    }

    public void setVbmChordDiameterUnitMicrom(Double vbmChordDiameterUnitMicrom) {
        this.vbmChordDiameterUnitMicrom = vbmChordDiameterUnitMicrom;
    }

    public Double getBeginVbmChordDiameterUnitMicrom() {
        return beginVbmChordDiameterUnitMicrom;
    }

    public void setBeginVbmChordDiameterUnitMicrom(Double beginVbmChordDiameterUnitMicrom) {
        this.beginVbmChordDiameterUnitMicrom = beginVbmChordDiameterUnitMicrom;
    }

    public Double getEndVbmChordDiameterUnitMicrom() {
        return endVbmChordDiameterUnitMicrom;
    }

    public void setEndVbmChordDiameterUnitMicrom(Double endVbmChordDiameterUnitMicrom) {
        this.endVbmChordDiameterUnitMicrom = endVbmChordDiameterUnitMicrom;
    }

    public Double getVbmDensityUnitVcmidu() {
        return vbmDensityUnitVcmidu;
    }

    public void setVbmDensityUnitVcmidu(Double vbmDensityUnitVcmidu) {
        this.vbmDensityUnitVcmidu = vbmDensityUnitVcmidu;
    }

    public Double getBeginVbmDensityUnitVcmidu() {
        return beginVbmDensityUnitVcmidu;
    }

    public void setBeginVbmDensityUnitVcmidu(Double beginVbmDensityUnitVcmidu) {
        this.beginVbmDensityUnitVcmidu = beginVbmDensityUnitVcmidu;
    }

    public Double getEndVbmDensityUnitVcmidu() {
        return endVbmDensityUnitVcmidu;
    }

    public void setEndVbmDensityUnitVcmidu(Double endVbmDensityUnitVcmidu) {
        this.endVbmDensityUnitVcmidu = endVbmDensityUnitVcmidu;
    }
}
