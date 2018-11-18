package com.ahau.repository.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Vascularbundelmorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 解剖性质_维管束形态特征
 * Created by: 张理
 * 2018-11-18
 */
public interface VascularbundelmorphologyRepository extends JpaRepository<Vascularbundelmorphology, Long>, JpaSpecificationExecutor<Vascularbundelmorphology> {
    void deleteByVbmIdIn(List<Long> ids);
    List<Vascularbundelmorphology > findByVbmIdIn(List<Long> ids);
}
