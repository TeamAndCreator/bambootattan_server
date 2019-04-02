package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TLeaf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TLeafRepository extends JpaRepository<TLeaf, Long>, JpaSpecificationExecutor<TLeaf> {
    void deleteByLeafIdIn(List<Long> ids);
    void findByLeafIdIn(List<Long> ids);
}
