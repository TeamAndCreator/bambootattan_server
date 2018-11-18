package com.ahau.repository.rattan.rattannature;

import com.ahau.entity.bamboo.bamboonature.Cathermorphology;
import com.ahau.entity.rattan.rattannature.TCathetermorphology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 藤解剖性质_导管形态特征
 * Created by: 张理
 * 2018-11-18
 */
public interface TCathetermorphologyRepository extends JpaRepository<TCathetermorphology, Long>, JpaSpecificationExecutor<TCathetermorphology> {
    void deleteByChmIdIn(List<Long> ids);
    List<Cathermorphology> findByChmIdIn(List<Long> ids);
}
