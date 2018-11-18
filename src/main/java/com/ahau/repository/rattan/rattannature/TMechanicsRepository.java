package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Mechanics;
import com.ahau.entity.rattan.rattannature.TMechanics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤力学性质
 * Created by: 张理
 * 2018-11-17
 */
public interface TMechanicsRepository extends JpaRepository<TMechanics, Long>, JpaSpecificationExecutor<TMechanics> {
    void deleteByMechIdIn(List<Long> ids);
    List<Mechanics> findByMechIdIn(List<Long> ids);
}
