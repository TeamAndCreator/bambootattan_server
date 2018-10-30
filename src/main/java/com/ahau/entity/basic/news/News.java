package com.ahau.entity.basic.news;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 实体类：（news）
 * created by: 张理
 * 2018-10-30 21：27
 */
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 新闻来源 */
    private String newsSource;
    /* 新闻标题 */
    private String newsTitle;
    /* 新闻图片 */
    private String newsPict;
    /* 新闻摘要 */
    private String newsSummaey;
    /* 新闻内容 */
    private String newsContent;
    /* 排序 */
    private String orderBy;
    /* 添加人 */
    private String addUser;
    /* 添加时间 */
    private java.util.Date addTime;
    /* 添加时间（查询上限） */
    private java.util.Date beginAddTime;
    /* 添加时间（查询下限） */
    private java.util.Date endAddTime;
    /* 浏览量 */
    private Long readCount;
    /* 浏览量（查询上限） */
    private Long beginReadCount;
    /* 浏览量（查询下限） */
    private Long endReadCount;
    /* 新闻类型 1-工会动态 */
    private Integer newsType;
    /* 新闻类型 1-工会动态（查询上限） */
    private Integer beginNewsType;
    /* 新闻类型 1-工会动态（查询下限） */
    private Integer endNewsType;

    private String addUserName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsPict() {
        return newsPict;
    }

    public void setNewsPict(String newsPict) {
        this.newsPict = newsPict;
    }

    public String getNewsSummaey() {
        return newsSummaey;
    }

    public void setNewsSummaey(String newsSummaey) {
        this.newsSummaey = newsSummaey;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
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

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getBeginReadCount() {
        return beginReadCount;
    }

    public void setBeginReadCount(Long beginReadCount) {
        this.beginReadCount = beginReadCount;
    }

    public Long getEndReadCount() {
        return endReadCount;
    }

    public void setEndReadCount(Long endReadCount) {
        this.endReadCount = endReadCount;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Integer getBeginNewsType() {
        return beginNewsType;
    }

    public void setBeginNewsType(Integer beginNewsType) {
        this.beginNewsType = beginNewsType;
    }

    public Integer getEndNewsType() {
        return endNewsType;
    }

    public void setEndNewsType(Integer endNewsType) {
        this.endNewsType = endNewsType;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }
}
