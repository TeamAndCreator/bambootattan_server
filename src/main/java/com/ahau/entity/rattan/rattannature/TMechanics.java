package com.ahau.entity.rattan.rattannature;

import com.ahau.entity.bamboo.base.Spec;
import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（力学性质表）
 * Created by: 张理
 * 2018-11-3 16：10
 */
@Entity
public class TMechanics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechId;

    /* 外键：种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

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

    /* 柔量: */
    private Double mechComplianceUnitRouliang;

    public Long getMechId() {
        return mechId;
    }

    public void setMechId(Long mechId) {
        this.mechId = mechId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
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

    @Override
    public String toString() {
        return "TMechanics{" +
                "mechId=" + mechId +
                ", rattanSpec=" + rattanSpec +
                ", mechBendingModulusElastictyUnitGpa=" + mechBendingModulusElastictyUnitGpa +
                ", mechBendingStrenghtUnitMpa=" + mechBendingStrenghtUnitMpa +
                ", mechCompressionStrenghtUnitMpa=" + mechCompressionStrenghtUnitMpa +
                ", mechShearStrenghtUnitMpa=" + mechShearStrenghtUnitMpa +
                ", mechTensileStrenghtUnitMpa=" + mechTensileStrenghtUnitMpa +
                ", mechImpactDuctilityUnitRenxiang=" + mechImpactDuctilityUnitRenxiang +
                ", mechComplianceUnitRouliang=" + mechComplianceUnitRouliang +
                '}';
    }
}
