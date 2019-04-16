package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（箨鞘表）
 * Created by: 张理
 * 2018-11-3 10：59
 */
@Entity
public class Sheath implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Sheath{" +
                "sheId=" + sheId +
                ", spec='" + spec + '\'' +
                ", sheathShedTime='" + sheathShedTime + '\'' +
                ", sheathChar='" + sheathChar + '\'' +
                ", sheathTopForm='" + sheathTopForm + '\'' +
                ", sheathBackPowder='" + sheathBackPowder + '\'' +
                ", sheathMarginForm='" + sheathMarginForm + '\'' +
                '}';
    }
}
