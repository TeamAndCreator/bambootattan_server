package com.ahau.entity.bamboonature;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类（化学性质表）
 * created by: 张理
 * 2018-10-26 21：28
 */
@Entity
public class ChemistryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 综纤维素 */
    private Double chemHolocelluloseUnitPercent;
    /* 综纤维素（查询上限） */
    private Double beginChemHolocelluloseUnitPercent;
    /* 综纤维素（查询下限） */
    private Double endChemHolocelluloseUnitPercent;
    /* 纤维素 */
    private Double chemCelluloseUnitPercent;
    /* 纤维素（查询上限） */
    private Double beginChemCelluloseUnitPercent;
    /* 纤维素（查询下限） */
    private Double endChemCelluloseUnitPercent;
    /* 半纤维素 */
    private Double chemHemicelluloseUnitPercent;
    /* 半纤维素（查询上限） */
    private Double beginChemHemicelluloseUnitPercent;
    /* 半纤维素（查询下限） */
    private Double endChemHemicelluloseUnitPercent;
    /* a纤维素 */
    private Double chemACelluloseUnitPercent;
    /* a纤维素（查询上限） */
    private Double beginChemACelluloseUnitPercent;
    /* a纤维素（查询下限） */
    private Double endChemACelluloseUnitPercent;
    /* 酸不溶木质素 */
    private Double chemAcidInsolubleLigninUnitPercent;
    /* 酸不溶木质素（查询上限） */
    private Double beginChemAcidInsolubleLigninUnitPercent;
    /* 酸不溶木质素（查询下限） */
    private Double endChemAcidInsolubleLigninUnitPercent;
    /* 苯醇抽提物 */
    private Double chemBenzeneAlcoholExtractionUnitPercent;
    /* 苯醇抽提物（查询上限） */
    private Double beginChemBenzeneAlcoholExtractionUnitPercent;
    /* 苯醇抽提物（查询下限） */
    private Double endChemBenzeneAlcoholExtractionUnitPercent;
    /* 热水抽提物 */
    private Double chemHotWaterExtractionUnitPercent;
    /* 热水抽提物（查询上限） */
    private Double beginChemHotWaterExtractionUnitPercent;
    /* 热水抽提物（查询下限） */
    private Double endChemHotWaterExtractionUnitPercent;
    /* 冷抽提物 */
    private Double chemColdWaterExtractionUnitPercent;
    /* 冷抽提物（查询上限） */
    private Double beginChemColdWaterExtractionUnitPercent;
    /* 冷抽提物（查询下限） */
    private Double endChemColdWaterExtractionUnitPercent;
    /* 灰分 */
    private Double chemAshContentUnitPercent;
    /* 灰分（查询上限） */
    private Double beginChemAshContentUnitPercent;
    /* 灰分（查询下限） */
    private Double endChemAshContentUnitPercent;
}
