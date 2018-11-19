package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Chemistry;
import com.ahau.entity.rattan.rattannature.TChemistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤化学性质
 * Created by: 张理
 * 2018-11-18
 */
public interface TChemistryRepository extends JpaRepository<TChemistry, Long>, JpaSpecificationExecutor<TChemistry> {
    void deleteByChemIdIn(List<Long> ids);
    List<Chemistry> findByChemIdIn(List<Long> ids);
}
