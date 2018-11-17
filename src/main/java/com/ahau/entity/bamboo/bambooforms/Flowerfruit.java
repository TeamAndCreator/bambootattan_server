package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;

/**
 * 实体类：（花果形态表）
 * Created by: 张理
 * 2018-11-2 16：59
 */
@Entity
public class Flowerfruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long floFruitId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 小穗形态 */
    private String spikeletShape;

    /* 小穗被毛 */
    private String spikeletBack;

    /* 小穗含花朵数 */
    private String spikeletFloret;

    /* 雄蕊数目 */
    private String stamenNum;

    /* 颖片 */
    private String glume;

    /* 鳞被 */
    private String lodicule;

    /* 内稃 */
    private String palea;

    /* 外稃 */
    private String lemma;

    public Long getFloFruitId() {
        return floFruitId;
    }

    public void setFloFruitId(Long floFruitId) {
        this.floFruitId = floFruitId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getSpikeletShape() {
        return spikeletShape;
    }

    public void setSpikeletShape(String spikeletShape) {
        this.spikeletShape = spikeletShape;
    }

    public String getSpikeletBack() {
        return spikeletBack;
    }

    public void setSpikeletBack(String spikeletBack) {
        this.spikeletBack = spikeletBack;
    }

    public String getSpikeletFloret() {
        return spikeletFloret;
    }

    public void setSpikeletFloret(String spikeletFloret) {
        this.spikeletFloret = spikeletFloret;
    }

    public String getStamenNum() {
        return stamenNum;
    }

    public void setStamenNum(String stamenNum) {
        this.stamenNum = stamenNum;
    }

    public String getGlume() {
        return glume;
    }

    public void setGlume(String glume) {
        this.glume = glume;
    }

    public String getLodicule() {
        return lodicule;
    }

    public void setLodicule(String lodicule) {
        this.lodicule = lodicule;
    }

    public String getPalea() {
        return palea;
    }

    public void setPalea(String palea) {
        this.palea = palea;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    @Override
    public String toString() {
        return "Flowerfruit{" +
                "floFruitId=" + floFruitId +
                ", spec=" + spec +
                ", spikeletShape='" + spikeletShape + '\'' +
                ", spikeletBack='" + spikeletBack + '\'' +
                ", spikeletFloret='" + spikeletFloret + '\'' +
                ", stamenNum='" + stamenNum + '\'' +
                ", glume='" + glume + '\'' +
                ", lodicule='" + lodicule + '\'' +
                ", palea='" + palea + '\'' +
                ", lemma='" + lemma + '\'' +
                '}';
    }
}
