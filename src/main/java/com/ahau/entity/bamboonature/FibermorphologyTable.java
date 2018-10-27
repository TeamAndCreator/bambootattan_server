package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *实体类：（解剖性质_纤维形态特征表）
 * created by: 张理
 * 2018-10-26 22：00
 */
@Entity
public class FibermorphologyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 外键：种标识 */
    private String specId;
    /* 外键：种标识（模糊查询） */
    private String specIdLike;
    /* 纤维长度 */
    private Double fmLengthUnitMicron;
    /* 纤维长度（查询上限） */
    private Double beginFmLengthUnitMicron;
    /* 纤维长度（查询下限） */
    private Double endFmLengthUnitMicron;
    /* 纤维宽度 */
    private Double fmWidthUnitMicron;
    /* 纤维宽度（查询上限） */
    private Double beginFmWidthUnitMicron;
    /* 纤维宽度（查询下限） */
    private Double endFmWidthUnitMicron;
    /* 纤维双壁厚 */
    private Double fmDwallThicknessUnitMicron;
    /* 纤维双壁厚（查询上限） */
    private Double beginFmDwallThicknessUnitMicron;
    /* 纤维双壁厚（查询下限） */
    private Double endFmDwallThicknessUnitMicron;
    /* 纤维长宽比 */
    private Double fmLetWidthRatio;
    /* 纤维长宽比（查询上限） */
    private Double beginFmLetWidthRatio;
    /* 纤维长宽比（查询下限） */
    private Double endFmLetWidthRatio;
    /* 纤维腔径 */
    private Double fmCavityDeameterUnitMicrom;
    /* 纤维腔径（查询上限） */
    private Double beginFmCavityDeameterUnitMicrom;
    /* 纤维腔径（查询下限） */
    private Double endFmCavityDeameterUnitMicrom;
    /* 纤维壁腔比 */
    private Double fmWallCavityRatio;
    /* 纤维壁腔比（查询上限） */
    private Double beginFmWallCavityRatio;
    /* 纤维壁腔比（查询下限） */
    private Double endFmWallCavityRatio;
    /* 纤维腔径比 */
    private Double fmCavityDiameterRatio;
    /* 纤维腔径比（查询上限） */
    private Double beginFmCavityDiameterRatio;
    /* 纤维腔径比（查询下限） */
    private Double endFmCavityDiameterRatio;

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

    public Double getFmLengthUnitMicron() {
        return fmLengthUnitMicron;
    }

    public void setFmLengthUnitMicron(Double fmLengthUnitMicron) {
        this.fmLengthUnitMicron = fmLengthUnitMicron;
    }

    public Double getBeginFmLengthUnitMicron() {
        return beginFmLengthUnitMicron;
    }

    public void setBeginFmLengthUnitMicron(Double beginFmLengthUnitMicron) {
        this.beginFmLengthUnitMicron = beginFmLengthUnitMicron;
    }

    public Double getEndFmLengthUnitMicron() {
        return endFmLengthUnitMicron;
    }

    public void setEndFmLengthUnitMicron(Double endFmLengthUnitMicron) {
        this.endFmLengthUnitMicron = endFmLengthUnitMicron;
    }

    public Double getFmWidthUnitMicron() {
        return fmWidthUnitMicron;
    }

    public void setFmWidthUnitMicron(Double fmWidthUnitMicron) {
        this.fmWidthUnitMicron = fmWidthUnitMicron;
    }

    public Double getBeginFmWidthUnitMicron() {
        return beginFmWidthUnitMicron;
    }

    public void setBeginFmWidthUnitMicron(Double beginFmWidthUnitMicron) {
        this.beginFmWidthUnitMicron = beginFmWidthUnitMicron;
    }

    public Double getEndFmWidthUnitMicron() {
        return endFmWidthUnitMicron;
    }

    public void setEndFmWidthUnitMicron(Double endFmWidthUnitMicron) {
        this.endFmWidthUnitMicron = endFmWidthUnitMicron;
    }

    public Double getFmDwallThicknessUnitMicron() {
        return fmDwallThicknessUnitMicron;
    }

    public void setFmDwallThicknessUnitMicron(Double fmDwallThicknessUnitMicron) {
        this.fmDwallThicknessUnitMicron = fmDwallThicknessUnitMicron;
    }

    public Double getBeginFmDwallThicknessUnitMicron() {
        return beginFmDwallThicknessUnitMicron;
    }

    public void setBeginFmDwallThicknessUnitMicron(Double beginFmDwallThicknessUnitMicron) {
        this.beginFmDwallThicknessUnitMicron = beginFmDwallThicknessUnitMicron;
    }

    public Double getEndFmDwallThicknessUnitMicron() {
        return endFmDwallThicknessUnitMicron;
    }

    public void setEndFmDwallThicknessUnitMicron(Double endFmDwallThicknessUnitMicron) {
        this.endFmDwallThicknessUnitMicron = endFmDwallThicknessUnitMicron;
    }

    public Double getFmLetWidthRatio() {
        return fmLetWidthRatio;
    }

    public void setFmLetWidthRatio(Double fmLetWidthRatio) {
        this.fmLetWidthRatio = fmLetWidthRatio;
    }

    public Double getBeginFmLetWidthRatio() {
        return beginFmLetWidthRatio;
    }

    public void setBeginFmLetWidthRatio(Double beginFmLetWidthRatio) {
        this.beginFmLetWidthRatio = beginFmLetWidthRatio;
    }

    public Double getEndFmLetWidthRatio() {
        return endFmLetWidthRatio;
    }

    public void setEndFmLetWidthRatio(Double endFmLetWidthRatio) {
        this.endFmLetWidthRatio = endFmLetWidthRatio;
    }

    public Double getFmCavityDeameterUnitMicrom() {
        return fmCavityDeameterUnitMicrom;
    }

    public void setFmCavityDeameterUnitMicrom(Double fmCavityDeameterUnitMicrom) {
        this.fmCavityDeameterUnitMicrom = fmCavityDeameterUnitMicrom;
    }

    public Double getBeginFmCavityDeameterUnitMicrom() {
        return beginFmCavityDeameterUnitMicrom;
    }

    public void setBeginFmCavityDeameterUnitMicrom(Double beginFmCavityDeameterUnitMicrom) {
        this.beginFmCavityDeameterUnitMicrom = beginFmCavityDeameterUnitMicrom;
    }

    public Double getEndFmCavityDeameterUnitMicrom() {
        return endFmCavityDeameterUnitMicrom;
    }

    public void setEndFmCavityDeameterUnitMicrom(Double endFmCavityDeameterUnitMicrom) {
        this.endFmCavityDeameterUnitMicrom = endFmCavityDeameterUnitMicrom;
    }

    public Double getFmWallCavityRatio() {
        return fmWallCavityRatio;
    }

    public void setFmWallCavityRatio(Double fmWallCavityRatio) {
        this.fmWallCavityRatio = fmWallCavityRatio;
    }

    public Double getBeginFmWallCavityRatio() {
        return beginFmWallCavityRatio;
    }

    public void setBeginFmWallCavityRatio(Double beginFmWallCavityRatio) {
        this.beginFmWallCavityRatio = beginFmWallCavityRatio;
    }

    public Double getEndFmWallCavityRatio() {
        return endFmWallCavityRatio;
    }

    public void setEndFmWallCavityRatio(Double endFmWallCavityRatio) {
        this.endFmWallCavityRatio = endFmWallCavityRatio;
    }

    public Double getFmCavityDiameterRatio() {
        return fmCavityDiameterRatio;
    }

    public void setFmCavityDiameterRatio(Double fmCavityDiameterRatio) {
        this.fmCavityDiameterRatio = fmCavityDiameterRatio;
    }

    public Double getBeginFmCavityDiameterRatio() {
        return beginFmCavityDiameterRatio;
    }

    public void setBeginFmCavityDiameterRatio(Double beginFmCavityDiameterRatio) {
        this.beginFmCavityDiameterRatio = beginFmCavityDiameterRatio;
    }

    public Double getEndFmCavityDiameterRatio() {
        return endFmCavityDiameterRatio;
    }

    public void setEndFmCavityDiameterRatio(Double endFmCavityDiameterRatio) {
        this.endFmCavityDiameterRatio = endFmCavityDiameterRatio;
    }
}
