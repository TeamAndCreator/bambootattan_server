package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TSheathear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TSheathearRepository extends JpaRepository<TSheathear, Long>, JpaSpecificationExecutor<TSheathear> {
    void deleteBySheEarIdIn(List<Long> ids);
    List<TSheathear> findBySheEarIdIn(List<Long> ids);
}
