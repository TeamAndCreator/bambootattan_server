package com.ahau.entity.cat.spec;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（种表）
 * Created by: 张理
 * 2018-11-1 14：21
 */
@Entity
@Table(name = "aau_cat_rattanspec_table", schema = "bambootattan", catalog = "")
public class RattanSpec {
    private String specId;
    private String genusId;
    private String specNameCh;
    private String specNameEn;
    private String specNameLd;
    private String specNameOth;
    private String specCode;
    private String specBarCode;
    private String specDna;
    private String specDomestic;
    private String specForeign;
    private String specVidio;
    private String specImgs;
    private String specDesc;
    private int specSortNum;

    @Id
    @Column(name = "SPEC_ID")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "GENUS_ID")
    public String getGenusId() {
        return genusId;
    }

    public void setGenusId(String genusId) {
        this.genusId = genusId;
    }

    @Basic
    @Column(name = "SPEC_NAME_CH")
    public String getSpecNameCh() {
        return specNameCh;
    }

    public void setSpecNameCh(String specNameCh) {
        this.specNameCh = specNameCh;
    }

    @Basic
    @Column(name = "SPEC_NAME_EN")
    public String getSpecNameEn() {
        return specNameEn;
    }

    public void setSpecNameEn(String specNameEn) {
        this.specNameEn = specNameEn;
    }

    @Basic
    @Column(name = "SPEC_NAME_LD")
    public String getSpecNameLd() {
        return specNameLd;
    }

    public void setSpecNameLd(String specNameLd) {
        this.specNameLd = specNameLd;
    }

    @Basic
    @Column(name = "SPEC_NAME_OTH")
    public String getSpecNameOth() {
        return specNameOth;
    }

    public void setSpecNameOth(String specNameOth) {
        this.specNameOth = specNameOth;
    }

    @Basic
    @Column(name = "SPEC_CODE")
    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    @Basic
    @Column(name = "SPEC_BAR_CODE")
    public String getSpecBarCode() {
        return specBarCode;
    }

    public void setSpecBarCode(String specBarCode) {
        this.specBarCode = specBarCode;
    }

    @Basic
    @Column(name = "SPEC_DNA")
    public String getSpecDna() {
        return specDna;
    }

    public void setSpecDna(String specDna) {
        this.specDna = specDna;
    }

    @Basic
    @Column(name = "SPEC_DOMESTIC")
    public String getSpecDomestic() {
        return specDomestic;
    }

    public void setSpecDomestic(String specDomestic) {
        this.specDomestic = specDomestic;
    }

    @Basic
    @Column(name = "SPEC_FOREIGN")
    public String getSpecForeign() {
        return specForeign;
    }

    public void setSpecForeign(String specForeign) {
        this.specForeign = specForeign;
    }

    @Basic
    @Column(name = "SPEC_VIDIO")
    public String getSpecVidio() {
        return specVidio;
    }

    public void setSpecVidio(String specVidio) {
        this.specVidio = specVidio;
    }

    @Basic
    @Column(name = "SPEC_IMGS")
    public String getSpecImgs() {
        return specImgs;
    }

    public void setSpecImgs(String specImgs) {
        this.specImgs = specImgs;
    }

    @Basic
    @Column(name = "SPEC_DESC")
    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }

    @Basic
    @Column(name = "SPEC_SORT_NUM")
    public int getSpecSortNum() {
        return specSortNum;
    }

    public void setSpecSortNum(int specSortNum) {
        this.specSortNum = specSortNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RattanSpec that = (RattanSpec) o;
        return specSortNum == that.specSortNum &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(genusId, that.genusId) &&
                Objects.equals(specNameCh, that.specNameCh) &&
                Objects.equals(specNameEn, that.specNameEn) &&
                Objects.equals(specNameLd, that.specNameLd) &&
                Objects.equals(specNameOth, that.specNameOth) &&
                Objects.equals(specCode, that.specCode) &&
                Objects.equals(specBarCode, that.specBarCode) &&
                Objects.equals(specDna, that.specDna) &&
                Objects.equals(specDomestic, that.specDomestic) &&
                Objects.equals(specForeign, that.specForeign) &&
                Objects.equals(specVidio, that.specVidio) &&
                Objects.equals(specImgs, that.specImgs) &&
                Objects.equals(specDesc, that.specDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specId, genusId, specNameCh, specNameEn, specNameLd, specNameOth, specCode, specBarCode, specDna, specDomestic, specForeign, specVidio, specImgs, specDesc, specSortNum);
    }
}
