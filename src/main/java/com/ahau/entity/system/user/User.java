package com.ahau.entity.system.user;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 实体类：（系统用户）
 * created by: 张理
 * 2018-10-29 10：10
 */
@Entity
@Table(name = "aau_system_user_table", schema = "bambootattan", catalog = "")
public class User {
    private String userId;
    private String userAcct;
    private String userName;
    private String userPwd;
    private byte activeFlag;
    private String dftTheme;
    private Timestamp createTime;
    private byte pcOnlineFlag;
    private Byte errCount;
    private Timestamp errTime;
    private String jpushRegId;
    private String orgName;
    private String orgPhone;

    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_ACCT")
    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PWD")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "ACTIVE_FLAG")
    public byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Basic
    @Column(name = "DFT_THEME")
    public String getDftTheme() {
        return dftTheme;
    }

    public void setDftTheme(String dftTheme) {
        this.dftTheme = dftTheme;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "PC_ONLINE_FLAG")
    public byte getPcOnlineFlag() {
        return pcOnlineFlag;
    }

    public void setPcOnlineFlag(byte pcOnlineFlag) {
        this.pcOnlineFlag = pcOnlineFlag;
    }

    @Basic
    @Column(name = "ERR_COUNT")
    public Byte getErrCount() {
        return errCount;
    }

    public void setErrCount(Byte errCount) {
        this.errCount = errCount;
    }

    @Basic
    @Column(name = "ERR_TIME")
    public Timestamp getErrTime() {
        return errTime;
    }

    public void setErrTime(Timestamp errTime) {
        this.errTime = errTime;
    }

    @Basic
    @Column(name = "JPUSH_REG_ID")
    public String getJpushRegId() {
        return jpushRegId;
    }

    public void setJpushRegId(String jpushRegId) {
        this.jpushRegId = jpushRegId;
    }

    @Basic
    @Column(name = "ORG_NAME")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ORG_PHONE")
    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return activeFlag == that.activeFlag &&
                pcOnlineFlag == that.pcOnlineFlag &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userAcct, that.userAcct) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPwd, that.userPwd) &&
                Objects.equals(dftTheme, that.dftTheme) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(errCount, that.errCount) &&
                Objects.equals(errTime, that.errTime) &&
                Objects.equals(jpushRegId, that.jpushRegId) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(orgPhone, that.orgPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userAcct, userName, userPwd, activeFlag, dftTheme, createTime, pcOnlineFlag, errCount, errTime, jpushRegId, orgName, orgPhone);
    }
}
