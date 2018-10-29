package com.ahau.entity.system.param;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类（系统参数）
 * created by: 张理
 * 2018-10-28 19：30
 */
@Entity
public class ParamTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 所属系统 */
    private String systemName;
    /* 所属模块 */
    private String moduleName;
    /* 参数索引 */
    private String paramIndex;
    /* 参数名称 */
    private String paramName;
    /* 参数数值 */
    private String paramValue;
    /* 参数备注 */
    private String paramRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getParamIndex() {
        return paramIndex;
    }

    public void setParamIndex(String paramIndex) {
        this.paramIndex = paramIndex;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamRemark() {
        return paramRemark;
    }

    public void setParamRemark(String paramRemark) {
        this.paramRemark = paramRemark;
    }
}
