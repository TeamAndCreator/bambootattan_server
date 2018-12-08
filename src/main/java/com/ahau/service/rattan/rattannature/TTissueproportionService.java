package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TTissueproportion;
import com.ahau.repository.rattan.rattannature.TTissueproportionRepository;
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
 * 藤解剖性质_组织比量服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TTissueproportionService {
    private final TTissueproportionRepository tTissueproportionRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TTissueproportionService(TTissueproportionRepository tTissueproportionRepository) {this.tTissueproportionRepository = tTissueproportionRepository;}

    /**
     * 查询所有解剖性质_组织比量列表
     * @return
     */
    public List<TTissueproportion> findAll() {return tTissueproportionRepository.findAll();}

    /**
     * 查询一个解剖性质_组织比量
     * @param id
     * @return
     */
    public TTissueproportion findById(Long id) {
        Optional<TTissueproportion> tTissueproportionOptional = tTissueproportionRepository.findById(id);
        TTissueproportion tTissueproportion = new TTissueproportion();
        if (tTissueproportionOptional.isPresent()) {
            tTissueproportion = tTissueproportionOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tTissueproportion;
    }

    /**
     * 更新
     * @param tTissueproportion
     * @return
     */
    public TTissueproportion update(TTissueproportion tTissueproportion) {
        tTissueproportionRepository.save(tTissueproportion);
        return tTissueproportion;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tTissueproportionRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_组织比量
     * @param tTissueproportion
     * @return
     */
    public TTissueproportion save(TTissueproportion tTissueproportion) {
        return tTissueproportionRepository.save(tTissueproportion);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TTissueproportion> findTTissueproportionNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tTissueproportionRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TTissueproportion> findTTissueproportionQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tTissueproportionRepository.findAll((Specification<TTissueproportion>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return tTissueproportionRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tTissueproportionRepository.deleteByTpIdIn(ids);
    }
}
