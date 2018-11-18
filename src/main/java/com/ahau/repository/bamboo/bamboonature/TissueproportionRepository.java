package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Tissueproportion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 解剖性质_组织比量
 * Created by: 张理
 * 2018-11-18
 */
public interface TissueproportionRepository extends JpaRepository<Tissueproportion, Long>, JpaSpecificationExecutor<Tissueproportion> {
    void deleteByTpIdIn(List<Long> ids);
    List<Tissueproportion> findByTpIdIn(List<Long> ids);
}
