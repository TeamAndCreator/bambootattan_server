package com.ahau.entity.system.log;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 实体类：（日志表）
 * created by: 张理
 * 2018-10-28 19：00
 */
@Entity
@Table(name = "aau_system_log_table", schema = "bambootattan", catalog = "")
public class LogTable {
    private String logId;
    private String optUrl;
    private String optUser;
    private Timestamp optTime;
    private byte logType;
    private String optSystem;
    private String optBrowser;
    private String optIp;
    private String optMac;
    private Integer executeTime;
    private String optDesc;
    private String requestParam;
    private byte logResource;
    private String exceptionDetail;

    @Id
    @Column(name = "LOG_ID")
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "OPT_URL")
    public String getOptUrl() {
        return optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    @Basic
    @Column(name = "OPT_USER")
    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    @Basic
    @Column(name = "OPT_TIME")
    public Timestamp getOptTime() {
        return optTime;
    }

    public void setOptTime(Timestamp optTime) {
        this.optTime = optTime;
    }

    @Basic
    @Column(name = "LOG_TYPE")
    public byte getLogType() {
        return logType;
    }

    public void setLogType(byte logType) {
        this.logType = logType;
    }

    @Basic
    @Column(name = "OPT_SYSTEM")
    public String getOptSystem() {
        return optSystem;
    }

    public void setOptSystem(String optSystem) {
        this.optSystem = optSystem;
    }

    @Basic
    @Column(name = "OPT_BROWSER")
    public String getOptBrowser() {
        return optBrowser;
    }

    public void setOptBrowser(String optBrowser) {
        this.optBrowser = optBrowser;
    }

    @Basic
    @Column(name = "OPT_IP")
    public String getOptIp() {
        return optIp;
    }

    public void setOptIp(String optIp) {
        this.optIp = optIp;
    }

    @Basic
    @Column(name = "OPT_MAC")
    public String getOptMac() {
        return optMac;
    }

    public void setOptMac(String optMac) {
        this.optMac = optMac;
    }

    @Basic
    @Column(name = "EXECUTE_TIME")
    public Integer getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Integer executeTime) {
        this.executeTime = executeTime;
    }

    @Basic
    @Column(name = "OPT_DESC")
    public String getOptDesc() {
        return optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

    @Basic
    @Column(name = "REQUEST_PARAM")
    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    @Basic
    @Column(name = "LOG_RESOURCE")
    public byte getLogResource() {
        return logResource;
    }

    public void setLogResource(byte logResource) {
        this.logResource = logResource;
    }

    @Basic
    @Column(name = "EXCEPTION_DETAIL")
    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogTable that = (LogTable) o;
        return logType == that.logType &&
                logResource == that.logResource &&
                Objects.equals(logId, that.logId) &&
                Objects.equals(optUrl, that.optUrl) &&
                Objects.equals(optUser, that.optUser) &&
                Objects.equals(optTime, that.optTime) &&
                Objects.equals(optSystem, that.optSystem) &&
                Objects.equals(optBrowser, that.optBrowser) &&
                Objects.equals(optIp, that.optIp) &&
                Objects.equals(optMac, that.optMac) &&
                Objects.equals(executeTime, that.executeTime) &&
                Objects.equals(optDesc, that.optDesc) &&
                Objects.equals(requestParam, that.requestParam) &&
                Objects.equals(exceptionDetail, that.exceptionDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, optUrl, optUser, optTime, logType, optSystem, optBrowser, optIp, optMac, executeTime, optDesc, requestParam, logResource, exceptionDetail);
    }
}
