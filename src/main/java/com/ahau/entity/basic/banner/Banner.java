package com.ahau.entity.basic.banner;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * 实体类：（Banner）
 * created by: 张理
 * 2018-10-30 21：10
 */
@Entity
@Table(name = "aau_basic_banner_table", schema = "bambootattan", catalog = "")
public class Banner {
    private String bannerId;
    private String bannerTitle;
    private String bannerIcon;
    private String orderBy;
    private String bannerUrl;
    private byte bannerFlag;
    private Timestamp addTime;
    private byte bannerType;

    @Id
    @Column(name = "BANNER_ID")
    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    @Basic
    @Column(name = "BANNER_TITLE")
    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    @Basic
    @Column(name = "BANNER_ICON")
    public String getBannerIcon() {
        return bannerIcon;
    }

    public void setBannerIcon(String bannerIcon) {
        this.bannerIcon = bannerIcon;
    }

    @Basic
    @Column(name = "ORDER_BY")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Basic
    @Column(name = "BANNER_URL")
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @Basic
    @Column(name = "BANNER_FLAG")
    public byte getBannerFlag() {
        return bannerFlag;
    }

    public void setBannerFlag(byte bannerFlag) {
        this.bannerFlag = bannerFlag;
    }

    @Basic
    @Column(name = "ADD_TIME")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "BANNER_TYPE")
    public byte getBannerType() {
        return bannerType;
    }

    public void setBannerType(byte bannerType) {
        this.bannerType = bannerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner that = (Banner) o;
        return bannerFlag == that.bannerFlag &&
                bannerType == that.bannerType &&
                Objects.equals(bannerId, that.bannerId) &&
                Objects.equals(bannerTitle, that.bannerTitle) &&
                Objects.equals(bannerIcon, that.bannerIcon) &&
                Objects.equals(orderBy, that.orderBy) &&
                Objects.equals(bannerUrl, that.bannerUrl) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bannerId, bannerTitle, bannerIcon, orderBy, bannerUrl, bannerFlag, addTime, bannerType);
    }
}
