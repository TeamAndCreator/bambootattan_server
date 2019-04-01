package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 *  实体类：（藤箨鞘表）
 *  Created by: 张理
 *  2018-4-1
 */
@Entity
public class TSheath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 箨鞘早落 */
    private String sheathShedTime;

    /* 箨鞘质地 */
    private String sheathChar;

    /* 箨鞘先端形状 */
    private String sheathTopForm;

    /* 箨鞘背面被毛被粉 */
    private String sheathBackPowder;

    /* 箨鞘边缘形状 */
    private String sheathMarginForm;

    public Long getSheId() {
        return sheId;
    }

    public void setSheId(Long sheId) {
        this.sheId = sheId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getSheathShedTime() {
        return sheathShedTime;
    }

    public void setSheathShedTime(String sheathShedTime) {
        this.sheathShedTime = sheathShedTime;
    }

    public String getSheathChar() {
        return sheathChar;
    }

    public void setSheathChar(String sheathChar) {
        this.sheathChar = sheathChar;
    }

    public String getSheathTopForm() {
        return sheathTopForm;
    }

    public void setSheathTopForm(String sheathTopForm) {
        this.sheathTopForm = sheathTopForm;
    }

    public String getSheathBackPowder() {
        return sheathBackPowder;
    }

    public void setSheathBackPowder(String sheathBackPowder) {
        this.sheathBackPowder = sheathBackPowder;
    }

    public String getSheathMarginForm() {
        return sheathMarginForm;
    }

    public void setSheathMarginForm(String sheathMarginForm) {
        this.sheathMarginForm = sheathMarginForm;
    }

    @Override
    public String toString() {
        return "TSheath{" +
                "sheId=" + sheId +
                ", rattanSpec=" + rattanSpec +
                ", sheathShedTime='" + sheathShedTime + '\'' +
                ", sheathChar='" + sheathChar + '\'' +
                ", sheathTopForm='" + sheathTopForm + '\'' +
                ", sheathBackPowder='" + sheathBackPowder + '\'' +
                ", sheathMarginForm='" + sheathMarginForm + '\'' +
                '}';
    }
}
