package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（箨环表）
 * created by: 张理
 * 2018-10-26 17：00
 */
@Entity
@Table(name = "aau_bam_sheathnode_table", schema = "bambootattan", catalog = "")
public class SheathnodeTable {
    private String sheNodeId;
    private String specId;
    private String sheathNode;
    private String sheathNodeBack;

    @Id
    @Column(name = "SHE_NODE_ID")
    public String getSheNodeId() {
        return sheNodeId;
    }

    public void setSheNodeId(String sheNodeId) {
        this.sheNodeId = sheNodeId;
    }

    @Basic
    @Column(name = "SPEC_ID")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "SHEATH_NODE")
    public String getSheathNode() {
        return sheathNode;
    }

    public void setSheathNode(String sheathNode) {
        this.sheathNode = sheathNode;
    }

    @Basic
    @Column(name = "SHEATH_NODE_BACK")
    public String getSheathNodeBack() {
        return sheathNodeBack;
    }

    public void setSheathNodeBack(String sheathNodeBack) {
        this.sheathNodeBack = sheathNodeBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheathnodeTable that = (SheathnodeTable) o;
        return Objects.equals(sheNodeId, that.sheNodeId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(sheathNode, that.sheathNode) &&
                Objects.equals(sheathNodeBack, that.sheathNodeBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheNodeId, specId, sheathNode, sheathNodeBack);
    }
}
