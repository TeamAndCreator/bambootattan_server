package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（花果形态表）
 * created by: 张理
 * 2018-10-26 19：30
 */
@Entity
@Table(name = "aau_bam_flowerfruit_table", schema = "bambootattan", catalog = "")
public class FlowerfruitTable {
    private String floFruitId;
    private String specId;
    private String spikeletShape;
    private String spikeletBack;
    private String spikeletFloret;
    private String stamenNum;
    private String glume;
    private String lodicule;
    private String palea;
    private String lemma;

    @Id
    @Column(name = "FLO_FRUIT_ID")
    public String getFloFruitId() {
        return floFruitId;
    }

    public void setFloFruitId(String floFruitId) {
        this.floFruitId = floFruitId;
    }

    @Basic
    @Column(name = "SPEC_ID")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "SPIKELET_SHAPE")
    public String getSpikeletShape() {
        return spikeletShape;
    }

    public void setSpikeletShape(String spikeletShape) {
        this.spikeletShape = spikeletShape;
    }

    @Basic
    @Column(name = "SPIKELET_BACK")
    public String getSpikeletBack() {
        return spikeletBack;
    }

    public void setSpikeletBack(String spikeletBack) {
        this.spikeletBack = spikeletBack;
    }

    @Basic
    @Column(name = "SPIKELET_FLORET")
    public String getSpikeletFloret() {
        return spikeletFloret;
    }

    public void setSpikeletFloret(String spikeletFloret) {
        this.spikeletFloret = spikeletFloret;
    }

    @Basic
    @Column(name = "STAMEN_NUM")
    public String getStamenNum() {
        return stamenNum;
    }

    public void setStamenNum(String stamenNum) {
        this.stamenNum = stamenNum;
    }

    @Basic
    @Column(name = "GLUME")
    public String getGlume() {
        return glume;
    }

    public void setGlume(String glume) {
        this.glume = glume;
    }

    @Basic
    @Column(name = "LODICULE")
    public String getLodicule() {
        return lodicule;
    }

    public void setLodicule(String lodicule) {
        this.lodicule = lodicule;
    }

    @Basic
    @Column(name = "PALEA")
    public String getPalea() {
        return palea;
    }

    public void setPalea(String palea) {
        this.palea = palea;
    }

    @Basic
    @Column(name = "LEMMA")
    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerfruitTable that = (FlowerfruitTable) o;
        return Objects.equals(floFruitId, that.floFruitId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(spikeletShape, that.spikeletShape) &&
                Objects.equals(spikeletBack, that.spikeletBack) &&
                Objects.equals(spikeletFloret, that.spikeletFloret) &&
                Objects.equals(stamenNum, that.stamenNum) &&
                Objects.equals(glume, that.glume) &&
                Objects.equals(lodicule, that.lodicule) &&
                Objects.equals(palea, that.palea) &&
                Objects.equals(lemma, that.lemma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floFruitId, specId, spikeletShape, spikeletBack, spikeletFloret, stamenNum, glume, lodicule, palea, lemma);
    }
}
