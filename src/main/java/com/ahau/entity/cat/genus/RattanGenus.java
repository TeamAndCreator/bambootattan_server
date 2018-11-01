package com.ahau.entity.cat.genus;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（属表）
 * Created by: 张理
 * 2018-11-1 14：14
 */
@Entity
@Table(name = "aau_cat_rattangenus_table", schema = "bambootattan", catalog = "")
public class RattanGenus {
    private String genusId;
    private String genusNameCh;
    private String genusNameEn;
    private String genusNameLd;
    private String genusNameOth;
    private String genusDesc;
    private int sortNum;

    @Id
    @Column(name = "GENUS_ID")
    public String getGenusId() {
        return genusId;
    }

    public void setGenusId(String genusId) {
        this.genusId = genusId;
    }

    @Basic
    @Column(name = "GENUS_NAME_CH")
    public String getGenusNameCh() {
        return genusNameCh;
    }

    public void setGenusNameCh(String genusNameCh) {
        this.genusNameCh = genusNameCh;
    }

    @Basic
    @Column(name = "GENUS_NAME_EN")
    public String getGenusNameEn() {
        return genusNameEn;
    }

    public void setGenusNameEn(String genusNameEn) {
        this.genusNameEn = genusNameEn;
    }

    @Basic
    @Column(name = "GENUS_NAME_LD")
    public String getGenusNameLd() {
        return genusNameLd;
    }

    public void setGenusNameLd(String genusNameLd) {
        this.genusNameLd = genusNameLd;
    }

    @Basic
    @Column(name = "GENUS_NAME_OTH")
    public String getGenusNameOth() {
        return genusNameOth;
    }

    public void setGenusNameOth(String genusNameOth) {
        this.genusNameOth = genusNameOth;
    }

    @Basic
    @Column(name = "GENUS_DESC")
    public String getGenusDesc() {
        return genusDesc;
    }

    public void setGenusDesc(String genusDesc) {
        this.genusDesc = genusDesc;
    }

    @Basic
    @Column(name = "SORT_NUM")
    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RattanGenus that = (RattanGenus) o;
        return sortNum == that.sortNum &&
                Objects.equals(genusId, that.genusId) &&
                Objects.equals(genusNameCh, that.genusNameCh) &&
                Objects.equals(genusNameEn, that.genusNameEn) &&
                Objects.equals(genusNameLd, that.genusNameLd) &&
                Objects.equals(genusNameOth, that.genusNameOth) &&
                Objects.equals(genusDesc, that.genusDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genusId, genusNameCh, genusNameEn, genusNameLd, genusNameOth, genusDesc, sortNum);
    }
}
