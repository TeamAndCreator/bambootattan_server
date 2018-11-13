package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 箨耳
 * Created by: 张理
 * 2018-11-13
 */
public interface SheathearRepository extends JpaRepository<Sheathear, Long>, JpaSpecificationExecutor<Sheathear> {
    void deleteBySheEarIdIn(List<Long> ids);
    List<Sheathear> findBySheEarIdIn(List<Long> ids);
}
