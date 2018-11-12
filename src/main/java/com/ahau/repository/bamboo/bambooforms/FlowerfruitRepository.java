package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Flowerfruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 花果形态
 * Created by: 张理
 * 2018-11-12
 */
public interface FlowerfruitRepository extends JpaRepository<Flowerfruit, Long>, JpaSpecificationExecutor<Flowerfruit> {
    void deleteByfloFruitIdIn(List<Long> ids);
    void findByFlofruitIdIn(List<Long> ids);
}
