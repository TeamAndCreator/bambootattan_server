package com.ahau.entity.system.dictionary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（数据字典）
 * created by: 张理
 * 2018-10-27 16：00
 */
@Entity
public class DictionaryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /* 拼音索引 */
    private String indexPinyin;
    /* 索引名称 */
    private String indexName;
    /* 字典内容 */
    private String dictCont;
    /* 字典备注 */
    private String dictRemark;
    /* 字典预留 */
    private String dictReser;
    /* 排序序号 */
    private String orderBy;
    /* 内容索引 */
    private String contIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndexPinyin() {
        return indexPinyin;
    }

    public void setIndexPinyin(String indexPinyin) {
        this.indexPinyin = indexPinyin;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getDictCont() {
        return dictCont;
    }

    public void setDictCont(String dictCont) {
        this.dictCont = dictCont;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public String getDictReser() {
        return dictReser;
    }

    public void setDictReser(String dictReser) {
        this.dictReser = dictReser;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getContIndex() {
        return contIndex;
    }

    public void setContIndex(String contIndex) {
        this.contIndex = contIndex;
    }
}
