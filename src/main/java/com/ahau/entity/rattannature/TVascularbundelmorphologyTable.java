package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（解剖性质_维管束形态特征表）
 * Created by: 张理
 * 2018-11-1 16：50
 */
@Entity
@Table(name = "aau_tvascularbundelmorphology_table", schema = "bambootattan", catalog = "")
public class TVascularbundelmorphologyTable {
    private String vbmId;
    private String specId;
    private Double vbmRadialDiameterUnitMicrom;
    private Double vbmChordDiameterUnitMicrom;
    private Double vbmDensityUnitVcmidu;

    @Id
    @Column(name = "VBM_ID")
    public String getVbmId() {
        return vbmId;
    }

    public void setVbmId(String vbmId) {
        this.vbmId = vbmId;
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
    @Column(name = "VBM_RADIAL_DIAMETER_UNIT_MICROM")
    public Double getVbmRadialDiameterUnitMicrom() {
        return vbmRadialDiameterUnitMicrom;
    }

    public void setVbmRadialDiameterUnitMicrom(Double vbmRadialDiameterUnitMicrom) {
        this.vbmRadialDiameterUnitMicrom = vbmRadialDiameterUnitMicrom;
    }

    @Basic
    @Column(name = "VBM_CHORD_DIAMETER_UNIT_MICROM")
    public Double getVbmChordDiameterUnitMicrom() {
        return vbmChordDiameterUnitMicrom;
    }

    public void setVbmChordDiameterUnitMicrom(Double vbmChordDiameterUnitMicrom) {
        this.vbmChordDiameterUnitMicrom = vbmChordDiameterUnitMicrom;
    }

    @Basic
    @Column(name = "VBM_DENSITY_UNIT_VCMIDU")
    public Double getVbmDensityUnitVcmidu() {
        return vbmDensityUnitVcmidu;
    }

    public void setVbmDensityUnitVcmidu(Double vbmDensityUnitVcmidu) {
        this.vbmDensityUnitVcmidu = vbmDensityUnitVcmidu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVascularbundelmorphologyTable that = (TVascularbundelmorphologyTable) o;
        return Objects.equals(vbmId, that.vbmId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(vbmRadialDiameterUnitMicrom, that.vbmRadialDiameterUnitMicrom) &&
                Objects.equals(vbmChordDiameterUnitMicrom, that.vbmChordDiameterUnitMicrom) &&
                Objects.equals(vbmDensityUnitVcmidu, that.vbmDensityUnitVcmidu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vbmId, specId, vbmRadialDiameterUnitMicrom, vbmChordDiameterUnitMicrom, vbmDensityUnitVcmidu);
    }
}
