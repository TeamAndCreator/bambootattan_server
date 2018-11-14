package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Understem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 地下茎
 * Created by: 张理
 * 2018-11-13
 */
public interface UnderstemRepository extends JpaRepository<Understem, Long>, JpaSpecificationExecutor<Understem> {
    void deleteByUnderStemIdIn(List<Long> ids);
    List<Understem> findByUnderStemIdIn(List<Long> ids);
}
