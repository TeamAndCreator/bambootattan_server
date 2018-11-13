package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathshell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 箨片
 * Created by: 张理
 * 2018-11-13
 */
public interface SheathshellRepository extends JpaRepository<Sheathshell, Long>, JpaSpecificationExecutor<Sheathshell> {
    void deleteBySheShellIdIn(List<Long> ids);
    List<Sheathshell> findBySheShellIdIn(List<Long> ids);
}
