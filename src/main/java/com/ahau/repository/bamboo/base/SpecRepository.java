package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
     * @param id
     * @return
     */
    @Query(value = "select s.files from Spec as s where s.id=:id")
    @Modifying
    List getFiles(@Param(value = "id") Long id);

//    Set<Files> getFiles(Long id);

    /**
     * 分页有条件查找（不包含已有地下茎的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Understem AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutUnderstem(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Understem AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutUnderstem(Pageable pageable);
}
