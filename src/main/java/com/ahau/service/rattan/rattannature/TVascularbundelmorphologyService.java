package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TVascularbundelmorphology;
import com.ahau.repository.rattan.rattannature.TVascularbundelmorphologyRepository;
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
 * 藤解剖性质_维管束形态特征
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TVascularbundelmorphologyService {
    private final TVascularbundelmorphologyRepository tVascularbundelmorphologyRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TVascularbundelmorphologyService(TVascularbundelmorphologyRepository tVascularbundelmorphologyRepository) {this.tVascularbundelmorphologyRepository = tVascularbundelmorphologyRepository;}

    /**
     * 查询所有解剖性质_维管束形态特征列表
     * @return
     */
    public List<TVascularbundelmorphology> findAll() {return tVascularbundelmorphologyRepository.findAll();}

    /**
     * 查询一个解剖性质_维管束形态特征
     * @param id
     * @return
     */
    public TVascularbundelmorphology findById(Long id) {
        Optional<TVascularbundelmorphology> tVascularbundelmorphologyOptional = tVascularbundelmorphologyRepository.findById(id);
        TVascularbundelmorphology tVascularbundelmorphology = new TVascularbundelmorphology();
        if (tVascularbundelmorphologyOptional.isPresent()) {
            tVascularbundelmorphology = tVascularbundelmorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tVascularbundelmorphology;
    }

    /**
     * 更新
     * @param tVascularbundelmorphology
     * @return
     */
    public TVascularbundelmorphology update(TVascularbundelmorphology tVascularbundelmorphology) {
        tVascularbundelmorphologyRepository.save(tVascularbundelmorphology);
        return tVascularbundelmorphology;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tVascularbundelmorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_维管束形态特征
     * @param tVascularbundelmorphology
     * @return
     */
    public TVascularbundelmorphology save(TVascularbundelmorphology tVascularbundelmorphology) {
        return tVascularbundelmorphologyRepository.save(tVascularbundelmorphology);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TVascularbundelmorphology> findTVascularbundelmorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tVascularbundelmorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TVascularbundelmorphology> findTVascularbundelmorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tVascularbundelmorphologyRepository.findAll((Specification<TVascularbundelmorphology>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("vbmRadialDiameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("vbmChordDiameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("vbmDensityUnitVcmidu").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tVascularbundelmorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tVascularbundelmorphologyRepository.deleteByVbmIdIn(ids);
    }
}
