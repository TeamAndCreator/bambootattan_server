package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（结构性质表）
 * created by: 张理
 * 2018-10-26 20：00
 */
@Entity
public class StructureTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 胸高处的秆径 */
    private Double stStemDiameterUnitMm;
    /* 胸高处的秆径（查询上限） */
    private Double beginStStemDiameterUnitMm;
    /* 胸高处的秆径（查询下限） */
    private Double endStStemDiameterUnitMm;
    /* 竹筒壁厚 */
    private Double stWallThicknessUnitMm;
    /* 竹筒壁厚（查询上限） */
    private Double beginStWallThicknessUnitMm;
    /* 竹筒壁厚（查询下限） */
    private Double endStWallThicknessUnitMm;
    /* 最长节间长 */
    private Double stMaximumInternodeLengthUnitCm;
    /* 最长节间长（查询上限） */
    private Double beginStMaximumInternodeLengthUnitCm;
    /* 最长节间长（查询下限） */
    private Double endStMaximumInternodeLengthUnitCm;
    /* 2m处的藤径(mm) */
    private Double stRattanDiameterUnitMm;
    /* 2m处的藤径(mm)（查询上限） */
    private Double beginStRattanDiameterUnitMm;
    /* 2m处的藤径(mm)（查询下限） */
    private Double endStRattanDiameterUnitMm;
}
