package com.ahau.repository.rattan.rattanforms;


import com.ahau.entity.rattan.rattanforms.TFlowerfruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface TFlowerfruitRepository extends JpaRepository<TFlowerfruit, Long>, JpaSpecificationExecutor<TFlowerfruit> {
    void deleteByFloFruitIdIn(List<Long> ids);
    List<TFlowerfruit> findByFloFruitIdIn(List<Long> ids);
}
