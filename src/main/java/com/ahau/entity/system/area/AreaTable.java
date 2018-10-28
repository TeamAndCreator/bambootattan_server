package com.ahau.entity.system.area;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * 实体类：（行政区域）
 */
@Entity
public class AreaTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;

    /* 所属编号 */
    private String parArearId;
    /* 名称 */
    private String areaName;
    /* 行政区域简称 */
    private String shortName;
    /* 拼音索引 */
    private String areaIndex;
    /* 简介 */
    private String areaDescr;
    /* 排序序号 */
    private String orderBy;
    /*父区域名称*/
    private String parAreaName;

//    private List<AreaTable> sonArea;需改错

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParArearId() {
        return parArearId;
    }

    public void setParArearId(String parArearId) {
        this.parArearId = parArearId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAreaIndex() {
        return areaIndex;
    }

    public void setAreaIndex(String areaIndex) {
        this.areaIndex = areaIndex;
    }

    public String getAreaDescr() {
        return areaDescr;
    }

    public void setAreaDescr(String areaDescr) {
        this.areaDescr = areaDescr;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getParAreaName() {
        return parAreaName;
    }

    public void setParAreaName(String parAreaName) {
        this.parAreaName = parAreaName;
    }

//    public List<AreaTable> getSonArea() {
//        return sonArea;
//    }
//
//    public void setSonArea(List<AreaTable> sonArea) {
//        this.sonArea = sonArea;
//    }
}
