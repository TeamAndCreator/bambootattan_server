package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（解剖性质_导管形态特征表）
 * created by: 张理
 * 2018-10-26 21：48
 */
@Entity
public class CathetermorphologyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种的标识 */
    private String specId;
    /* 种的标识（模糊查询） */
    private String specIdLike;
    /* 导管长度 */
    private Double chmCatheterLenghtUnitMicrom;
    /* 导管长度（查询上限） */
    private Double beginChmCatheterLenghtUnitMicrom;
    /* 导管长度（查询下限） */
    private Double endChmCatheterLenghtUnitMicrom;
    /* 导管直径 */
    private Double chmCatheterDiameterUnitMicrom;
    /* 导管直径（查询上限） */
    private Double beginChmCatheterDiameterUnitMicrom;
    /* 导管直径（查询下限） */
    private Double endChmCatheterDiameterUnitMicrom;
    /* 导管密度 */
    private Double chmCatheterDensityUnitVcmidu;
    /* 导管密度（查询上限） */
    private Double beginChmCatheterDensityUnitVcmidu;
    /* 导管密度（查询下限） */
    private Double endChmCatheterDensityUnitVcmidu;
    /* 导管形态指数 */
    private Double chmIndex;
    /* 导管形态指数（查询上限） */
    private Double beginChmIndex;
    /* 导管形态指数（查询下限） */
    private Double endChmIndex;
}
