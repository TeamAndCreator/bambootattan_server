package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TPhysics;
import com.ahau.repository.rattan.rattannature.TPhysicsRepository;
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
 * 藤物理性质服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TPhysicsService {
    private final TPhysicsRepository tPhysicsRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TPhysicsService(TPhysicsRepository tPhysicsRepository) {this.tPhysicsRepository = tPhysicsRepository;}

    /**
     * 查询所有物理性质列表
     * @return
     */
    public List<TPhysics> findAll() {return tPhysicsRepository.findAll();}

    /**
     * 查询一个物理性质
     * @param id
     * @return
     */
    public TPhysics findById(Long id) {
        Optional<TPhysics> tPhysicsOptional = tPhysicsRepository.findById(id);
        TPhysics tPhysics = new TPhysics();
        if (tPhysicsOptional.isPresent()) {
            tPhysics = tPhysicsOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tPhysics;
    }

    /**
     * 更新
     * @param tPhysics
     * @return
     */
    public TPhysics update(TPhysics tPhysics) {
        tPhysicsRepository.save(tPhysics);
        return tPhysics;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tPhysicsRepository.deleteById(id);
    }

    /**
     * 添加一个物理性质
     * @param tPhysics
     * @return
     */
    public TPhysics save(TPhysics tPhysics) {
        return tPhysicsRepository.save(tPhysics);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TPhysics> findTPhysicsNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tPhysicsRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TPhysics> findTPhysicsQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tPhysicsRepository.findAll((Specification<TPhysics>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("phyRelativeUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAbsoluteUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyGreenDensityUnitMidu").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyBasicDensityUnitMidu").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirDryDensityUnitMidu").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAbsoluteDryDensityUnitMidu").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirDryingLineUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeDryLineUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirDryVolumeUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeDryVolumeUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirShrinkageUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirShrinkageChordwiseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirShrinkageRadialUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirShrinkageEdnwiseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyAirShrinkageVolumeUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeShrinkageChordwiseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeShrinkageRadialUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeShrinkageEdnwiseUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("phyWholeShrinkageVolumeUnitPercent").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tPhysicsRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tPhysicsRepository.deleteByPhyIdIn(ids);
    }
}
