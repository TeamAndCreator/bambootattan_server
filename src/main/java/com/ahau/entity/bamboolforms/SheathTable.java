package com.ahau.entity.bamboolforms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（箨鞘表）
 * created by: 张理
 * 2018-10-26 17：10
 */
@Entity
public class SheathTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 种标识 */
    private String specId;
    /* 种标识（模糊查询） */
    private String specIdLike;
    /* 箨鞘早落 */
    private String sheathShedTime;
    /* 箨鞘早落（模糊查询） */
    private String sheathShedTimeLike;
    /* 箨鞘质地 */
    private String sheathChar;
    /* 箨鞘质地（模糊查询） */
    private String sheathCharLike;
    /* 箨鞘先端形状 */
    private String sheathTopForm;
    /* 箨鞘先端形状（模糊查询） */
    private String sheathTopFormLike;
    /* 箨鞘背面被毛被粉 */
    private String sheathBackPowder;
    /* 箨鞘背面被毛被粉（模糊查询） */
    private String sheathBackPowderLike;
    /* 箨鞘边缘形状 */
    private String sheathMarginForm;
    /* 箨鞘边缘形状（模糊查询） */
    private String sheathMarginFormLike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecIdLike() {
        return specIdLike;
    }

    public void setSpecIdLike(String specIdLike) {
        this.specIdLike = specIdLike;
    }

    public String getSheathShedTime() {
        return sheathShedTime;
    }

    public void setSheathShedTime(String sheathShedTime) {
        this.sheathShedTime = sheathShedTime;
    }

    public String getSheathShedTimeLike() {
        return sheathShedTimeLike;
    }

    public void setSheathShedTimeLike(String sheathShedTimeLike) {
        this.sheathShedTimeLike = sheathShedTimeLike;
    }

    public String getSheathChar() {
        return sheathChar;
    }

    public void setSheathChar(String sheathChar) {
        this.sheathChar = sheathChar;
    }

    public String getSheathCharLike() {
        return sheathCharLike;
    }

    public void setSheathCharLike(String sheathCharLike) {
        this.sheathCharLike = sheathCharLike;
    }

    public String getSheathTopForm() {
        return sheathTopForm;
    }

    public void setSheathTopForm(String sheathTopForm) {
        this.sheathTopForm = sheathTopForm;
    }

    public String getSheathTopFormLike() {
        return sheathTopFormLike;
    }

    public void setSheathTopFormLike(String sheathTopFormLike) {
        this.sheathTopFormLike = sheathTopFormLike;
    }

    public String getSheathBackPowder() {
        return sheathBackPowder;
    }

    public void setSheathBackPowder(String sheathBackPowder) {
        this.sheathBackPowder = sheathBackPowder;
    }

    public String getSheathBackPowderLike() {
        return sheathBackPowderLike;
    }

    public void setSheathBackPowderLike(String sheathBackPowderLike) {
        this.sheathBackPowderLike = sheathBackPowderLike;
    }

    public String getSheathMarginForm() {
        return sheathMarginForm;
    }

    public void setSheathMarginForm(String sheathMarginForm) {
        this.sheathMarginForm = sheathMarginForm;
    }

    public String getSheathMarginFormLike() {
        return sheathMarginFormLike;
    }

    public void setSheathMarginFormLike(String sheathMarginFormLike) {
        this.sheathMarginFormLike = sheathMarginFormLike;
    }
}
