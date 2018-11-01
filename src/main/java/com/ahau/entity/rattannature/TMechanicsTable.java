package com.ahau.entity.rattannature;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（力学性质表）
 * Created by: 张理
 * 2018-11-1 16：31
 */
@Entity
@Table(name = "aau_tmechanics_table", schema = "bambootattan", catalog = "")
public class TMechanicsTable {
    private String mechId;
    private String specId;
    private Double mechBendingModulusElastictyUnitGPa;
    private Double mechBendingStrenghtUnitMPa;
    private Double mechCompressionStrenghtUnitMPa;
    private Double mechShearStrenghtUnitMPa;
    private Double mechTensileStrenghtUnitMPa;
    private Double mechImpactDuctilityUnitRenxiang;
    private Double mechComplianceUnitRouliang;

    @Id
    @Column(name = "MECH_ID")
    public String getMechId() {
        return mechId;
    }

    public void setMechId(String mechId) {
        this.mechId = mechId;
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
    @Column(name = "MECH_BENDING_MODULUS_ELASTICTY_UNIT_GPa")
    public Double getMechBendingModulusElastictyUnitGPa() {
        return mechBendingModulusElastictyUnitGPa;
    }

    public void setMechBendingModulusElastictyUnitGPa(Double mechBendingModulusElastictyUnitGPa) {
        this.mechBendingModulusElastictyUnitGPa = mechBendingModulusElastictyUnitGPa;
    }

    @Basic
    @Column(name = "MECH_BENDING_STRENGHT_UNIT_MPa")
    public Double getMechBendingStrenghtUnitMPa() {
        return mechBendingStrenghtUnitMPa;
    }

    public void setMechBendingStrenghtUnitMPa(Double mechBendingStrenghtUnitMPa) {
        this.mechBendingStrenghtUnitMPa = mechBendingStrenghtUnitMPa;
    }

    @Basic
    @Column(name = "MECH_COMPRESSION_STRENGHT_UNIT_MPa")
    public Double getMechCompressionStrenghtUnitMPa() {
        return mechCompressionStrenghtUnitMPa;
    }

    public void setMechCompressionStrenghtUnitMPa(Double mechCompressionStrenghtUnitMPa) {
        this.mechCompressionStrenghtUnitMPa = mechCompressionStrenghtUnitMPa;
    }

    @Basic
    @Column(name = "MECH_SHEAR_STRENGHT_UNIT_MPa")
    public Double getMechShearStrenghtUnitMPa() {
        return mechShearStrenghtUnitMPa;
    }

    public void setMechShearStrenghtUnitMPa(Double mechShearStrenghtUnitMPa) {
        this.mechShearStrenghtUnitMPa = mechShearStrenghtUnitMPa;
    }

    @Basic
    @Column(name = "MECH_TENSILE_STRENGHT_UNIT_MPa")
    public Double getMechTensileStrenghtUnitMPa() {
        return mechTensileStrenghtUnitMPa;
    }

    public void setMechTensileStrenghtUnitMPa(Double mechTensileStrenghtUnitMPa) {
        this.mechTensileStrenghtUnitMPa = mechTensileStrenghtUnitMPa;
    }

    @Basic
    @Column(name = "MECH_IMPACT_DUCTILITY_UNIT_RENXIANG")
    public Double getMechImpactDuctilityUnitRenxiang() {
        return mechImpactDuctilityUnitRenxiang;
    }

    public void setMechImpactDuctilityUnitRenxiang(Double mechImpactDuctilityUnitRenxiang) {
        this.mechImpactDuctilityUnitRenxiang = mechImpactDuctilityUnitRenxiang;
    }

    @Basic
    @Column(name = "MECH_COMPLIANCE_UNIT_ROULIANG")
    public Double getMechComplianceUnitRouliang() {
        return mechComplianceUnitRouliang;
    }

    public void setMechComplianceUnitRouliang(Double mechComplianceUnitRouliang) {
        this.mechComplianceUnitRouliang = mechComplianceUnitRouliang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TMechanicsTable that = (TMechanicsTable) o;
        return Objects.equals(mechId, that.mechId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(mechBendingModulusElastictyUnitGPa, that.mechBendingModulusElastictyUnitGPa) &&
                Objects.equals(mechBendingStrenghtUnitMPa, that.mechBendingStrenghtUnitMPa) &&
                Objects.equals(mechCompressionStrenghtUnitMPa, that.mechCompressionStrenghtUnitMPa) &&
                Objects.equals(mechShearStrenghtUnitMPa, that.mechShearStrenghtUnitMPa) &&
                Objects.equals(mechTensileStrenghtUnitMPa, that.mechTensileStrenghtUnitMPa) &&
                Objects.equals(mechImpactDuctilityUnitRenxiang, that.mechImpactDuctilityUnitRenxiang) &&
                Objects.equals(mechComplianceUnitRouliang, that.mechComplianceUnitRouliang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mechId, specId, mechBendingModulusElastictyUnitGPa, mechBendingStrenghtUnitMPa, mechCompressionStrenghtUnitMPa, mechShearStrenghtUnitMPa, mechTensileStrenghtUnitMPa, mechImpactDuctilityUnitRenxiang, mechComplianceUnitRouliang);
    }
}
