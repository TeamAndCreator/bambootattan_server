package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Cathermorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 解剖性质_导管形态特征
 * Created by: 张理
 * 2018-11-14
 */
public interface CathermorphologyRepository extends JpaRepository<Cathermorphology, Long>,
        JpaSpecificationExecutor<Cathermorphology> {
    void deleteByChmIdIn(List<Long> ids);
    List<Cathermorphology> findByChmIdIn(List<Long> ids);
}
