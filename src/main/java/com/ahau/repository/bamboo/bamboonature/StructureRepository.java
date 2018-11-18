package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 结构性质
 * Created by: 张理
 * 2018-11-18
 */
public interface StructureRepository extends JpaRepository<Structure, Long>, JpaSpecificationExecutor<Structure> {
    void deleteByStIdIn(List<Long> ids);
    List<Structure > findByStIdIn(List<Long> ids);
}
