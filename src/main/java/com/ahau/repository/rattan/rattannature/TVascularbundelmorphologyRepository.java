package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Vascularbundelmorphology;
import com.ahau.entity.rattan.rattannature.TVascularbundelmorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤解剖性质_维管束形态特征
 * Created by: 张理
 * 2018-11-18
 */
public interface TVascularbundelmorphologyRepository extends JpaRepository<TVascularbundelmorphology, Long>, JpaSpecificationExecutor<TVascularbundelmorphology> {
    void deleteByVbmIdIn(List<Long> ids);
    List<Vascularbundelmorphology> findByVbmIdIn(List<Long> ids);
}
