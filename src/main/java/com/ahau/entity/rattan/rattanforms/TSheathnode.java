package com.ahau.entity.rattan.rattanforms;

import com.ahau.entity.rattan.base.RattanSpec;

import javax.persistence.*;

/**
 * 实体类：（藤箨环表）
 * Created by: 张理
 * 2018-4-1
 */
@Entity
public class TSheathnode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheNodeId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private RattanSpec rattanSpec;

    /* 箨环是否隆起 */
    private String sheathNode;

    /* 箨环被毛 */
    private String sheathNodeBack;

    public Long getSheNodeId() {
        return sheNodeId;
    }

    public void setSheNodeId(Long sheNodeId) {
        this.sheNodeId = sheNodeId;
    }

    public RattanSpec getRattanSpec() {
        return rattanSpec;
    }

    public void setRattanSpec(RattanSpec rattanSpec) {
        this.rattanSpec = rattanSpec;
    }

    public String getSheathNode() {
        return sheathNode;
    }

    public void setSheathNode(String sheathNode) {
        this.sheathNode = sheathNode;
    }

    public String getSheathNodeBack() {
        return sheathNodeBack;
    }

    public void setSheathNodeBack(String sheathNodeBack) {
        this.sheathNodeBack = sheathNodeBack;
    }

    @Override
    public String toString() {
        return "TSheathnode{" +
                "sheNodeId=" + sheNodeId +
                ", rattanSpec=" + rattanSpec +
                ", sheathNode='" + sheathNode + '\'' +
                ", sheathNodeBack='" + sheathNodeBack + '\'' +
                '}';
    }
}
