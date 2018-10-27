package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（力学性质表）
 * created by: 张理
 * 2018-10-26 21：35
 */
@Entity
public class MechanicsTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 外键：种标识 */
    private String specId;
    /* 外键：种标识（模糊查询） */
    private String specIdLike;
    /* 抗弯弹性模量 */
    private Double mechBendingModulusElastictyUnitGpa;
    /* 抗弯弹性模量（查询上限） */
    private Double beginMechBendingModulusElastictyUnitGpa;
    /* 抗弯弹性模量（查询下限） */
    private Double endMechBendingModulusElastictyUnitGpa;
    /* 抗弯强度 */
    private Double mechBendingStrenghtUnitMpa;
    /* 抗弯强度（查询上限） */
    private Double beginMechBendingStrenghtUnitMpa;
    /* 抗弯强度（查询下限） */
    private Double endMechBendingStrenghtUnitMpa;
    /* 顺纹抗压强度(压缩) */
    private Double mechCompressionStrenghtUnitMpa;
    /* 顺纹抗压强度(压缩)（查询上限） */
    private Double beginMechCompressionStrenghtUnitMpa;
    /* 顺纹抗压强度(压缩)（查询下限） */
    private Double endMechCompressionStrenghtUnitMpa;
    /* 抗剪强度 */
    private Double mechShearStrenghtUnitMpa;
    /* 抗剪强度（查询上限） */
    private Double beginMechShearStrenghtUnitMpa;
    /* 抗剪强度（查询下限） */
    private Double endMechShearStrenghtUnitMpa;
    /* 顺纹抗拉强度(拉伸) */
    private Double mechTensileStrenghtUnitMpa;
    /* 顺纹抗拉强度(拉伸)（查询上限） */
    private Double beginMechTensileStrenghtUnitMpa;
    /* 顺纹抗拉强度(拉伸)（查询下限） */
    private Double endMechTensileStrenghtUnitMpa;
    /* 冲击韧性 */
    private Double mechImpactDuctilityUnitRenxiang;
    /* 冲击韧性（查询上限） */
    private Double beginMechImpactDuctilityUnitRenxiang;
    /* 冲击韧性（查询下限） */
    private Double endMechImpactDuctilityUnitRenxiang;
    /* 柔量: */
    private Double mechComplianceUnitRouliang;
    /* 柔量:（查询上限） */
    private Double beginMechComplianceUnitRouliang;
    /* 柔量:（查询下限） */
    private Double endMechComplianceUnitRouliang;

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

    public Double getMechBendingModulusElastictyUnitGpa() {
        return mechBendingModulusElastictyUnitGpa;
    }

    public void setMechBendingModulusElastictyUnitGpa(Double mechBendingModulusElastictyUnitGpa) {
        this.mechBendingModulusElastictyUnitGpa = mechBendingModulusElastictyUnitGpa;
    }

    public Double getBeginMechBendingModulusElastictyUnitGpa() {
        return beginMechBendingModulusElastictyUnitGpa;
    }

    public void setBeginMechBendingModulusElastictyUnitGpa(Double beginMechBendingModulusElastictyUnitGpa) {
        this.beginMechBendingModulusElastictyUnitGpa = beginMechBendingModulusElastictyUnitGpa;
    }

    public Double getEndMechBendingModulusElastictyUnitGpa() {
        return endMechBendingModulusElastictyUnitGpa;
    }

    public void setEndMechBendingModulusElastictyUnitGpa(Double endMechBendingModulusElastictyUnitGpa) {
        this.endMechBendingModulusElastictyUnitGpa = endMechBendingModulusElastictyUnitGpa;
    }

    public Double getMechBendingStrenghtUnitMpa() {
        return mechBendingStrenghtUnitMpa;
    }

    public void setMechBendingStrenghtUnitMpa(Double mechBendingStrenghtUnitMpa) {
        this.mechBendingStrenghtUnitMpa = mechBendingStrenghtUnitMpa;
    }

    public Double getBeginMechBendingStrenghtUnitMpa() {
        return beginMechBendingStrenghtUnitMpa;
    }

    public void setBeginMechBendingStrenghtUnitMpa(Double beginMechBendingStrenghtUnitMpa) {
        this.beginMechBendingStrenghtUnitMpa = beginMechBendingStrenghtUnitMpa;
    }

    public Double getEndMechBendingStrenghtUnitMpa() {
        return endMechBendingStrenghtUnitMpa;
    }

    public void setEndMechBendingStrenghtUnitMpa(Double endMechBendingStrenghtUnitMpa) {
        this.endMechBendingStrenghtUnitMpa = endMechBendingStrenghtUnitMpa;
    }

    public Double getMechCompressionStrenghtUnitMpa() {
        return mechCompressionStrenghtUnitMpa;
    }

    public void setMechCompressionStrenghtUnitMpa(Double mechCompressionStrenghtUnitMpa) {
        this.mechCompressionStrenghtUnitMpa = mechCompressionStrenghtUnitMpa;
    }

    public Double getBeginMechCompressionStrenghtUnitMpa() {
        return beginMechCompressionStrenghtUnitMpa;
    }

    public void setBeginMechCompressionStrenghtUnitMpa(Double beginMechCompressionStrenghtUnitMpa) {
        this.beginMechCompressionStrenghtUnitMpa = beginMechCompressionStrenghtUnitMpa;
    }

    public Double getEndMechCompressionStrenghtUnitMpa() {
        return endMechCompressionStrenghtUnitMpa;
    }

    public void setEndMechCompressionStrenghtUnitMpa(Double endMechCompressionStrenghtUnitMpa) {
        this.endMechCompressionStrenghtUnitMpa = endMechCompressionStrenghtUnitMpa;
    }

    public Double getMechShearStrenghtUnitMpa() {
        return mechShearStrenghtUnitMpa;
    }

    public void setMechShearStrenghtUnitMpa(Double mechShearStrenghtUnitMpa) {
        this.mechShearStrenghtUnitMpa = mechShearStrenghtUnitMpa;
    }

    public Double getBeginMechShearStrenghtUnitMpa() {
        return beginMechShearStrenghtUnitMpa;
    }

    public void setBeginMechShearStrenghtUnitMpa(Double beginMechShearStrenghtUnitMpa) {
        this.beginMechShearStrenghtUnitMpa = beginMechShearStrenghtUnitMpa;
    }

    public Double getEndMechShearStrenghtUnitMpa() {
        return endMechShearStrenghtUnitMpa;
    }

    public void setEndMechShearStrenghtUnitMpa(Double endMechShearStrenghtUnitMpa) {
        this.endMechShearStrenghtUnitMpa = endMechShearStrenghtUnitMpa;
    }

    public Double getMechTensileStrenghtUnitMpa() {
        return mechTensileStrenghtUnitMpa;
    }

    public void setMechTensileStrenghtUnitMpa(Double mechTensileStrenghtUnitMpa) {
        this.mechTensileStrenghtUnitMpa = mechTensileStrenghtUnitMpa;
    }

    public Double getBeginMechTensileStrenghtUnitMpa() {
        return beginMechTensileStrenghtUnitMpa;
    }

    public void setBeginMechTensileStrenghtUnitMpa(Double beginMechTensileStrenghtUnitMpa) {
        this.beginMechTensileStrenghtUnitMpa = beginMechTensileStrenghtUnitMpa;
    }

    public Double getEndMechTensileStrenghtUnitMpa() {
        return endMechTensileStrenghtUnitMpa;
    }

    public void setEndMechTensileStrenghtUnitMpa(Double endMechTensileStrenghtUnitMpa) {
        this.endMechTensileStrenghtUnitMpa = endMechTensileStrenghtUnitMpa;
    }

    public Double getMechImpactDuctilityUnitRenxiang() {
        return mechImpactDuctilityUnitRenxiang;
    }

    public void setMechImpactDuctilityUnitRenxiang(Double mechImpactDuctilityUnitRenxiang) {
        this.mechImpactDuctilityUnitRenxiang = mechImpactDuctilityUnitRenxiang;
    }

    public Double getBeginMechImpactDuctilityUnitRenxiang() {
        return beginMechImpactDuctilityUnitRenxiang;
    }

    public void setBeginMechImpactDuctilityUnitRenxiang(Double beginMechImpactDuctilityUnitRenxiang) {
        this.beginMechImpactDuctilityUnitRenxiang = beginMechImpactDuctilityUnitRenxiang;
    }

    public Double getEndMechImpactDuctilityUnitRenxiang() {
        return endMechImpactDuctilityUnitRenxiang;
    }

    public void setEndMechImpactDuctilityUnitRenxiang(Double endMechImpactDuctilityUnitRenxiang) {
        this.endMechImpactDuctilityUnitRenxiang = endMechImpactDuctilityUnitRenxiang;
    }

    public Double getMechComplianceUnitRouliang() {
        return mechComplianceUnitRouliang;
    }

    public void setMechComplianceUnitRouliang(Double mechComplianceUnitRouliang) {
        this.mechComplianceUnitRouliang = mechComplianceUnitRouliang;
    }

    public Double getBeginMechComplianceUnitRouliang() {
        return beginMechComplianceUnitRouliang;
    }

    public void setBeginMechComplianceUnitRouliang(Double beginMechComplianceUnitRouliang) {
        this.beginMechComplianceUnitRouliang = beginMechComplianceUnitRouliang;
    }

    public Double getEndMechComplianceUnitRouliang() {
        return endMechComplianceUnitRouliang;
    }

    public void setEndMechComplianceUnitRouliang(Double endMechComplianceUnitRouliang) {
        this.endMechComplianceUnitRouliang = endMechComplianceUnitRouliang;
    }
}
