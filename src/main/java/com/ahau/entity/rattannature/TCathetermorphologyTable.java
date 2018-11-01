package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（解剖性质_导管形态特征表）
 * Created by: 张理
 * 2018-11-1 15：55
 */
@Entity
@Table(name = "aau_tcathetermorphology_table", schema = "bambootattan", catalog = "")
public class TCathetermorphologyTable {
    private String chmId;
    private String specId;
    private Double chmCatheterLenghtUnitMicrom;
    private Double chmCatheterDiameterUnitMicrom;
    private Double chmCatheterDensityUnitVcmidu;
    private Double chmIndex;

    @Id
    @Column(name = "CHM_ID")
    public String getChmId() {
        return chmId;
    }

    public void setChmId(String chmId) {
        this.chmId = chmId;
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
    @Column(name = "CHM_CATHETER_LENGHT_UNIT_MICROM")
    public Double getChmCatheterLenghtUnitMicrom() {
        return chmCatheterLenghtUnitMicrom;
    }

    public void setChmCatheterLenghtUnitMicrom(Double chmCatheterLenghtUnitMicrom) {
        this.chmCatheterLenghtUnitMicrom = chmCatheterLenghtUnitMicrom;
    }

    @Basic
    @Column(name = "CHM_CATHETER_DIAMETER_UNIT_MICROM")
    public Double getChmCatheterDiameterUnitMicrom() {
        return chmCatheterDiameterUnitMicrom;
    }

    public void setChmCatheterDiameterUnitMicrom(Double chmCatheterDiameterUnitMicrom) {
        this.chmCatheterDiameterUnitMicrom = chmCatheterDiameterUnitMicrom;
    }

    @Basic
    @Column(name = "CHM_CATHETER_DENSITY_UNIT_VCMIDU")
    public Double getChmCatheterDensityUnitVcmidu() {
        return chmCatheterDensityUnitVcmidu;
    }

    public void setChmCatheterDensityUnitVcmidu(Double chmCatheterDensityUnitVcmidu) {
        this.chmCatheterDensityUnitVcmidu = chmCatheterDensityUnitVcmidu;
    }

    @Basic
    @Column(name = "CHM_INDEX")
    public Double getChmIndex() {
        return chmIndex;
    }

    public void setChmIndex(Double chmIndex) {
        this.chmIndex = chmIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCathetermorphologyTable that = (TCathetermorphologyTable) o;
        return Objects.equals(chmId, that.chmId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(chmCatheterLenghtUnitMicrom, that.chmCatheterLenghtUnitMicrom) &&
                Objects.equals(chmCatheterDiameterUnitMicrom, that.chmCatheterDiameterUnitMicrom) &&
                Objects.equals(chmCatheterDensityUnitVcmidu, that.chmCatheterDensityUnitVcmidu) &&
                Objects.equals(chmIndex, that.chmIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chmId, specId, chmCatheterLenghtUnitMicrom, chmCatheterDiameterUnitMicrom, chmCatheterDensityUnitVcmidu, chmIndex);
    }
}
