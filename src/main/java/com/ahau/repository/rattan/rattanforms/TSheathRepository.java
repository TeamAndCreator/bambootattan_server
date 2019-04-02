package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TSheath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TSheathRepository extends JpaRepository<TSheath, Long>, JpaSpecificationExecutor<TSheath> {
    void deleteBySheIdIn(List<Long> ids);
    void findBySheIdIn(List<Long> ids);
}
