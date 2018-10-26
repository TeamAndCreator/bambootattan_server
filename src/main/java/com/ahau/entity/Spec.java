package com.ahau.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（种表）
 * Created by 张理
 * 2018-10-26 15：00
 */
@Entity
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* 属标识 */
    private String genusId;
    private String genusName;
    /* 属标识（模糊查询）*/
    private String genusIdLike;
    /* 中文名称 */
    private String specNameCh;
    /* 中文名称（模糊查询） */
    private String specNameChLike;
    /* 英文名称 */
    private String specNameEn;
    /* 英文名称（模糊查询） */
    private String specNameEnLike;
    /* 拉丁名称 */
    private String specNameLd;
    /* 拉丁名称（模糊查询） */
    private String specNameLdLike;
    /* 种别名 */
    private String specNameOth;
    /* 种别名（模糊查询） */
    private String specNameOthLike;
    /* 种类编码 */
    private String specCode;
    /* 种类编码（模糊查询） */
    private String specCodeLike;
    /* 种类条形码 */
    private String specBarCode;
    /* 种类条形码（模糊查询） */
    private String specBarCodeLike;
    /* 种类DNA码 */
    private String specDna;
    /* 种类DNA码（模糊查询） */
    private String specDnaLike;
    /* 国内分布 */
    private String specDomestic;
    /* 国内分布（模糊查询） */
    private String specDomesticLike;
    /* 国外分布 */
    private String specForeign;
    /* 国外分布（模糊查询） */
    private String specForeignLike;
    /* 视频 */
    private String specVidio;
    private String specVidioName;
    /* 视频（模糊查询） */
    private String specVidioLike;
    /* 图片 */
    private String specImgs;
    /* 图片（模糊查询） */
    private String specImgsLike;
    /* 种描述 */
    private String specDesc;
    /* 排序序号 */
    private Integer specSortNum;
    /* 排序序号（查询上限） */
    private Integer beginSpecSortNum;
    /* 排序序号（查询下限） */
    private Integer endSpecSortNum;
    // 额外的es 属
    private String genusAll;
    // 物理性质
    private String physicsAll;
    // 化学性质
    private String chemistryAll;
    // 力学性质
    private String mechanicsAll;
    // 解剖性质
    private String planeAll;
    // 结构性质
    private String structureAll;
    // 竹种形态
    private String boomFormAll;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenusId() {
        return genusId;
    }

    public void setGenusId(String genusId) {
        this.genusId = genusId;
    }

    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public String getGenusIdLike() {
        return genusIdLike;
    }

    public void setGenusIdLike(String genusIdLike) {
        this.genusIdLike = genusIdLike;
    }

    public String getSpecNameCh() {
        return specNameCh;
    }

    public void setSpecNameCh(String specNameCh) {
        this.specNameCh = specNameCh;
    }

    public String getSpecNameChLike() {
        return specNameChLike;
    }

    public void setSpecNameChLike(String specNameChLike) {
        this.specNameChLike = specNameChLike;
    }

    public String getSpecNameEn() {
        return specNameEn;
    }

    public void setSpecNameEn(String specNameEn) {
        this.specNameEn = specNameEn;
    }

    public String getSpecNameEnLike() {
        return specNameEnLike;
    }

    public void setSpecNameEnLike(String specNameEnLike) {
        this.specNameEnLike = specNameEnLike;
    }

    public String getSpecNameLd() {
        return specNameLd;
    }

    public void setSpecNameLd(String specNameLd) {
        this.specNameLd = specNameLd;
    }

    public String getSpecNameLdLike() {
        return specNameLdLike;
    }

    public void setSpecNameLdLike(String specNameLdLike) {
        this.specNameLdLike = specNameLdLike;
    }

    public String getSpecNameOth() {
        return specNameOth;
    }

    public void setSpecNameOth(String specNameOth) {
        this.specNameOth = specNameOth;
    }

    public String getSpecNameOthLike() {
        return specNameOthLike;
    }

    public void setSpecNameOthLike(String specNameOthLike) {
        this.specNameOthLike = specNameOthLike;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecCodeLike() {
        return specCodeLike;
    }

    public void setSpecCodeLike(String specCodeLike) {
        this.specCodeLike = specCodeLike;
    }

    public String getSpecBarCode() {
        return specBarCode;
    }

    public void setSpecBarCode(String specBarCode) {
        this.specBarCode = specBarCode;
    }

    public String getSpecBarCodeLike() {
        return specBarCodeLike;
    }

    public void setSpecBarCodeLike(String specBarCodeLike) {
        this.specBarCodeLike = specBarCodeLike;
    }

    public String getSpecDna() {
        return specDna;
    }

    public void setSpecDna(String specDna) {
        this.specDna = specDna;
    }

    public String getSpecDnaLike() {
        return specDnaLike;
    }

    public void setSpecDnaLike(String specDnaLike) {
        this.specDnaLike = specDnaLike;
    }

    public String getSpecDomestic() {
        return specDomestic;
    }

    public void setSpecDomestic(String specDomestic) {
        this.specDomestic = specDomestic;
    }

    public String getSpecDomesticLike() {
        return specDomesticLike;
    }

    public void setSpecDomesticLike(String specDomesticLike) {
        this.specDomesticLike = specDomesticLike;
    }

    public String getSpecForeign() {
        return specForeign;
    }

    public void setSpecForeign(String specForeign) {
        this.specForeign = specForeign;
    }

    public String getSpecForeignLike() {
        return specForeignLike;
    }

    public void setSpecForeignLike(String specForeignLike) {
        this.specForeignLike = specForeignLike;
    }

    public String getSpecVidio() {
        return specVidio;
    }

    public void setSpecVidio(String specVidio) {
        this.specVidio = specVidio;
    }

    public String getSpecVidioName() {
        return specVidioName;
    }

    public void setSpecVidioName(String specVidioName) {
        this.specVidioName = specVidioName;
    }

    public String getSpecVidioLike() {
        return specVidioLike;
    }

    public void setSpecVidioLike(String specVidioLike) {
        this.specVidioLike = specVidioLike;
    }

    public String getSpecImgs() {
        return specImgs;
    }

    public void setSpecImgs(String specImgs) {
        this.specImgs = specImgs;
    }

    public String getSpecImgsLike() {
        return specImgsLike;
    }

    public void setSpecImgsLike(String specImgsLike) {
        this.specImgsLike = specImgsLike;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }

    public Integer getSpecSortNum() {
        return specSortNum;
    }

    public void setSpecSortNum(Integer specSortNum) {
        this.specSortNum = specSortNum;
    }

    public Integer getBeginSpecSortNum() {
        return beginSpecSortNum;
    }

    public void setBeginSpecSortNum(Integer beginSpecSortNum) {
        this.beginSpecSortNum = beginSpecSortNum;
    }

    public Integer getEndSpecSortNum() {
        return endSpecSortNum;
    }

    public void setEndSpecSortNum(Integer endSpecSortNum) {
        this.endSpecSortNum = endSpecSortNum;
    }

    public String getGenusAll() {
        return genusAll;
    }

    public void setGenusAll(String genusAll) {
        this.genusAll = genusAll;
    }

    public String getPhysicsAll() {
        return physicsAll;
    }

    public void setPhysicsAll(String physicsAll) {
        this.physicsAll = physicsAll;
    }

    public String getChemistryAll() {
        return chemistryAll;
    }

    public void setChemistryAll(String chemistryAll) {
        this.chemistryAll = chemistryAll;
    }

    public String getMechanicsAll() {
        return mechanicsAll;
    }

    public void setMechanicsAll(String mechanicsAll) {
        this.mechanicsAll = mechanicsAll;
    }

    public String getPlaneAll() {
        return planeAll;
    }

    public void setPlaneAll(String planeAll) {
        this.planeAll = planeAll;
    }

    public String getStructureAll() {
        return structureAll;
    }

    public void setStructureAll(String structureAll) {
        this.structureAll = structureAll;
    }

    public String getBoomFormAll() {
        return boomFormAll;
    }

    public void setBoomFormAll(String boomFormAll) {
        this.boomFormAll = boomFormAll;
    }
}
