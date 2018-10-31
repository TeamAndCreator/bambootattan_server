package com.ahau.entity.system.area;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（行政区域）
 * Created by: 张理
 * 2018-10-31 19：00
 */
@Entity
@Table(name = "aau_system_area_table", schema = "bambootattan", catalog = "")
public class AreaTable {
    private String areaId;
    private String parArearId;
    private String areaName;
    private String shortName;
    private String areaIndex;
    private String areaDescr;
    private String orderBy;

    @Id
    @Column(name = "AREA_ID")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "PAR_AREAR_ID")
    public String getParArearId() {
        return parArearId;
    }

    public void setParArearId(String parArearId) {
        this.parArearId = parArearId;
    }

    @Basic
    @Column(name = "AREA_NAME")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "SHORT_NAME")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "AREA_INDEX")
    public String getAreaIndex() {
        return areaIndex;
    }

    public void setAreaIndex(String areaIndex) {
        this.areaIndex = areaIndex;
    }

    @Basic
    @Column(name = "AREA_DESCR")
    public String getAreaDescr() {
        return areaDescr;
    }

    public void setAreaDescr(String areaDescr) {
        this.areaDescr = areaDescr;
    }

    @Basic
    @Column(name = "ORDER_BY")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaTable that = (AreaTable) o;
        return Objects.equals(areaId, that.areaId) &&
                Objects.equals(parArearId, that.parArearId) &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(areaIndex, that.areaIndex) &&
                Objects.equals(areaDescr, that.areaDescr) &&
                Objects.equals(orderBy, that.orderBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, parArearId, areaName, shortName, areaIndex, areaDescr, orderBy);
    }
}
