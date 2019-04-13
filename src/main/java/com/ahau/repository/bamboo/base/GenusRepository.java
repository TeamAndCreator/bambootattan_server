package com.ahau.repository.bamboo.base;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.echart.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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

//    Genus findByGenusNameCh(String genusNameCh);

    @Query(value = "SELECT COUNT(genusId) FROM Genus WHERE genusNameCh=?1")
    Integer isNameChExisted(String nameCh);
    @Query(value = "SELECT COUNT(genusId) FROM Genus WHERE genusNameCh=?1 AND genusId<>?2")
    Integer isNameChExisted(String nameCh,Long genusId);

    @Query(value = "SELECT new com.ahau.entity.echart.Visit(count(genusNameCh),genusNameCh) from Genus GROUP BY genusNameCh having genusNameCh IS not Null")
    List<Visit> getGenus();
//
//    @Query(value = "SELECT COUNT(genusNameCh) from Genus")
//    Long findTotalGenus(String genusNameCh);
}
