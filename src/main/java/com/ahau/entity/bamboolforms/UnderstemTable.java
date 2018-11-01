package com.ahau.entity.bamboolforms;

import javax.persistence.*;
import java.util.Objects;

/**
 * 实体类：（地下茎表）
 * Created by: 张理
 * 2018-10-26 15：10
 */
@Entity
@Table(name = "aau_bam_understem_table", schema = "bambootattan", catalog = "")
public class UnderstemTable {
    private String underStemId;
    private String specId;
    private String underStem;

    @Id
    @Column(name = "UNDER_STEM_ID")
    public String getUnderStemId() {
        return underStemId;
    }

    public void setUnderStemId(String underStemId) {
        this.underStemId = underStemId;
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
    @Column(name = "UNDER_STEM")
    public String getUnderStem() {
        return underStem;
    }

    public void setUnderStem(String underStem) {
        this.underStem = underStem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnderstemTable that = (UnderstemTable) o;
        return Objects.equals(underStemId, that.underStemId) &&
                Objects.equals(specId, that.specId) &&
                Objects.equals(underStem, that.underStem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(underStemId, specId, underStem);
    }
}
