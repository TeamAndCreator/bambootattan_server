package com.ahau.entity.system.path;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.file.Path;
import java.util.List;

/**
 * 实体类：（路径表）
 * created by: 张理
 * 2018-10-28 19：40
 */
@Entity
public class PathTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    /* 路径ID */
    private String id;
    /* 所属路径 */
    private String parentId;
    /* 路径名称 */
    private String pathName;
    private String pathNameStr;
    /* 路径URL */
    private String pathUrl;
    /* 路径ICON */
    private String pathIcon;
    /* dwz框架 用于标识打开页面的类型 dialog-弹出框、navTab-tab页 */
    private String pathTarget;
    /* dwz框架 打开的navTab或者dialog的Id */
    private String pathRel;
    /* dwz框架 a标签的class */
    private String pathClass;
    /* dwz框架 鼠标悬停在按钮上的提示信息 */
    private String pathTitle;
    /* dwz框架 删除按钮所提交删除项的标记 string-删除项ID已String方式传至后台、 */
    private String pathPostType;
    /* dwz框架 弹出框宽度 */
    private Integer pathWidth;
    /* dwz框架 弹出框高度 */
    private Integer pathHeight;
    /* 排序序号 */
    private String orderBy;
    /* 是否功能 */
    private Integer funFlag;

    /* 所属路径名称 */
    private String parentPathName;

    /* 子菜单 */
//    private List<Path> sonPathList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getPathNameStr() {
        return pathNameStr;
    }

    public void setPathNameStr(String pathNameStr) {
        this.pathNameStr = pathNameStr;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getPathIcon() {
        return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }

    public String getPathTarget() {
        return pathTarget;
    }

    public void setPathTarget(String pathTarget) {
        this.pathTarget = pathTarget;
    }

    public String getPathRel() {
        return pathRel;
    }

    public void setPathRel(String pathRel) {
        this.pathRel = pathRel;
    }

    public String getPathClass() {
        return pathClass;
    }

    public void setPathClass(String pathClass) {
        this.pathClass = pathClass;
    }

    public String getPathTitle() {
        return pathTitle;
    }

    public void setPathTitle(String pathTitle) {
        this.pathTitle = pathTitle;
    }

    public String getPathPostType() {
        return pathPostType;
    }

    public void setPathPostType(String pathPostType) {
        this.pathPostType = pathPostType;
    }

    public Integer getPathWidth() {
        return pathWidth;
    }

    public void setPathWidth(Integer pathWidth) {
        this.pathWidth = pathWidth;
    }

    public Integer getPathHeight() {
        return pathHeight;
    }

    public void setPathHeight(Integer pathHeight) {
        this.pathHeight = pathHeight;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getFunFlag() {
        return funFlag;
    }

    public void setFunFlag(Integer funFlag) {
        this.funFlag = funFlag;
    }

    public String getParentPathName() {
        return parentPathName;
    }

    public void setParentPathName(String parentPathName) {
        this.parentPathName = parentPathName;
    }

//    public List<Path> getSonPathList() {
//        return sonPathList;
//    }
//
//    public void setSonPathList(List<Path> sonPathList) {
//        this.sonPathList = sonPathList;
//    }
}
