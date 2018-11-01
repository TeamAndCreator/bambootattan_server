package com.ahau.entity.websitevideo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 实体类：（上传视频存放地）
 * created by: 张理
 * 2018-10-29 10：30
 */
@Entity
@Table(name = "aau_website_video_table", schema = "bambootattan", catalog = "")
public class Video {
    private String videoId;
    private String videoTitle;
    private String fileName;
    private String videoPicture;
    private String videoDesc;
    private Byte displayFlag;
    private Timestamp videoUptime;
    private String loanId;

    @Id
    @Column(name = "VIDEO_ID")
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "VIDEO_TITLE")
    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    @Basic
    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "VIDEO_PICTURE")
    public String getVideoPicture() {
        return videoPicture;
    }

    public void setVideoPicture(String videoPicture) {
        this.videoPicture = videoPicture;
    }

    @Basic
    @Column(name = "VIDEO_DESC")
    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    @Basic
    @Column(name = "DISPLAY_FLAG")
    public Byte getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(Byte displayFlag) {
        this.displayFlag = displayFlag;
    }

    @Basic
    @Column(name = "VIDEO_UPTIME")
    public Timestamp getVideoUptime() {
        return videoUptime;
    }

    public void setVideoUptime(Timestamp videoUptime) {
        this.videoUptime = videoUptime;
    }

    @Basic
    @Column(name = "LOAN_ID")
    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video that = (Video) o;
        return Objects.equals(videoId, that.videoId) &&
                Objects.equals(videoTitle, that.videoTitle) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(videoPicture, that.videoPicture) &&
                Objects.equals(videoDesc, that.videoDesc) &&
                Objects.equals(displayFlag, that.displayFlag) &&
                Objects.equals(videoUptime, that.videoUptime) &&
                Objects.equals(loanId, that.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, videoTitle, fileName, videoPicture, videoDesc, displayFlag, videoUptime, loanId);
    }
}
