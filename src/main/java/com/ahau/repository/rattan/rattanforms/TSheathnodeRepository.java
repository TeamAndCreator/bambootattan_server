package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TSheathnode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TSheathnodeRepository extends JpaRepository<TSheathnode, Long>, JpaSpecificationExecutor<TSheathnode> {
    void deleteBySheNodeIdIn(List<Long> ids);
    List<TSheathnode> findBySheNodeIdIn(List<Long> ids);
}
