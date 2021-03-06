package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（箨环表）
 * Created by: 张理
 *2018-11-3 10：08
 */
@Entity
public class Sheathnode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheNodeId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Sheathnode{" +
                "sheNodeId=" + sheNodeId +
                ", spec='" + spec + '\'' +
                ", sheathNode='" + sheathNode + '\'' +
                ", sheathNodeBack='" + sheathNodeBack + '\'' +
                '}';
    }
}
