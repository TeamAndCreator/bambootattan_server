package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（藤地下茎表）
 * Created by: 张理
 * 2018-4-1
 */
@Entity
public class TUnderstem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long underStemId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 地下茎类型 */
    private String underStem;

    public Long getUnderStemId() {
        return underStemId;
    }

    public void setUnderStemId(Long underStemId) {
        this.underStemId = underStemId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getUnderStem() {
        return underStem;
    }

    public void setUnderStem(String underStem) {
        this.underStem = underStem;
    }

    @Override
    public String toString() {
        return "TUnderstem{" +
                "underStemId=" + underStemId +
                ", rattanSpec=" + rattanSpec +
                ", underStem='" + underStem + '\'' +
                '}';
    }
}
