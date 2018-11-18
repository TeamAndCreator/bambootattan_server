package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Fibermorphology;
import com.ahau.entity.rattan.rattannature.TFibermorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤解剖性质_纤维形态特征
 * Created by: 张理
 * 2018-11-18
 */
public interface TFibermorphologyRepository extends JpaRepository<TFibermorphology, Long>, JpaSpecificationExecutor<TFibermorphology> {
    void deleteByFmIdIn(List<Long> ids);
    List<Fibermorphology> findByFmIdIn(List<Long> ids);
}
