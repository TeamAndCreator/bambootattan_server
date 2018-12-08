package com.ahau.service.bamboo.bamboonature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bamboonature.Mechanics;
import com.ahau.repository.bamboo.bamboonature.MechanicsRepository;
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
 *力学性质服务层接口
 * Created by: 张理
 * 2018-11-17
 */
@Transactional
@Service
public class MechanicsService {
    private final MechanicsRepository mechanicsRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public MechanicsService(MechanicsRepository mechanicsRepository) {this.mechanicsRepository = mechanicsRepository;}

    /**
     * 查询所有力学性质列表
     * @return
     */
    public List<Mechanics> findAll() {return mechanicsRepository.findAll();}

    /**
     * 查询一个力学性质
     * @param id
     * @return
     */
    public Mechanics findById(Long id) {
        Optional<Mechanics> mechanicsOptional = mechanicsRepository.findById(id);
        Mechanics mechanics = new Mechanics();
        if (mechanicsOptional.isPresent()) {
            mechanics = mechanicsOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return mechanics;
    }

    /**
     * 更新
     * @param mechanics
     * @return
     */
    public Mechanics update(Mechanics mechanics) {
        mechanicsRepository.save(mechanics);
        return mechanics;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        mechanicsRepository.deleteById(id);
    }

    /**
     * 添加一个力学性质
     * @param mechanics
     * @return
     */
    public Mechanics save(Mechanics mechanics) {
        return mechanicsRepository.save(mechanics);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Mechanics> findMechanicsNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return mechanicsRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Mechanics> findMechanicsQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return mechanicsRepository.findAll((Specification<Mechanics>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return mechanicsRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        mechanicsRepository.deleteByMechIdIn(ids);
    }
}
