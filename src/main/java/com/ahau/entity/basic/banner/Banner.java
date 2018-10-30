package com.ahau.entity.basic.banner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 实体类：（Banner）
 * created by: 张理
 * 2018-10-30 21：10
 */
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 标题 */
    private String bannerTitle;
    /* 图片地址 */
    private String bannerIcon;
    /* 排序 */
    private String orderBy;
    /*  */
    private String bannerUrl;
    /* 可用标记 1-可用 2-不可用 */
    private Integer bannerFlag;
    /* 可用标记 1-可用 2-不可用（查询上限）*/
    private Integer beginBannerFlag;
    /* 可用标记 1-可用 2-不可用（查询下限）*/
    private Integer endBannerFlag;
    /*  */
    private java.util.Date addTime;
    /* （查询上限）*/
    private java.util.Date beginAddTime;
    /* （查询下限）*/
    private java.util.Date endAddTime;
    /* 类型 1-首页Banner 2-欢迎页 */
    private Integer bannerType;
    /* 类型 1-首页Banner 2-欢迎页（查询上限）*/
    private Integer beginBannerType;
    /* 类型 1-首页Banner 2-欢迎页（查询下限）*/
    private Integer endBannerType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerIcon() {
        return bannerIcon;
    }

    public void setBannerIcon(String bannerIcon) {
        this.bannerIcon = bannerIcon;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getBannerFlag() {
        return bannerFlag;
    }

    public void setBannerFlag(Integer bannerFlag) {
        this.bannerFlag = bannerFlag;
    }

    public Integer getBeginBannerFlag() {
        return beginBannerFlag;
    }

    public void setBeginBannerFlag(Integer beginBannerFlag) {
        this.beginBannerFlag = beginBannerFlag;
    }

    public Integer getEndBannerFlag() {
        return endBannerFlag;
    }

    public void setEndBannerFlag(Integer endBannerFlag) {
        this.endBannerFlag = endBannerFlag;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getBeginAddTime() {
        return beginAddTime;
    }

    public void setBeginAddTime(Date beginAddTime) {
        this.beginAddTime = beginAddTime;
    }

    public Date getEndAddTime() {
        return endAddTime;
    }

    public void setEndAddTime(Date endAddTime) {
        this.endAddTime = endAddTime;
    }

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Integer getBeginBannerType() {
        return beginBannerType;
    }

    public void setBeginBannerType(Integer beginBannerType) {
        this.beginBannerType = beginBannerType;
    }

    public Integer getEndBannerType() {
        return endBannerType;
    }

    public void setEndBannerType(Integer endBannerType) {
        this.endBannerType = endBannerType;
    }
}
