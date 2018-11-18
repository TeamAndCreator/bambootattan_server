package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Structure;
import com.ahau.entity.rattan.rattannature.TStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤结构性质
 * Created by: 张理
 * 2018-11-18
 */
public interface TStructureRepository extends JpaRepository<TStructure, Long>, JpaSpecificationExecutor<TStructure> {
    void deleteByStIdIn(List<Long> ids);
    List<Structure> findByStIdIn(List<Long> ids);
}
