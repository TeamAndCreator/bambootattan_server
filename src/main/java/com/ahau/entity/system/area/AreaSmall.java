package com.ahau.entity.system.area;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 实体类：（行政区域）
 * created by: 张理
 * 2018-10-28 18：00
 */
@Entity
public class AreaSmall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 所属编号 */
    private String parArearId;
    /* 名称 */
    private String areaName;

//    private List<AreaSmall> sonArea;

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

//    public List<AreaSmall> getSonArea() {
//        return sonArea;
//    }
//
//    public void setSonArea(List<AreaSmall> sonArea) {
//        this.sonArea = sonArea;
//    }
}
