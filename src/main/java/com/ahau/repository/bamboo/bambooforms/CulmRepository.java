package com.ahau.repository.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Culm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 竹秆Repository
 * Created by: 张理
 * 2018-11-12
 */
public interface CulmRepository extends JpaRepository<Culm, Long>, JpaSpecificationExecutor<Culm> {
    void deleteByCulmIdIn(List<Long> ids);
    void findByCulmIdIn(List<Long> ids);

//    Culm findBySpecId(Long specId);
//    @Query(value = "select c.spec from Culm as c where c.id=:id")
//    @Modifying
//    List findBySpec(@Param(value = "id") Long id);
    //Culm findBySpec(Long specId);
    //Culm findBySpec(Spec spec);
    //Culm findBySpecName(String specNameCh);
}
