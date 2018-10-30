package com.ahau.entity.websitevideo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 实体类：（上传视频存放地）
 * created by: 张理
 * 2018-10-29 10：30
 */
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 视频名称 */
    private String videoTitle;
    /* 视频名称（模糊查询）*/
    private String videoTitleLike;
    /* 文件名称 */
    private String fileName;
    /* 文件名称（模糊查询）*/
    private String fileNameLike;
    /* 视频截图 */
    private String videoPicture;
    /* 视频截图（模糊查询）*/
    private String videoPictureLike;
    /* 视频描述 */
    private String videoDesc;
    /* 视频描述（模糊查询）*/
    private String videoDescLike;
    /* 是否有效  1-有效 2-无效 */
    private Integer displayFlag;
    /* 是否有效  1-有效 2-无效（查询上限）*/
    private Integer beginDisplayFlag;
    /* 是否有效  1-有效 2-无效（查询下限）*/
    private Integer endDisplayFlag;
    /* 视频上传时间 */
    private java.util.Date videoUptime;
    /* 视频上传时间（查询上限）*/
    private java.util.Date beginVideoUptime;
    /* 视频上传时间（查询下限）*/
    private java.util.Date endVideoUptime;
    /* 关联项目的id */
    private String loanId;
    /* 关联项目的id（模糊查询）*/
    private String loanIdLike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoTitleLike() {
        return videoTitleLike;
    }

    public void setVideoTitleLike(String videoTitleLike) {
        this.videoTitleLike = videoTitleLike;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameLike() {
        return fileNameLike;
    }

    public void setFileNameLike(String fileNameLike) {
        this.fileNameLike = fileNameLike;
    }

    public String getVideoPicture() {
        return videoPicture;
    }

    public void setVideoPicture(String videoPicture) {
        this.videoPicture = videoPicture;
    }

    public String getVideoPictureLike() {
        return videoPictureLike;
    }

    public void setVideoPictureLike(String videoPictureLike) {
        this.videoPictureLike = videoPictureLike;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoDescLike() {
        return videoDescLike;
    }

    public void setVideoDescLike(String videoDescLike) {
        this.videoDescLike = videoDescLike;
    }

    public Integer getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(Integer displayFlag) {
        this.displayFlag = displayFlag;
    }

    public Integer getBeginDisplayFlag() {
        return beginDisplayFlag;
    }

    public void setBeginDisplayFlag(Integer beginDisplayFlag) {
        this.beginDisplayFlag = beginDisplayFlag;
    }

    public Integer getEndDisplayFlag() {
        return endDisplayFlag;
    }

    public void setEndDisplayFlag(Integer endDisplayFlag) {
        this.endDisplayFlag = endDisplayFlag;
    }

    public Date getVideoUptime() {
        return videoUptime;
    }

    public void setVideoUptime(Date videoUptime) {
        this.videoUptime = videoUptime;
    }

    public Date getBeginVideoUptime() {
        return beginVideoUptime;
    }

    public void setBeginVideoUptime(Date beginVideoUptime) {
        this.beginVideoUptime = beginVideoUptime;
    }

    public Date getEndVideoUptime() {
        return endVideoUptime;
    }

    public void setEndVideoUptime(Date endVideoUptime) {
        this.endVideoUptime = endVideoUptime;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanIdLike() {
        return loanIdLike;
    }

    public void setLoanIdLike(String loanIdLike) {
        this.loanIdLike = loanIdLike;
    }
}
