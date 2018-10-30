package com.ahau.entity.system.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 实体类：（系统用户）
 * created by: 张理
 * 2018-10-29 10：10
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

//    public User() {
//        super();
//    }
//
//    public User(String id) {
//        super.setId(id);
//    }
//
//    private List<Role> roleList;
//    private Set<Path> pathSet;
//    /* userId IN 查询 */
//    private Set<String> userIdSet;
//
//    public Set<String> getRolesName() {
//        List<Role> roles = getRoleList();
//        Set<String> set = new HashSet<String>();
//        for (Role role : roles) {
//            set.add(role.getRoleName());
//        }
//        return set;
//    }
//
//    public List<Role> getRoleList() {
//        return roleList;
//    }
//
//    public void setRoleList(List<Role> roleList) {
//        this.roleList = roleList;
//    }
//
//    public Set<Path> getPathSet() {
//        return pathSet;
//    }
//
//    public void setPathSet(Set<Path> pathSet) {
//        this.pathSet = pathSet;
//    }
//
//    public Set<String> getUserIdSet() {
//        return userIdSet;
//    }
//
//    public void setUserIdSet(Set<String> userIdSet) {
//        this.userIdSet = userIdSet;
//    }
//
//    private static final long serialVersionUID = 1L;
//    public static final String TABLE_CACHE_PREFIX = "ANDJI_SYSTEM_USER_BASE-";
    /* 登录账号 */
    private String userAcct;
    /* 登录账号（模糊查询） */
    private String userAcctLike;
    /* 用户姓名 */
    private String userName;
    /* 用户姓名（模糊查询） */
    private String userNameLike;
    /* 登录密码 */
    private String userPwd;
    /* 登录密码（模糊查询） */
    private String userPwdLike;
    /* 是否有效 [1-有效 2-无效] */
    private Integer activeFlag;
    /* 是否有效 [1-有效 2-无效]（查询上限） */
    private Integer beginActiveFlag;
    /* 是否有效 [1-有效 2-无效]（查询下限） */
    private Integer endActiveFlag;
    /* 默认主题 */
    private String dftTheme;
    /* 默认主题（模糊查询） */
    private String dftThemeLike;
    /* 创建时间 */
    private java.util.Date createTime;
    /* 创建时间（查询上限） */
    private java.util.Date beginCreateTime;
    /* 创建时间（查询下限） */
    private java.util.Date endCreateTime;
    /* pc是否在线 [1-在线 2-不在线] */
    private Integer pcOnlineFlag;
    /* pc是否在线 [1-在线 2-不在线]（查询上限） */
    private Integer beginPcOnlineFlag;
    /* pc是否在线 [1-在线 2-不在线]（查询下限） */
    private Integer endPcOnlineFlag;
    /* 登错次数 */
    private Integer errCount;
    /* 登错次数（查询上限） */
    private Integer beginErrCount;
    /* 登错次数（查询下限） */
    private Integer endErrCount;
    /* 登错时间 */
    private java.util.Date errTime;
    /* 登错时间（查询上限） */
    private java.util.Date beginErrTime;
    /* 登错时间（查询下限） */
    private java.util.Date endErrTime;
    /* 极光推送设备标识 */
    private String jpushRegId;
    /* 极光推送设备标识（模糊查询） */
    private String jpushRegIdLike;
    /* 所在部门 */
    private String orgName;
    /* 所在部门（模糊查询） */
    private String orgNameLike;
    /* 办公室电话 */
    private String orgPhone;
    /* 办公室电话（模糊查询） */
    private String orgPhoneLike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserAcctLike() {
        return userAcctLike;
    }

    public void setUserAcctLike(String userAcctLike) {
        this.userAcctLike = userAcctLike;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameLike() {
        return userNameLike;
    }

    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwdLike() {
        return userPwdLike;
    }

    public void setUserPwdLike(String userPwdLike) {
        this.userPwdLike = userPwdLike;
    }

    public Integer getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Integer activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Integer getBeginActiveFlag() {
        return beginActiveFlag;
    }

    public void setBeginActiveFlag(Integer beginActiveFlag) {
        this.beginActiveFlag = beginActiveFlag;
    }

    public Integer getEndActiveFlag() {
        return endActiveFlag;
    }

    public void setEndActiveFlag(Integer endActiveFlag) {
        this.endActiveFlag = endActiveFlag;
    }

    public String getDftTheme() {
        return dftTheme;
    }

    public void setDftTheme(String dftTheme) {
        this.dftTheme = dftTheme;
    }

    public String getDftThemeLike() {
        return dftThemeLike;
    }

    public void setDftThemeLike(String dftThemeLike) {
        this.dftThemeLike = dftThemeLike;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public Integer getPcOnlineFlag() {
        return pcOnlineFlag;
    }

    public void setPcOnlineFlag(Integer pcOnlineFlag) {
        this.pcOnlineFlag = pcOnlineFlag;
    }

    public Integer getBeginPcOnlineFlag() {
        return beginPcOnlineFlag;
    }

    public void setBeginPcOnlineFlag(Integer beginPcOnlineFlag) {
        this.beginPcOnlineFlag = beginPcOnlineFlag;
    }

    public Integer getEndPcOnlineFlag() {
        return endPcOnlineFlag;
    }

    public void setEndPcOnlineFlag(Integer endPcOnlineFlag) {
        this.endPcOnlineFlag = endPcOnlineFlag;
    }

    public Integer getErrCount() {
        return errCount;
    }

    public void setErrCount(Integer errCount) {
        this.errCount = errCount;
    }

    public Integer getBeginErrCount() {
        return beginErrCount;
    }

    public void setBeginErrCount(Integer beginErrCount) {
        this.beginErrCount = beginErrCount;
    }

    public Integer getEndErrCount() {
        return endErrCount;
    }

    public void setEndErrCount(Integer endErrCount) {
        this.endErrCount = endErrCount;
    }

    public Date getErrTime() {
        return errTime;
    }

    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }

    public Date getBeginErrTime() {
        return beginErrTime;
    }

    public void setBeginErrTime(Date beginErrTime) {
        this.beginErrTime = beginErrTime;
    }

    public Date getEndErrTime() {
        return endErrTime;
    }

    public void setEndErrTime(Date endErrTime) {
        this.endErrTime = endErrTime;
    }

    public String getJpushRegId() {
        return jpushRegId;
    }

    public void setJpushRegId(String jpushRegId) {
        this.jpushRegId = jpushRegId;
    }

    public String getJpushRegIdLike() {
        return jpushRegIdLike;
    }

    public void setJpushRegIdLike(String jpushRegIdLike) {
        this.jpushRegIdLike = jpushRegIdLike;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgNameLike() {
        return orgNameLike;
    }

    public void setOrgNameLike(String orgNameLike) {
        this.orgNameLike = orgNameLike;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgPhoneLike() {
        return orgPhoneLike;
    }

    public void setOrgPhoneLike(String orgPhoneLike) {
        this.orgPhoneLike = orgPhoneLike;
    }
}
