package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Tissueproportion;
import com.ahau.entity.rattan.rattannature.TTissueproportion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤解剖性质_组织比量
 * Created by: 张理
 * 2018-11-18
 */
public interface TTissueproportionRepository extends JpaRepository<TTissueproportion, Long>, JpaSpecificationExecutor<TTissueproportion> {
    void deleteByTpIdIn(List<Long> ids);
    List<Tissueproportion> findByTpIdIn(List<Long> ids);
}
