package com.ahau.entity.system.log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 实体类：（日志表）
 * created by: 张理
 * 2018-10-28 19：00
 */
@Entity
public class LogTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 操作人地址 */
    private String optUrl;
    /* 操作人登录名 */
    private String optUser;
    /* 操作时间 */
    private java.util.Date optTime;
    /* 操作时间（查询上限）*/
    private java.util.Date beginOptTime;
    /* 操作时间（查询下限）*/
    private java.util.Date endOptTime;
    /* 日志类型 */
    private Integer logType;
    /* 日志类型（查询上限）*/
    private Integer beginLogType;
    /* 日志类型（查询下限）*/
    private Integer endLogType;
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
    private Integer logResource;
    /* 操作来源 1-后台 2-android端 3-ios端（查询上限）*/
    private Integer beginLogResource;
    /* 操作来源 1-后台 2-android端 3-ios端（查询下限）*/
    private Integer endLogResource;
    /* 异常信息 */
    private String exceptionDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Date getBeginOptTime() {
        return beginOptTime;
    }

    public void setBeginOptTime(Date beginOptTime) {
        this.beginOptTime = beginOptTime;
    }

    public Date getEndOptTime() {
        return endOptTime;
    }

    public void setEndOptTime(Date endOptTime) {
        this.endOptTime = endOptTime;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getBeginLogType() {
        return beginLogType;
    }

    public void setBeginLogType(Integer beginLogType) {
        this.beginLogType = beginLogType;
    }

    public Integer getEndLogType() {
        return endLogType;
    }

    public void setEndLogType(Integer endLogType) {
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

    public Integer getLogResource() {
        return logResource;
    }

    public void setLogResource(Integer logResource) {
        this.logResource = logResource;
    }

    public Integer getBeginLogResource() {
        return beginLogResource;
    }

    public void setBeginLogResource(Integer beginLogResource) {
        this.beginLogResource = beginLogResource;
    }

    public Integer getEndLogResource() {
        return endLogResource;
    }

    public void setEndLogResource(Integer endLogResource) {
        this.endLogResource = endLogResource;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }
}
