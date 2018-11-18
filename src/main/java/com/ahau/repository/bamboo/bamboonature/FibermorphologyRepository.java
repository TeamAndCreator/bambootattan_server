package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Fibermorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *解剖性质_纤维形态特征
 * Created by: 张理
 * 2018-11-17
 */
public interface FibermorphologyRepository extends JpaRepository<Fibermorphology, Long>, JpaSpecificationExecutor<Fibermorphology> {
    void deleteByFmIdIn(List<Long> ids);
    List<Fibermorphology> findByFmIdIn(List<Long> ids);
}
