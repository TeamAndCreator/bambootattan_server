package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 描述：竹属Repository
 *
 * @author 张理
 * 2018-11-3 19:16
 */
public interface GenusRepository extends JpaRepository<Genus, Long>, JpaSpecificationExecutor<Genus> {

    void deleteByGenusIdIn(List<Long> ids);
    void findByGenusIdIn(List<Long> ids);
}