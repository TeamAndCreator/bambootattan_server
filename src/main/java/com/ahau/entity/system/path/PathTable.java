package com.ahau.entity.system.path;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（路径表）
 * created by: 张理
 * 2018-10-28 19：40
 */
@Entity
@Table(name = "aau_system_path_table", schema = "bambootattan", catalog = "")
public class PathTable {
    private String pathId;
    private String parentId;
    private String pathName;
    private String pathUrl;
    private String pathIcon;
    private byte funFlag;
    private String orderBy;
    private String pathTitle;
    private String pathTarget;
    private String pathRel;
    private String pathClass;
    private Short pathHeight;
    private Short pathWidth;

    @Id
    @Column(name = "PATH_ID")
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @Basic
    @Column(name = "PARENT_ID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "PATH_NAME")
    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Basic
    @Column(name = "PATH_URL")
    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    @Basic
    @Column(name = "PATH_ICON")
    public String getPathIcon() {
        return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }

    @Basic
    @Column(name = "FUN_FLAG")
    public byte getFunFlag() {
        return funFlag;
    }

    public void setFunFlag(byte funFlag) {
        this.funFlag = funFlag;
    }

    @Basic
    @Column(name = "ORDER_BY")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Basic
    @Column(name = "PATH_TITLE")
    public String getPathTitle() {
        return pathTitle;
    }

    public void setPathTitle(String pathTitle) {
        this.pathTitle = pathTitle;
    }

    @Basic
    @Column(name = "PATH_TARGET")
    public String getPathTarget() {
        return pathTarget;
    }

    public void setPathTarget(String pathTarget) {
        this.pathTarget = pathTarget;
    }

    @Basic
    @Column(name = "PATH_REL")
    public String getPathRel() {
        return pathRel;
    }

    public void setPathRel(String pathRel) {
        this.pathRel = pathRel;
    }

    @Basic
    @Column(name = "PATH_CLASS")
    public String getPathClass() {
        return pathClass;
    }

    public void setPathClass(String pathClass) {
        this.pathClass = pathClass;
    }

    @Basic
    @Column(name = "PATH_HEIGHT")
    public Short getPathHeight() {
        return pathHeight;
    }

    public void setPathHeight(Short pathHeight) {
        this.pathHeight = pathHeight;
    }

    @Basic
    @Column(name = "PATH_WIDTH")
    public Short getPathWidth() {
        return pathWidth;
    }

    public void setPathWidth(Short pathWidth) {
        this.pathWidth = pathWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathTable that = (PathTable) o;
        return funFlag == that.funFlag &&
                Objects.equals(pathId, that.pathId) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(pathName, that.pathName) &&
                Objects.equals(pathUrl, that.pathUrl) &&
                Objects.equals(pathIcon, that.pathIcon) &&
                Objects.equals(orderBy, that.orderBy) &&
                Objects.equals(pathTitle, that.pathTitle) &&
                Objects.equals(pathTarget, that.pathTarget) &&
                Objects.equals(pathRel, that.pathRel) &&
                Objects.equals(pathClass, that.pathClass) &&
                Objects.equals(pathHeight, that.pathHeight) &&
                Objects.equals(pathWidth, that.pathWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathId, parentId, pathName, pathUrl, pathIcon, funFlag, orderBy, pathTitle, pathTarget, pathRel, pathClass, pathHeight, pathWidth);
    }
}
