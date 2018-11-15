package com.ahau.entity.websitevideo;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

/**
 * 实体类：（上传视频存放地）
 * @author 张理
 * 2018-11-15
 */
@Entity
public class WebsiteVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    /* 视频名称 */
    private String videoTitle;

    /* 文件名称 */
    private String fileName;

    /* 视频截图 */
    private String videoPicture;

    /* 视频描述 */
    private String videoDesc;

    /* 是否有效  1-有效 2-无效 */
    private Byte displayFlag;

    /* 视频上传时间 */
    private Timestamp videoUptime;

    /* 关联项目的id */
    private String loanId;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVideoPicture() {
        return videoPicture;
    }

    public void setVideoPicture(String videoPicture) {
        this.videoPicture = videoPicture;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public Byte getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(Byte displayFlag) {
        this.displayFlag = displayFlag;
    }

    public Timestamp getVideoUptime() {
        return videoUptime;
    }

    public void setVideoUptime(Timestamp videoUptime) {
        this.videoUptime = videoUptime;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    @Override
    public String toString() {
        return "WebsiteVideo{" +
                "videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", fileName='" + fileName + '\'' +
                ", videoPicture='" + videoPicture + '\'' +
                ", videoDesc='" + videoDesc + '\'' +
                ", displayFlag=" + displayFlag +
                ", videoUptime=" + videoUptime +
                ", loanId='" + loanId + '\'' +
                '}';
    }
}
