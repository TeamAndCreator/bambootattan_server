package com.ahau.entity.system.log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


/**
 * 实体类：（日志表）
 * Created by: zhangli
 */
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    /* 操作 */
    private String optUrl;
    /* 操作人登录名 */
    private String optUser;
    /* 操作时间 */
    @org.hibernate.annotations.CreationTimestamp  //由数据库自动创建时间
    //private Timestamp optTime;
    private Date optTime;
    /* 操作IP地址 */
    private String optIp;
    /* 请求参数 */
    private String requestParam;
    /* 类方法 */
    private String classMethod;
    /* 查询时间上限 */
    private String startTime;
    /* 查询时间下限 */
    private String endTime;

    public Log(){
        this.optUrl=optUrl;
        this.optUser=optUser;
        this.optTime=optTime;
        this.optIp=optIp;
        this.requestParam=requestParam;
        this.classMethod=classMethod;
    }

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

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getOptIp() {
        return optIp;
    }

    public void setOptIp(String optIp) {
        this.optIp = optIp;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", optUrl='" + optUrl + '\'' +
                ", optUser='" + optUser + '\'' +
                ", optTime=" + optTime +
                ", optIp='" + optIp + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}