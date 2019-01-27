package com.ahau.entity.system.log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 实体类：（日志表）
 * Created by: zhangli
 */
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    /* 操作人地址 */
    private String optUrl;
    /* 操作人登录名 */
    private String optUser;
    /* 操作时间 */
    private String optTime;
    /* 操作时间（查询上限）*/
    private String beginOptTime;
    /* 操作时间（查询下限）*/
    private String endOptTime;
    /* 日志类型 */
    private byte logType;
    /* 日志类型（查询上限）*/
    private byte beginLogType;
    /* 日志类型（查询下限）*/
    private byte endLogType;
    /* 操作系统 */
    private String optSystem;
    /* 操作浏览器 */
    private String optBrowser;
    /* 操作IP地址 */
    private String optIp;
    /* 操作设备物理地址 */
    private String optMac;
    /* 执行时间 */
    private Integer executeTime;
    /* 执行时间（查询上限）*/
    private Integer beginExecuteTime;
    /* 执行时间（查询下限）*/
    private Integer endExecuteTime;
    /* 操作描述 */
    private String optDesc;
    /* 请求参数 */
    private String requestParam;
    /* 操作来源 1-后台 2-android端 3-ios端 */
    private byte logResource;
    /* 操作来源 1-后台 2-android端 3-ios端（查询上限）*/
    private byte beginLogResource;
    /* 操作来源 1-后台 2-android端 3-ios端（查询下限）*/
    private byte endLogResource;
    /* 异常信息 */
    private String exceptionDetail;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getOptUrl() {
        return optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }

    public String getBeginOptTime() {
        return beginOptTime;
    }

    public void setBeginOptTime(String beginOptTime) {
        this.beginOptTime = beginOptTime;
    }

    public String getEndOptTime() {
        return endOptTime;
    }

    public void setEndOptTime(String endOptTime) {
        this.endOptTime = endOptTime;
    }

    public byte getLogType() {
        return logType;
    }

    public void setLogType(byte logType) {
        this.logType = logType;
    }

    public byte getBeginLogType() {
        return beginLogType;
    }

    public void setBeginLogType(byte beginLogType) {
        this.beginLogType = beginLogType;
    }

    public byte getEndLogType() {
        return endLogType;
    }

    public void setEndLogType(byte endLogType) {
        this.endLogType = endLogType;
    }

    public String getOptSystem() {
        return optSystem;
    }

    public void setOptSystem(String optSystem) {
        this.optSystem = optSystem;
    }

    public String getOptBrowser() {
        return optBrowser;
    }

    public void setOptBrowser(String optBrowser) {
        this.optBrowser = optBrowser;
    }

    public String getOptIp() {
        return optIp;
    }

    public void setOptIp(String optIp) {
        this.optIp = optIp;
    }

    public String getOptMac() {
        return optMac;
    }

    public void setOptMac(String optMac) {
        this.optMac = optMac;
    }

    public Integer getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Integer executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getBeginExecuteTime() {
        return beginExecuteTime;
    }

    public void setBeginExecuteTime(Integer beginExecuteTime) {
        this.beginExecuteTime = beginExecuteTime;
    }

    public Integer getEndExecuteTime() {
        return endExecuteTime;
    }

    public void setEndExecuteTime(Integer endExecuteTime) {
        this.endExecuteTime = endExecuteTime;
    }

    public String getOptDesc() {
        return optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public byte getLogResource() {
        return logResource;
    }

    public void setLogResource(byte logResource) {
        this.logResource = logResource;
    }

    public byte getBeginLogResource() {
        return beginLogResource;
    }

    public void setBeginLogResource(byte beginLogResource) {
        this.beginLogResource = beginLogResource;
    }

    public byte getEndLogResource() {
        return endLogResource;
    }

    public void setEndLogResource(byte endLogResource) {
        this.endLogResource = endLogResource;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", optUrl='" + optUrl + '\'' +
                ", optUser='" + optUser + '\'' +
                ", optTime='" + optTime + '\'' +
                ", beginOptTime='" + beginOptTime + '\'' +
                ", endOptTime='" + endOptTime + '\'' +
                ", logType=" + logType +
                ", beginLogType=" + beginLogType +
                ", endLogType=" + endLogType +
                ", optSystem='" + optSystem + '\'' +
                ", optBrowser='" + optBrowser + '\'' +
                ", optIp='" + optIp + '\'' +
                ", optMac='" + optMac + '\'' +
                ", executeTime=" + executeTime +
                ", beginExecuteTime=" + beginExecuteTime +
                ", endExecuteTime=" + endExecuteTime +
                ", optDesc='" + optDesc + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", logResource=" + logResource +
                ", beginLogResource=" + beginLogResource +
                ", endLogResource=" + endLogResource +
                ", exceptionDetail='" + exceptionDetail + '\'' +
                '}';
    }
}
