package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（花果形态表）
 * created by: 张理
 * 2018-10-26 19：30
 */
@Entity
public class FlowerfruitTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 小穗形态 */
    private String spikeletShape;
    /* 小穗形态（模糊查询） */
    private String spikeletShapeLike;
    /* 小穗被毛 */
    private String spikeletBack;
    /* 小穗被毛（模糊查询） */
    private String spikeletBackLike;
    /* 小穗含花朵数 */
    private String spikeletFloret;
    /* 小穗含花朵数（模糊查询） */
    private String spikeletFloretLike;
    /* 雄蕊数目 */
    private String stamenNum;
    /* 雄蕊数目（模糊查询） */
    private String stamenNumLike;
    /* 颖片 */
    private String glume;
    /* 颖片（模糊查询） */
    private String glumeLike;
    /* 鳞被 */
    private String lodicule;
    /* 鳞被（模糊查询） */
    private String lodiculeLike;
    /* 内稃 */
    private String palea;
    /* 内稃（模糊查询） */
    private String paleaLike;
    /* 外稃 */
    private String lemma;
    /* 外稃（模糊查询） */
    private String lemmaLike;
}
