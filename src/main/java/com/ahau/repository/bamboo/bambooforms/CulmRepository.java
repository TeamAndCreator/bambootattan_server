package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Culm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

/**
 * 竹秆Repository
 * Created by: 张理
 * 2018-11-12
 */
public interface CulmRepository extends JpaRepository<Culm, Long>, JpaSpecificationExecutor<Culm> {
    void deleteByCulmIdIn(List<Long> ids);
    void findByCulmIdIn(List<Long> ids);
}
