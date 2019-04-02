package com.ahau.repository.rattan.rattanforms;

import com.ahau.entity.rattan.rattanforms.TUnderstem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TUnderstemRepository extends JpaRepository<TUnderstem, Long>, JpaSpecificationExecutor<TUnderstem> {
    void deleteByUnderStemIdIn(List<Long> ids);
    List<TUnderstem> findByUnderStemIdIn(List<Long> ids);
}
