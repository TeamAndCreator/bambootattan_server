package com.ahau.repository.unit;

import com.ahau.entity.echart.Visit;
import com.ahau.entity.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long>, JpaSpecificationExecutor<Unit> {
    void deleteByUnitIdIn(List<Long> ids);
    void findByUnitIdIn(List<Long> ids);

}
