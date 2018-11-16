package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Chemistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 化学性质
 * Created by: 张理
 * 2018-11-14
 */
public interface ChemistryRepository extends JpaRepository<Chemistry, Long>, JpaSpecificationExecutor<Chemistry> {
    void deleteByChemIdIn(List<Long> ids);
    List<Chemistry> findByChemIdIn(List<Long> ids);
}
