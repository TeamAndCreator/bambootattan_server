package com.ahau.repository.rattan.base;

import com.ahau.entity.rattan.base.RattanSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *  藤种
 *  Created by: 张理
 *  2018-11-18
 */
public interface RattanSpecRepository extends JpaRepository<RattanSpec, Long>, JpaSpecificationExecutor<RattanSpec> {

    void deleteBySpecIdIn(List<Long> ids);
    void findBySpecIdIn(List<Long> ids);
}
