package com.ahau.service.bamboo.bamboonature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bamboonature.Tissueproportion;
import com.ahau.repository.bamboo.bamboonature.TissueproportionRepository;
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
 * 解剖性质_组织比量服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TissueproportionService {
    private final TissueproportionRepository tissueproportionRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TissueproportionService(TissueproportionRepository tissueproportionRepository) {this.tissueproportionRepository = tissueproportionRepository;}

    /**
     * 查询所有解剖性质_组织比量列表
     * @return
     */
    public List<Tissueproportion> findAll() {return tissueproportionRepository.findAll();}

    /**
     * 查询一个解剖性质_组织比量
     * @param id
     * @return
     */
    public Tissueproportion findById(Long id) {
        Optional<Tissueproportion> tissueproportionOptional = tissueproportionRepository.findById(id);
        Tissueproportion tissueproportion = new Tissueproportion();
        if (tissueproportionOptional.isPresent()) {
            tissueproportion = tissueproportionOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tissueproportion;
    }

    /**
     * 更新
     * @param tissueproportion
     * @return
     */
    public Tissueproportion update(Tissueproportion tissueproportion) {
        tissueproportionRepository.save(tissueproportion);
        return tissueproportion;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tissueproportionRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_组织比量
     * @param tissueproportion
     * @return
     */
    public Tissueproportion save(Tissueproportion tissueproportion) {
        return tissueproportionRepository.save(tissueproportion);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Tissueproportion> findTissueproportionNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tissueproportionRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Tissueproportion> findTissueproportionQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tissueproportionRepository.findAll((Specification<Tissueproportion>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("tpFiberPeoportionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("tpVesselProportionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("tpSieveTubeProportionUnitPercent").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("tpParenchymaCellProportionUnitPercent").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tissueproportionRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tissueproportionRepository.deleteByTpIdIn(ids);
    }
}
