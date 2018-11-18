package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Fibermorphology;
import com.ahau.entity.bamboo.bamboonature.Mechanics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *力学性质
 * Created by: 张理
 * 2018-11-17
 */
public interface MechanicsRepository extends JpaRepository<Mechanics, Long>, JpaSpecificationExecutor<Mechanics> {
    void deleteByMechIdIn(List<Long> ids);
    List<Mechanics> findByMechIdIn(List<Long> ids);
}
