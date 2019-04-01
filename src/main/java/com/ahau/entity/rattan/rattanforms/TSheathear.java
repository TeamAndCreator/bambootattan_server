package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 *  实体类：（藤箨耳表）
 *  Created by: 张理
 *  2018-4-1
 */
@Entity
public class TSheathear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheEarId;

    /* 种标识 */
    @ManyToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 箨耳发达情况 */
    private String sheathEarDev;

    /* 箨耳形状 */
    private String sheathEarShape;

    /* 箨耳边缘繸毛 */
    private String sheathEarMargin;

    public Long getSheEarId() {
        return sheEarId;
    }

    public void setSheEarId(Long sheEarId) {
        this.sheEarId = sheEarId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getSheathEarDev() {
        return sheathEarDev;
    }

    public void setSheathEarDev(String sheathEarDev) {
        this.sheathEarDev = sheathEarDev;
    }

    public String getSheathEarShape() {
        return sheathEarShape;
    }

    public void setSheathEarShape(String sheathEarShape) {
        this.sheathEarShape = sheathEarShape;
    }

    public String getSheathEarMargin() {
        return sheathEarMargin;
    }

    public void setSheathEarMargin(String sheathEarMargin) {
        this.sheathEarMargin = sheathEarMargin;
    }

    @Override
    public String toString() {
        return "TSheathear{" +
                "sheEarId=" + sheEarId +
                ", rattanSpec=" + rattanSpec +
                ", sheathEarDev='" + sheathEarDev + '\'' +
                ", sheathEarShape='" + sheathEarShape + '\'' +
                ", sheathEarMargin='" + sheathEarMargin + '\'' +
                '}';
    }
}
