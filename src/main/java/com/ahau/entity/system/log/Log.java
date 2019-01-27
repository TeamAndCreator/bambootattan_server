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
    /* 操作IP地址 */
    private String optIp;
    /* 请求参数 */
    private String requestParam;
    /* 类方法 */
    private String classMethod;

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

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", optUrl='" + optUrl + '\'' +
                ", optUser='" + optUser + '\'' +
                ", optTime='" + optTime + '\'' +
                ", optIp='" + optIp + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", classMethod='" + classMethod + '\'' +
                '}';
    }
}