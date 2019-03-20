package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import com.ahau.entity.file.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * 竹种Repository
 * Created by: 张理
 * 2018-11-12
 */

public interface SpecRepository extends JpaRepository<Spec, Long>, JpaSpecificationExecutor<Spec> {

    void deleteBySpecIdIn(List<Long> ids);
    void findBySpecIdIn(List<Long> ids);
    /**
     * 根据spec的id查找其files
     * 用于更新文件
     */
    @Query(value = "select s.files from Spec as s where s.id=:id")
    @Modifying
    List getFiles(@Param(value = "id") Long id);

//    Set<Files> getFiles(Long id);
}
