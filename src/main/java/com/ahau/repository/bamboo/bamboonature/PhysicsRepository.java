package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Physics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 物理性质
 * Created by: 张理
 * 2018-11-18
 */
public interface PhysicsRepository extends JpaRepository<Physics, Long>, JpaSpecificationExecutor<Physics> {
    void deleteByPhyIdIn(List<Long> ids);
    List<Physics> findByPhyIdIn(List<Long> ids);
}
