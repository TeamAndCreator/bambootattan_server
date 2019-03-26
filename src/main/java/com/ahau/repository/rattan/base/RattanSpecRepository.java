package com.ahau.repository.rattan.base;

import com.ahau.entity.rattan.base.RattanSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *  藤种
 *  Created by: 张理
 *  2018-11-18
 */
public interface RattanSpecRepository extends JpaRepository<RattanSpec, Long>, JpaSpecificationExecutor<RattanSpec> {

    void deleteBySpecIdIn(List<Long> ids);
    void findBySpecIdIn(List<Long> ids);

    /**
     * 根据RattanSpec的id查找其files
     * 用于更新文件
     * @param id
     * @return
     */
    @Query(value = "select s.files from RattanSpec as s where s.id=:id")
    @Modifying
    List getFiles(@Param(value = "id") Long id);
}
