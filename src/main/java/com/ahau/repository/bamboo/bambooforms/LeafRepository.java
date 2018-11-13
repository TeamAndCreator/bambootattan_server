package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Leaf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 竹叶Repository
 * Created by: 张理
 * 2018-11-13
 */
public interface LeafRepository extends JpaRepository<Leaf, Long>, JpaSpecificationExecutor<Leaf> {
    void deleteByLeafIdIn(List<Long> ids);
    void findByLeafIdIn(List<Long> ids);
}
