package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（地下茎表）
 * Created by: 张理
 * 2018-10-26 15：10
 */
@Entity
public class UnderstemTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 地下茎类型 */
    private String underStem;
    /* 地下茎类型（模糊查询） */
    private String underStemLike;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUnderStem() {
        return underStem;
    }

    public void setUnderStem(String underStem) {
        this.underStem = underStem;
    }

    public String getUnderStemLike() {
        return underStemLike;
    }

    public void setUnderStemLike(String underStemLike) {
        this.underStemLike = underStemLike;
    }
}
