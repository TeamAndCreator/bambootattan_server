package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathear;
import com.ahau.entity.bamboo.bambooforms.Sheathnode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 箨环
 * Created by: 张理
 * 2018-11-13
 */
public interface SheathnodeRepository extends JpaRepository<Sheathnode, Long>, JpaSpecificationExecutor<Sheathnode> {
    void deleteBySheNodeIdIn(List<Long> ids);
    List<Sheathear> findBySheNodeIdIn(List<Long> ids);
}
