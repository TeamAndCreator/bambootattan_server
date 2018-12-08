package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TMechanics;
import com.ahau.repository.rattan.rattannature.TMechanicsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * 藤力学性质服务层接口
 * Created by: 张理
 * 2018-11-17
 */
@Transactional
@Service
public class TMechanicsService {
    private final TMechanicsRepository tMechanicsRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TMechanicsService(TMechanicsRepository tMechanicsRepository) {this.tMechanicsRepository = tMechanicsRepository;}

    /**
     * 查询所有力学性质列表
     * @return
     */
    public List<TMechanics> findAll() {return tMechanicsRepository.findAll();}

    /**
     * 查询一个力学性质
     * @param id
     * @return
     */
    public TMechanics findById(Long id) {
        Optional<TMechanics> tMechanicsOptional = tMechanicsRepository.findById(id);
        TMechanics tMechanics = new TMechanics();
        if (tMechanicsOptional.isPresent()) {
            tMechanics = tMechanicsOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tMechanics;
    }

    /**
     * 更新
     * @param tMechanics
     * @return
     */
    public TMechanics update(TMechanics tMechanics) {
        tMechanicsRepository.save(tMechanics);
        return tMechanics;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tMechanicsRepository.deleteById(id);
    }

    /**
     * 添加一个力学性质
     * @param tMechanics
     * @return
     */
    public TMechanics save(TMechanics tMechanics) {
        return tMechanicsRepository.save(tMechanics);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TMechanics> findTMechanicsNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tMechanicsRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TMechanics> findTMechanicsQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tMechanicsRepository.findAll((Specification<TMechanics>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("mechBendingModulusElastictyUnitGpa").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechBendingStrenghtUnitMpa").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechCompressionStrenghtUnitMpa").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechShearStrenghtUnitMpa").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechTensileStrenghtUnitMpa").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechImpactDuctilityUnitRenxiang").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("mechComplianceUnitRouliang").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tMechanicsRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tMechanicsRepository.deleteByMechIdIn(ids);
    }
}
