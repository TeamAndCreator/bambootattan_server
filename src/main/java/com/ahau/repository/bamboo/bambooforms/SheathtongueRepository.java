package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathtongue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 箨舌
 * Created by: 张理
 * 2018-11-13
 */
public interface SheathtongueRepository extends JpaRepository<Sheathtongue, Long>,
        JpaSpecificationExecutor<Sheathtongue> {
    void deleteBySheTogIdIn(List<Long> ids);
    List<Sheathtongue> findBySheTogIdIn(List<Long> ids);
}
