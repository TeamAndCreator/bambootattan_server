package com.ahau.entity.system.dictionary;

import javax.persistence.*;
import java.util.Objects;


/**
 * 实体类：（数据字典）
 * created by: 张理
 * 2018-10-27 16：00
 */
@Entity
@Table(name = "aau_system_dictionary_table", schema = "bambootattan", catalog = "")
public class DictionaryTable {
    private String dictId;
    private String indexPinyin;
    private String indexName;
    private String dictCont;
    private String dictRemark;
    private String dictReser;
    private String orderBy;
    private String contIndex;

    @Id
    @Column(name = "DICT_ID")
    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    @Basic
    @Column(name = "INDEX_PINYIN")
    public String getIndexPinyin() {
        return indexPinyin;
    }

    public void setIndexPinyin(String indexPinyin) {
        this.indexPinyin = indexPinyin;
    }

    @Basic
    @Column(name = "INDEX_NAME")
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Basic
    @Column(name = "DICT_CONT")
    public String getDictCont() {
        return dictCont;
    }

    public void setDictCont(String dictCont) {
        this.dictCont = dictCont;
    }

    @Basic
    @Column(name = "DICT_REMARK")
    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    @Basic
    @Column(name = "DICT_RESER")
    public String getDictReser() {
        return dictReser;
    }

    public void setDictReser(String dictReser) {
        this.dictReser = dictReser;
    }

    @Basic
    @Column(name = "ORDER_BY")
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Basic
    @Column(name = "CONT_INDEX")
    public String getContIndex() {
        return contIndex;
    }

    public void setContIndex(String contIndex) {
        this.contIndex = contIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryTable that = (DictionaryTable) o;
        return Objects.equals(dictId, that.dictId) &&
                Objects.equals(indexPinyin, that.indexPinyin) &&
                Objects.equals(indexName, that.indexName) &&
                Objects.equals(dictCont, that.dictCont) &&
                Objects.equals(dictRemark, that.dictRemark) &&
                Objects.equals(dictReser, that.dictReser) &&
                Objects.equals(orderBy, that.orderBy) &&
                Objects.equals(contIndex, that.contIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictId, indexPinyin, indexName, dictCont, dictRemark, dictReser, orderBy, contIndex);
    }
}
