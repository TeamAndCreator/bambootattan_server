package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 箨鞘Repository
 * Created by: 张理
 * 2018-11-13
 */
public interface SheathRepository extends JpaRepository<Sheath, Long>, JpaSpecificationExecutor<Sheath> {
    void deleteBySheIdIn(List<Long> ids);
    void findBySheIdIn(List<Long> ids);
}
