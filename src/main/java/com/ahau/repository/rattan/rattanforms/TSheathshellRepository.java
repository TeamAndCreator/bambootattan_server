package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TSheathshell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TSheathshellRepository extends JpaRepository<TSheathshell, Long>, JpaSpecificationExecutor<TSheathshell> {
    void deleteBySheShellIdIn(List<Long> ids);
    List<TSheathshell> findBySheShellIdIn(List<Long> ids);
}
