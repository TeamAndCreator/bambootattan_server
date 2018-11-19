package com.ahau.service.rattan.rattannature;

import com.ahau.entity.rattan.rattannature.TChemistry;
import com.ahau.repository.rattan.rattannature.TChemistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 藤化学性质服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TChemistryService {
    private final TChemistryRepository tChemistryRepository;

    @Autowired
    public TChemistryService(TChemistryRepository tChemistryRepository) {this.tChemistryRepository = tChemistryRepository;}

    /**
     * 查询所有化学性质列表
     * @return
     */
    public List<TChemistry> findAll() {return tChemistryRepository.findAll();}

    /**
     * 查询一个化学性质
     * @param id
     * @return
     */
    public TChemistry findById(Long id) {
        Optional<TChemistry> tChemistryOptional = tChemistryRepository.findById(id);
        TChemistry tChemistry = new TChemistry();
        if (tChemistryOptional.isPresent()) {
            tChemistry = tChemistryOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return tChemistry;
    }

    /**
     * 更新
     * @param tChemistry
     * @return
     */
    public TChemistry update(TChemistry tChemistry) {
        tChemistryRepository.save(tChemistry);
        return tChemistry;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tChemistryRepository.deleteById(id);
    }

    /**
     * 添加一个化学性质
     * @param tChemistry
     * @return
     */
    public TChemistry save(TChemistry tChemistry) {
        return tChemistryRepository.save(tChemistry);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TChemistry> findTChemistryNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tChemistryRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TChemistry> findTChemistryQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tChemistryRepository.findAll((Specification<TChemistry>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("chemHolocelluloseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemCelluloseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemHemicelluloseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemACelluloseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemAcidInsolubleLigninUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemBenzeneAlcoholExtractionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemHotWaterExtractionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemColdWaterExtractionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chemAshContentUnitPercent").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tChemistryRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tChemistryRepository.deleteByChemIdIn(ids);
    }
}
