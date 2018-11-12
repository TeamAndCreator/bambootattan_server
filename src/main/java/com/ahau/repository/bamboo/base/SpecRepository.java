package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 竹种Repository
 * Created by: 张理
 * 2018-11-12
 */

public interface SpecRepository extends JpaRepository<Spec, Long>, JpaSpecificationExecutor<Spec> {

    void deleteBySpecIdIn(List<Long> ids);
    void findBySpecIdIn(List<Long> ids);
}
