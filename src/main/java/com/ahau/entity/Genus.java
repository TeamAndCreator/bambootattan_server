package com.ahau.entity;

public class Genus {
    /* 中文名称 */
    private String genusNameCh;
    /* 中文名称（模糊查询） */
    private String genusNameChLike;
    /* 英文名称 */
    private String genusNameEn;
    /* 英文名称（模糊查询） */
    private String genusNameEnLike;
    /* 拉丁名称 */
    private String genusNameLd;
    /* 拉丁名称（模糊查询） */
    private String genusNameLdLike;
    /* 别名 */
    private String genusNameOth;
    /* 别名（模糊查询） */
    private String genusNameOthLike;
    /* 描述 */
    private String genusDesc;
    /* 排序序号 */
    private Integer sortNum;
    /* 排序序号（查询上限） */
    private Integer beginSortNum;
    /* 排序序号（查询下限） */
    private Integer endSortNum;

    public String getGenusNameCh() {
        return genusNameCh;
    }

    public void setGenusNameCh(String genusNameCh) {
        this.genusNameCh = genusNameCh;
    }

    public String getGenusNameChLike() {
        return genusNameChLike;
    }

    public void setGenusNameChLike(String genusNameChLike) {
        this.genusNameChLike = genusNameChLike;
    }

    public String getGenusNameEn() {
        return genusNameEn;
    }

    public void setGenusNameEn(String genusNameEn) {
        this.genusNameEn = genusNameEn;
    }

    public String getGenusNameEnLike() {
        return genusNameEnLike;
    }

    public void setGenusNameEnLike(String genusNameEnLike) {
        this.genusNameEnLike = genusNameEnLike;
    }

    public String getGenusNameLd() {
        return genusNameLd;
    }

    public void setGenusNameLd(String genusNameLd) {
        this.genusNameLd = genusNameLd;
    }

    public String getGenusNameLdLike() {
        return genusNameLdLike;
    }

    public void setGenusNameLdLike(String genusNameLdLike) {
        this.genusNameLdLike = genusNameLdLike;
    }

    public String getGenusNameOth() {
        return genusNameOth;
    }

    public void setGenusNameOth(String genusNameOth) {
        this.genusNameOth = genusNameOth;
    }

    public String getGenusNameOthLike() {
        return genusNameOthLike;
    }

    public void setGenusNameOthLike(String genusNameOthLike) {
        this.genusNameOthLike = genusNameOthLike;
    }

    public String getGenusDesc() {
        return genusDesc;
    }

    public void setGenusDesc(String genusDesc) {
        this.genusDesc = genusDesc;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getBeginSortNum() {
        return beginSortNum;
    }

    public void setBeginSortNum(Integer beginSortNum) {
        this.beginSortNum = beginSortNum;
    }

    public Integer getEndSortNum() {
        return endSortNum;
    }

    public void setEndSortNum(Integer endSortNum) {
        this.endSortNum = endSortNum;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "genusNameCh='" + genusNameCh + '\'' +
                ", genusNameChLike='" + genusNameChLike + '\'' +
                ", genusNameEn='" + genusNameEn + '\'' +
                ", genusNameEnLike='" + genusNameEnLike + '\'' +
                ", genusNameLd='" + genusNameLd + '\'' +
                ", genusNameLdLike='" + genusNameLdLike + '\'' +
                ", genusNameOth='" + genusNameOth + '\'' +
                ", genusNameOthLike='" + genusNameOthLike + '\'' +
                ", genusDesc='" + genusDesc + '\'' +
                ", sortNum=" + sortNum +
                ", beginSortNum=" + beginSortNum +
                ", endSortNum=" + endSortNum +
                '}';
    }
}
