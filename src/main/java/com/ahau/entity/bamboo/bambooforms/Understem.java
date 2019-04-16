package com.ahau.entity.bamboo.bambooforms;

import com.ahau.entity.bamboo.base.Spec;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体类：（地下茎表）
 * Created by: 张理
 * 2018-11-3 11：17
 */
@Entity
public class Understem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long underStemId;

    /* 种标识 */
    @OneToOne
    @JoinColumn(name = "spec_id")
    private Spec spec;

    /* 地下茎类型 */
    private String underStem;

    public Long getUnderStemId() {
        return underStemId;
    }

    public void setUnderStemId(Long underStemId) {
        this.underStemId = underStemId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public String getUnderStem() {
        return underStem;
    }

    public void setUnderStem(String underStem) {
        this.underStem = underStem;
    }

    @Override
    public String toString() {
        return "Understem{" +
                "underStemId=" + underStemId +
                ", spec=" + spec +
                ", underStem='" + underStem + '\'' +
                '}';
    }
}
