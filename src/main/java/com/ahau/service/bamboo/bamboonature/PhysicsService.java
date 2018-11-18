package com.ahau.service.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Physics;
import com.ahau.repository.bamboo.bamboonature.PhysicsRepository;
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
 * 物理性质服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class PhysicsService {
    private final PhysicsRepository physicsRepository;

    @Autowired
    public PhysicsService(PhysicsRepository physicsRepository) {this.physicsRepository = physicsRepository;}

    /**
     * 查询所有物理性质列表
     * @return
     */
    public List<Physics> findAll() {return physicsRepository.findAll();}

    /**
     * 查询一个物理性质
     * @param id
     * @return
     */
    public Physics findById(Long id) {
        Optional<Physics> physicsOptional = physicsRepository.findById(id);
        Physics physics = new Physics();
        if (physicsOptional.isPresent()) {
            physics = physicsOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return physics;
    }

    /**
     * 更新
     * @param physics
     * @return
     */
    public Physics update(Physics physics) {
        physicsRepository.save(physics);
        return physics;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        physicsRepository.deleteById(id);
    }

    /**
     * 添加一个物理性质
     * @param physics
     * @return
     */
    public Physics save(Physics physics) {
        return physicsRepository.save(physics);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Physics> findPhysicsNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return physicsRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Physics> findPhysicsQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return physicsRepository.findAll((Specification<Physics>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return physicsRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        physicsRepository.deleteByPhyIdIn(ids);
    }
}
