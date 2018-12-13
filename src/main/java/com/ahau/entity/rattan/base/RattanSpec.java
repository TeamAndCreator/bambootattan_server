package com.ahau.entity.rattan.base;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.file.Files;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 实体类：（种表）
 * Created by: 张理
 * 2018-11-1 14：21
 */
@Entity
public class RattanSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specId; //种标识

    /* 属标识 */
    @ManyToOne
    @JoinColumn(name = "genus_id")
    private RattanGenus rattanGenus;

    /* 文件上传 */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Files> files=new HashSet<Files>();

    /* 中文名称 */
    private String specNameCh;

    /* 英文名称 */
    private String specNameEn;

    /* 拉丁名称 */
    private String specNameLd;

    /* 种别名 */
    private String specNameOth;

    /* 种类编码 */
    private String specCode;

    /* 种类条形码 */
    private String specBarCode;

    /* 种类DNA码 */
    private String specDna;

    /* 国内分布 */
    private String specDomestic;

    /* 国外分布 */
    private String specForeign;

    /* 视频 */
    private String specVidio;

    /* 图片 */
    private String specImgs;

    /* 种描述 */
    private String specDesc;

    /* 排序序号 */
    private int specSortNum;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public RattanGenus getRattanGenus() {
        return rattanGenus;
    }

    public void setRattanGenus(RattanGenus rattanGenus) {
        this.rattanGenus = rattanGenus;
    }

    public Set<Files> getFiles() {
        return files;
    }

    public void setFiles(Set<Files> files) {
        this.files = files;
    }

    public String getSpecNameCh() {
        return specNameCh;
    }

    public void setSpecNameCh(String specNameCh) {
        this.specNameCh = specNameCh;
    }

    public String getSpecNameEn() {
        return specNameEn;
    }

    public void setSpecNameEn(String specNameEn) {
        this.specNameEn = specNameEn;
    }

    public String getSpecNameLd() {
        return specNameLd;
    }

    public void setSpecNameLd(String specNameLd) {
        this.specNameLd = specNameLd;
    }

    public String getSpecNameOth() {
        return specNameOth;
    }

    public void setSpecNameOth(String specNameOth) {
        this.specNameOth = specNameOth;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecBarCode() {
        return specBarCode;
    }

    public void setSpecBarCode(String specBarCode) {
        this.specBarCode = specBarCode;
    }

    public String getSpecDna() {
        return specDna;
    }

    public void setSpecDna(String specDna) {
        this.specDna = specDna;
    }

    public String getSpecDomestic() {
        return specDomestic;
    }

    public void setSpecDomestic(String specDomestic) {
        this.specDomestic = specDomestic;
    }

    public String getSpecForeign() {
        return specForeign;
    }

    public void setSpecForeign(String specForeign) {
        this.specForeign = specForeign;
    }

    public String getSpecVidio() {
        return specVidio;
    }

    public void setSpecVidio(String specVidio) {
        this.specVidio = specVidio;
    }

    public String getSpecImgs() {
        return specImgs;
    }

    public void setSpecImgs(String specImgs) {
        this.specImgs = specImgs;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }

    public int getSpecSortNum() {
        return specSortNum;
    }

    public void setSpecSortNum(int specSortNum) {
        this.specSortNum = specSortNum;
    }

    @Override
    public String toString() {
        return "RattanSpec{" +
                "specId=" + specId +
                ", rattanGenus=" + rattanGenus +
                ", files=" + files +
                ", specNameCh='" + specNameCh + '\'' +
                ", specNameEn='" + specNameEn + '\'' +
                ", specNameLd='" + specNameLd + '\'' +
                ", specNameOth='" + specNameOth + '\'' +
                ", specCode='" + specCode + '\'' +
                ", specBarCode='" + specBarCode + '\'' +
                ", specDna='" + specDna + '\'' +
                ", specDomestic='" + specDomestic + '\'' +
                ", specForeign='" + specForeign + '\'' +
                ", specVidio='" + specVidio + '\'' +
                ", specImgs='" + specImgs + '\'' +
                ", specDesc='" + specDesc + '\'' +
                ", specSortNum=" + specSortNum +
                '}';
    }
}
