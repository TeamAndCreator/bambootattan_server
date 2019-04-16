package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（箨耳表）
 * Created by: 张理
 * 2018-11-2 18：43
 */
@Entity
public class Sheathear implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sheEarId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

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

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
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
        return "Sheathear{" +
                "sheEarId=" + sheEarId +
                ", spec=" + spec +
                ", sheathEarDev='" + sheathEarDev + '\'' +
                ", sheathEarShape='" + sheathEarShape + '\'' +
                ", sheathEarMargin='" + sheathEarMargin + '\'' +
                '}';
    }
}
