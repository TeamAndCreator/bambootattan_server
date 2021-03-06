package com.ahau.entity.bamboo.bamboonature;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（力学性质表）
 * Created by: 张理
 * 2018-11-3 14：50
 */
@Entity
public class Mechanics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechId;

    /* 外键：种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 抗弯弹性模量 */
    private Double mechBendingModulusElastictyUnitGpa;

    /* 抗弯强度 */
    private Double mechBendingStrenghtUnitMpa;

    /* 顺纹抗压强度(压缩) */
    private Double mechCompressionStrenghtUnitMpa;

    /* 抗剪强度 */
    private Double mechShearStrenghtUnitMpa;

    /* 顺纹抗拉强度(拉伸) */
    private Double mechTensileStrenghtUnitMpa;

    /* 冲击韧性 */
    private Double mechImpactDuctilityUnitRenxiang;

    /* 柔量 */
    private Double mechComplianceUnitRouliang;

    /* 顺纹拉伸弹性模量 */
    private Double mechStretchElasticModulus;

    /* 顺纹压缩弹性模量 */
    private Double mechCompressiveElasticModulus;

    /* 弯曲模量 */
    private Double mechFlexuralModulus;

    /* 顺纹抗剪强度 */
    private Double mechShearStrength;

    /* 剪切模量 */
    private Double mechShearModulus;

    /* 绝对含水率 */
    private Double phyAbsoluteUnitPercent;

    public Long getMechId() {
        return mechId;
    }

    public void setMechId(Long mechId) {
        this.mechId = mechId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Double getMechBendingModulusElastictyUnitGpa() {
        return mechBendingModulusElastictyUnitGpa;
    }

    public void setMechBendingModulusElastictyUnitGpa(Double mechBendingModulusElastictyUnitGpa) {
        this.mechBendingModulusElastictyUnitGpa = mechBendingModulusElastictyUnitGpa;
    }

    public Double getMechBendingStrenghtUnitMpa() {
        return mechBendingStrenghtUnitMpa;
    }

    public void setMechBendingStrenghtUnitMpa(Double mechBendingStrenghtUnitMpa) {
        this.mechBendingStrenghtUnitMpa = mechBendingStrenghtUnitMpa;
    }

    public Double getMechCompressionStrenghtUnitMpa() {
        return mechCompressionStrenghtUnitMpa;
    }

    public void setMechCompressionStrenghtUnitMpa(Double mechCompressionStrenghtUnitMpa) {
        this.mechCompressionStrenghtUnitMpa = mechCompressionStrenghtUnitMpa;
    }

    public Double getMechShearStrenghtUnitMpa() {
        return mechShearStrenghtUnitMpa;
    }

    public void setMechShearStrenghtUnitMpa(Double mechShearStrenghtUnitMpa) {
        this.mechShearStrenghtUnitMpa = mechShearStrenghtUnitMpa;
    }

    public Double getMechTensileStrenghtUnitMpa() {
        return mechTensileStrenghtUnitMpa;
    }

    public void setMechTensileStrenghtUnitMpa(Double mechTensileStrenghtUnitMpa) {
        this.mechTensileStrenghtUnitMpa = mechTensileStrenghtUnitMpa;
    }

    public Double getMechImpactDuctilityUnitRenxiang() {
        return mechImpactDuctilityUnitRenxiang;
    }

    public void setMechImpactDuctilityUnitRenxiang(Double mechImpactDuctilityUnitRenxiang) {
        this.mechImpactDuctilityUnitRenxiang = mechImpactDuctilityUnitRenxiang;
    }

    public Double getMechComplianceUnitRouliang() {
        return mechComplianceUnitRouliang;
    }

    public void setMechComplianceUnitRouliang(Double mechComplianceUnitRouliang) {
        this.mechComplianceUnitRouliang = mechComplianceUnitRouliang;
    }

    public Double getMechStretchElasticModulus() {
        return mechStretchElasticModulus;
    }

    public void setMechStretchElasticModulus(Double mechStretchElasticModulus) {
        this.mechStretchElasticModulus = mechStretchElasticModulus;
    }

    public Double getMechCompressiveElasticModulus() {
        return mechCompressiveElasticModulus;
    }

    public void setMechCompressiveElasticModulus(Double mechCompressiveElasticModulus) {
        this.mechCompressiveElasticModulus = mechCompressiveElasticModulus;
    }

    public Double getMechFlexuralModulus() {
        return mechFlexuralModulus;
    }

    public void setMechFlexuralModulus(Double mechFlexuralModulus) {
        this.mechFlexuralModulus = mechFlexuralModulus;
    }

    public Double getMechShearStrength() {
        return mechShearStrength;
    }

    public void setMechShearStrength(Double mechShearStrength) {
        this.mechShearStrength = mechShearStrength;
    }

    public Double getMechShearModulus() {
        return mechShearModulus;
    }

    public void setMechShearModulus(Double mechShearModulus) {
        this.mechShearModulus = mechShearModulus;
    }

    public Double getPhyAbsoluteUnitPercent() {
        return phyAbsoluteUnitPercent;
    }

    public void setPhyAbsoluteUnitPercent(Double phyAbsoluteUnitPercent) {
        this.phyAbsoluteUnitPercent = phyAbsoluteUnitPercent;
    }

    @Override
    public String toString() {
        return "Mechanics{" +
                "mechId=" + mechId +
                ", spec=" + spec +
                ", mechBendingModulusElastictyUnitGpa=" + mechBendingModulusElastictyUnitGpa +
                ", mechBendingStrenghtUnitMpa=" + mechBendingStrenghtUnitMpa +
                ", mechCompressionStrenghtUnitMpa=" + mechCompressionStrenghtUnitMpa +
                ", mechShearStrenghtUnitMpa=" + mechShearStrenghtUnitMpa +
                ", mechTensileStrenghtUnitMpa=" + mechTensileStrenghtUnitMpa +
                ", mechImpactDuctilityUnitRenxiang=" + mechImpactDuctilityUnitRenxiang +
                ", mechComplianceUnitRouliang=" + mechComplianceUnitRouliang +
                ", mechStretchElasticModulus=" + mechStretchElasticModulus +
                ", mechCompressiveElasticModulus=" + mechCompressiveElasticModulus +
                ", mechFlexuralModulus=" + mechFlexuralModulus +
                ", mechShearStrength=" + mechShearStrength +
                ", mechShearModulus=" + mechShearModulus +
                ", phyAbsoluteUnitPercent=" + phyAbsoluteUnitPercent +
                '}';
    }
}
