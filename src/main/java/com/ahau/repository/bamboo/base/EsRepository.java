package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * 描述：搜索引擎Repository
 * Created by: zhangli
 * 2019-2-17
 */
public interface EsRepository extends ElasticsearchCrudRepository <Spec, Long> {

}
