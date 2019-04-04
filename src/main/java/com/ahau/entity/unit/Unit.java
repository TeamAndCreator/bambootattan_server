package com.ahau.entity.unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 描述：（单位表）
 * Created by: zhangli
 * 2019-4-4
 */
@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;

    /* 单位对应的英文名称 */
    private String unitEnglish;

    /* 显示名称 */
    private String unitSymbol;

    /* 备注 */
    private String unitSymbolOther;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitEnglish() {
        return unitEnglish;
    }

    public void setUnitEnglish(String unitEnglish) {
        this.unitEnglish = unitEnglish;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    public String getUnitSymbolOther() {
        return unitSymbolOther;
    }

    public void setUnitSymbolOther(String unitSymbolOther) {
        this.unitSymbolOther = unitSymbolOther;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", unitEnglish='" + unitEnglish + '\'' +
                ", unitSymbol='" + unitSymbol + '\'' +
                ", unitSymbolOther='" + unitSymbolOther + '\'' +
                '}';
    }
}
