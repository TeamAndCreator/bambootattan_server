package com.ahau.entity.unit;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（单位表）
 * Created by: 张理
 * 2018-11-1 17：01
 */
@Entity
@Table(name = "aau_unit_table", schema = "bambootattan", catalog = "")
public class UnitTable {
    private String unitId;
    private String unitEnglish;
    private String unitSymbol;
    private String unitSymbolOther;

    @Id
    @Column(name = "UNIT_ID")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "UNIT_ENGLISH")
    public String getUnitEnglish() {
        return unitEnglish;
    }

    public void setUnitEnglish(String unitEnglish) {
        this.unitEnglish = unitEnglish;
    }

    @Basic
    @Column(name = "UNIT_SYMBOL")
    public String getUnitSymbol() {
        return unitSymbol;
    }

    public void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    @Basic
    @Column(name = "UNIT_SYMBOL_OTHER")
    public String getUnitSymbolOther() {
        return unitSymbolOther;
    }

    public void setUnitSymbolOther(String unitSymbolOther) {
        this.unitSymbolOther = unitSymbolOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitTable that = (UnitTable) o;
        return Objects.equals(unitId, that.unitId) &&
                Objects.equals(unitEnglish, that.unitEnglish) &&
                Objects.equals(unitSymbol, that.unitSymbol) &&
                Objects.equals(unitSymbolOther, that.unitSymbolOther);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitId, unitEnglish, unitSymbol, unitSymbolOther);
    }
}
