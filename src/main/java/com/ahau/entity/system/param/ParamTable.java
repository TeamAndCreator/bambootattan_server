package com.ahau.entity.system.param;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类（系统参数）
 * created by: 张理
 * 2018-10-28 19：30
 */
@Entity
@Table(name = "aau_system_param_table", schema = "bambootattan", catalog = "")
public class ParamTable {
    private String paramId;
    private String systemName;
    private String moduleName;
    private String paramIndex;
    private String paramName;
    private String paramValue;
    private String paramRemark;

    @Id
    @Column(name = "PARAM_ID")
    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    @Basic
    @Column(name = "SYSTEM_NAME")
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Basic
    @Column(name = "MODULE_NAME")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "PARAM_INDEX")
    public String getParamIndex() {
        return paramIndex;
    }

    public void setParamIndex(String paramIndex) {
        this.paramIndex = paramIndex;
    }

    @Basic
    @Column(name = "PARAM_NAME")
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Basic
    @Column(name = "PARAM_VALUE")
    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Basic
    @Column(name = "PARAM_REMARK")
    public String getParamRemark() {
        return paramRemark;
    }

    public void setParamRemark(String paramRemark) {
        this.paramRemark = paramRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParamTable that = (ParamTable) o;
        return Objects.equals(paramId, that.paramId) &&
                Objects.equals(systemName, that.systemName) &&
                Objects.equals(moduleName, that.moduleName) &&
                Objects.equals(paramIndex, that.paramIndex) &&
                Objects.equals(paramName, that.paramName) &&
                Objects.equals(paramValue, that.paramValue) &&
                Objects.equals(paramRemark, that.paramRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paramId, systemName, moduleName, paramIndex, paramName, paramValue, paramRemark);
    }
}
