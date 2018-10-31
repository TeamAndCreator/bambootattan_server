package com.ahau.entity.basic.news;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * 实体类：（news）
 * created by: 张理
 * 2018-10-30 21：27
 */
@Entity
@Table(name = "aau_basic_news_table", schema = "bambootattan", catalog = "")
public class News {
    private String newsId;
    private String newsSource;
    private String newsTitle;
    private String newsPict;
    private String newsSummaey;
    private String newsContent;
    private String orderBy;
    private String addUser;
    private Timestamp addTime;
    private long readCount;
    private byte newsType;

    @Id
    @Column(name = "NEWS_ID")
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "NEWS_SOURCE")
    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    @Basic
    @Column(name = "NEWS_TITLE")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "NEWS_PICT")
    public String getNewsPict() {
        return newsPict;
    }

    public void setNewsPict(String newsPict) {
        this.newsPict = newsPict;
    }

    @Basic
    @Column(name = "NEWS_SUMMAEY")
    public String getNewsSummaey() {
        return newsSummaey;
    }

    public void setNewsSummaey(String newsSummaey) {
        this.newsSummaey = newsSummaey;
    }

    @Basic
    @Column(name = "NEWS_CONTENT")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
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
    @Column(name = "ADD_USER")
    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
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
    @Column(name = "READ_COUNT")
    public long getReadCount() {
        return readCount;
    }

    public void setReadCount(long readCount) {
        this.readCount = readCount;
    }

    @Basic
    @Column(name = "NEWS_TYPE")
    public byte getNewsType() {
        return newsType;
    }

    public void setNewsType(byte newsType) {
        this.newsType = newsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News that = (News) o;
        return readCount == that.readCount &&
                newsType == that.newsType &&
                Objects.equals(newsId, that.newsId) &&
                Objects.equals(newsSource, that.newsSource) &&
                Objects.equals(newsTitle, that.newsTitle) &&
                Objects.equals(newsPict, that.newsPict) &&
                Objects.equals(newsSummaey, that.newsSummaey) &&
                Objects.equals(newsContent, that.newsContent) &&
                Objects.equals(orderBy, that.orderBy) &&
                Objects.equals(addUser, that.addUser) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsSource, newsTitle, newsPict, newsSummaey, newsContent, orderBy, addUser, addTime, readCount, newsType);
    }
}
