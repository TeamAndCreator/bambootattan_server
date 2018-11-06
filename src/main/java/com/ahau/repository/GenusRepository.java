package com.ahau.repository;

import com.ahau.entity.bamboo.base.Genus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：竹属Repository
 * @author 张理
 * 2018-11-3 19:16
 */
public interface GenusRepository extends JpaRepository<Genus, Long> {

}
