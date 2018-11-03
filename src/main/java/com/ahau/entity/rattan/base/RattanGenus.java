package com.ahau.entity.rattan.base;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（属表）
 * Created by: 张理
 * 2018-11-1 14：14
 */
@Entity
public class RattanGenus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genusId; //属标识

    /* 中文名称 */
    private String genusNameCh;

    /* 英文名称 */
    private String genusNameEn;

    /* 拉丁名称 */
    private String genusNameLd;

    /* 别名 */
    private String genusNameOth;

    /* 描述 */
    @Column(length = 100000)
    private String genusDesc;

    /* 排序序号 */
    private Integer sortNum;

    public Long getGenusId() {
        return genusId;
    }

    public void setGenusId(Long genusId) {
        this.genusId = genusId;
    }

    public String getGenusNameCh() {
        return genusNameCh;
    }

    public void setGenusNameCh(String genusNameCh) {
        this.genusNameCh = genusNameCh;
    }

    public String getGenusNameEn() {
        return genusNameEn;
    }

    public void setGenusNameEn(String genusNameEn) {
        this.genusNameEn = genusNameEn;
    }

    public String getGenusNameLd() {
        return genusNameLd;
    }

    public void setGenusNameLd(String genusNameLd) {
        this.genusNameLd = genusNameLd;
    }

    public String getGenusNameOth() {
        return genusNameOth;
    }

    public void setGenusNameOth(String genusNameOth) {
        this.genusNameOth = genusNameOth;
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

    @Override
    public String toString() {
        return "RattanGenus{" +
                "genusId=" + genusId +
                ", genusNameCh='" + genusNameCh + '\'' +
                ", genusNameEn='" + genusNameEn + '\'' +
                ", genusNameLd='" + genusNameLd + '\'' +
                ", genusNameOth='" + genusNameOth + '\'' +
                ", genusDesc='" + genusDesc + '\'' +
                ", sortNum=" + sortNum +
                '}';
    }
}
