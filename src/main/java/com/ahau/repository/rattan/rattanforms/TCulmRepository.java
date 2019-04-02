package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TCulm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TCulmRepository extends JpaRepository<TCulm, Long>, JpaSpecificationExecutor<TCulm> {
    void deleteByCulmIdIn(List<Long> ids);
    void findByCulmIdIn(List<Long> ids);
}
