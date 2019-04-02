package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TSheathtongue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TSheathtongueRepository extends JpaRepository<TSheathtongue, Long>, JpaSpecificationExecutor<TSheathtongue> {
    void deleteBySheTogIdIn(List<Long> ids);
    List<TSheathtongue> findBySheTogIdIn(List<Long> ids);
}
