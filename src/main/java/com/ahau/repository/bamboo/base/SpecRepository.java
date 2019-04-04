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

    //Spec findBySpecNameCh(String specNameCh);

    @Query(value = "SELECT COUNT(specId) FROM Spec WHERE specNameCh=?1")
    Integer isNameChExisted(String nameCh);
    @Query(value = "SELECT COUNT(specId) FROM Spec WHERE specNameCh=?1 AND specId<>?2")
    Integer isNameChExisted(String nameCh,Long specId);

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

    /**
     * 分页有条件查找（不包含已有竹秆的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Culm AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutCulm(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Culm AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutCulm(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有花果形态的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Flowerfruit AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutFlowerfruit(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Flowerfruit AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutFlowerfruit(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有竹叶的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Leaf AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutLeaf(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Leaf AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutLeaf(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨鞘的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheath AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheath(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheath AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheath(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨耳的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathear AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathear(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathear AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathear(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨环的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathnode AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathnode(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathnode AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathnode(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨片的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathshell AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathshell(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathshell AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathshell(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有箨舌的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathtongue AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathtongue(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Sheathtongue AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutSheathtongue(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_导管形态特征的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Cathermorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutCathermorphology(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Cathermorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutCathermorphology(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有化学性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Chemistry AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutChemistry(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Chemistry AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutChemistry(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_纤维形态特征的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Fibermorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutFibermorphology(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Fibermorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutFibermorphology(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有力学性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Mechanics AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutMechanics(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Mechanics AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutMechanics(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有物理性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Physics AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutPhysics(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Physics AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutPhysics(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有结构性质的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Structure AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutStructure(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Structure AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutStructure(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_组织比量的数据）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Tissueproportion AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutTissueproportion(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Tissueproportion AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutTissueproportion(Pageable pageable);

    /**
     * 分页有条件查找（不包含已有解剖性质_维管束形态特征）
     * @param specification
     * @param pageable
     * @return
     */
    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Vascularbundelmorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutVascularbundelmorphology(Specification<Spec> specification, Pageable pageable);

    @Query(value = "SELECT A FROM Spec AS A WHERE NOT EXISTS( SELECT B.spec FROM Vascularbundelmorphology AS B WHERE A.specId=B.spec)")
    Page<Spec> findAllQueryWithOutVascularbundelmorphology(Pageable pageable);







}
