package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Physics;
import com.ahau.entity.rattan.rattannature.TPhysics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤物理性质
 * Created by: 张理
 * 2018-11-18
 */
public interface TPhysicsRepository extends JpaRepository<TPhysics, Long>, JpaSpecificationExecutor<TPhysics> {
    void deleteByPhyIdIn(List<Long> ids);
    List<Physics> findByPhyIdIn(List<Long> ids);
}
