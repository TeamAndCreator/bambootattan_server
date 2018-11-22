package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 竹种Repository
 * Created by: 张理
 * 2018-11-12
 */

public interface SpecRepository1 extends ElasticsearchCrudRepository<Spec, Long> {

}
