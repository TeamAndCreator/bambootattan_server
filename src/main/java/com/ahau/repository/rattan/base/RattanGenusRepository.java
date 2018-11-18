package com.ahau.repository.rattan.base;

import com.ahau.entity.rattan.base.RattanGenus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *  藤属
 *  Created by: 张理
 *  2018-11-18
 */
public interface RattanGenusRepository extends JpaRepository<RattanGenus, Long>, JpaSpecificationExecutor<RattanGenus> {

    void deleteByGenusIdIn(List<Long> ids);
    void findByGenusIdIn(List<Long> ids);
}
