package com.ahau.entity.system.user;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 实体类：（系统用户）
 * Created by: 张理
 * 2018-12-13
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /* 登录账号 */
    private String userAcct;
    /* 用户姓名 */
    @JoinColumn(nullable = false,unique = true)
    private String userName;
    /* 登录密码 */
    private String userPwd;
    /* 是否有效 [1-有效 2-无效] */
    private byte activeFlag;
    /* 默认主题 */
    private String dftTheme;
    /* 创建时间 */
    private Timestamp createTime;
    /* pc是否在线 [1-在线 2-不在线] */
    private byte pcOnlineFlag;
    /* 登错次数 */
    private Byte errCount;
    /* 登错时间 */
    private Timestamp errTime;
    /* 极光推送设备标识 */
    private String jpushRegId;
    /* 所在部门 */
    private String orgName;
    /* 办公室电话 */
    private String orgPhone;
    /* 用户权限*/
    @ManyToMany
    private Set<Role> roles;
    /*激活码*/
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(byte activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getDftTheme() {
        return dftTheme;
    }

    public void setDftTheme(String dftTheme) {
        this.dftTheme = dftTheme;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public byte getPcOnlineFlag() {
        return pcOnlineFlag;
    }

    public void setPcOnlineFlag(byte pcOnlineFlag) {
        this.pcOnlineFlag = pcOnlineFlag;
    }

    public Byte getErrCount() {
        return errCount;
    }

    public void setErrCount(Byte errCount) {
        this.errCount = errCount;
    }

    public Timestamp getErrTime() {
        return errTime;
    }

    public void setErrTime(Timestamp errTime) {
        this.errTime = errTime;
    }

    public String getJpushRegId() {
        return jpushRegId;
    }

    public void setJpushRegId(String jpushRegId) {
        this.jpushRegId = jpushRegId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAcct='" + userAcct + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", activeFlag=" + activeFlag +
                ", dftTheme='" + dftTheme + '\'' +
                ", createTime=" + createTime +
                ", pcOnlineFlag=" + pcOnlineFlag +
                ", errCount=" + errCount +
                ", errTime=" + errTime +
                ", jpushRegId='" + jpushRegId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgPhone='" + orgPhone + '\'' +
                ", roles=" + roles +
                ", code='" + code + '\'' +
                '}';
    }
}
