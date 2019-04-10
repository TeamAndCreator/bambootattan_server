package com.ahau.repository.rattan.base;

import com.ahau.entity.rattan.base.RattanSpec;
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
 *  藤种
 *  Created by: 张理
 *  2018-11-18
 */
public interface RattanSpecRepository extends JpaRepository<RattanSpec, Long>, JpaSpecificationExecutor<RattanSpec> {

    void deleteBySpecIdIn(List<Long> ids);
    void findBySpecIdIn(List<Long> ids);

    @Query(value = "SELECT COUNT(specId) FROM RattanSpec WHERE specNameCh=?1")
    Integer isNameChExisted(String nameCh);
    @Query(value = "SELECT COUNT(specId) FROM RattanSpec WHERE specNameCh=?1 AND specId<>?2")
    Integer isNameChExisted(String nameCh,Long specId);

    /**
     * 根据RattanSpec的id查找其files
     * 用于更新文件
     * @param id
     * @return
     */
    @Query(value = "select s.files from RattanSpec as s where s.id=:id")
    @Modifying
    List getFiles(@Param(value = "id") Long id);

    /**
     * 分页有条件查找（不包含已有地下茎的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TUnderstem AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTUnderstem(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TUnderstem AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTUnderstem(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有藤秆的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TCulm AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTCulm(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TCulm AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTCulm(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有花果形态的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TFlowerfruit AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTFlowerfruit(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TFlowerfruit AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTFlowerfruit(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有藤叶的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TLeaf AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTLeaf(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TLeaf AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTLeaf(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨鞘的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheath AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheath(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheath AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheath(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨耳的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathear AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathear(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathear AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathear(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨环的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathnode AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathnode(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathnode AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathnode(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨片的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathshell AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathshell(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathshell AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathshell(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨舌的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathtongue AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathtongue(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TSheathtongue AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTSheathtongue(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_导管形态特征的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TCathetermorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTCathermorphology(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TCathetermorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTCathermorphology(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有化学性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TChemistry AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTChemistry(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TChemistry AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTChemistry(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_纤维形态特征的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TFibermorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTFibermorphology(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TFibermorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTFibermorphology(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有力学性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TMechanics AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTMechanics(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TMechanics AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTMechanics(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有物理性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TPhysics AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTPhysics(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TPhysics AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTPhysics(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有结构性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TStructure AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTStructure(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TStructure AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTStructure(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_组织比量的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TTissueproportion AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTTissueproportion(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TTissueproportion AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTTissueproportion(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_维管束形态特征）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TVascularbundelmorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTVascularbundelmorphology(Specification<RattanSpec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM RattanSpec AS A WHERE NOT EXISTS( SELECT B.rattanSpec FROM TVascularbundelmorphology AS B WHERE A.specId=B.rattanSpec)")
    Page<RattanSpec> findAllQueryWithOutTVascularbundelmorphology(Pageable pageable);


}
