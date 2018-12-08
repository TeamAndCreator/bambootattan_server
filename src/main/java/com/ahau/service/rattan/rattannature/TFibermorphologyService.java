package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TFibermorphology;
import com.ahau.repository.rattan.rattannature.TFibermorphologyRepository;
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
 * 藤解剖性质_纤维形态特征服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TFibermorphologyService {
    private final TFibermorphologyRepository tFibermorphologyRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public TFibermorphologyService(TFibermorphologyRepository tFibermorphologyRepository) {this.tFibermorphologyRepository = tFibermorphologyRepository;}

    /**
     * 查询所有解剖性质_纤维形态特征列表
     * @return
     */
    public List<TFibermorphology> findAll() {return tFibermorphologyRepository.findAll();}

    /**
     * 查询一个解剖性质_纤维形态特征
     * @param id
     * @return
     */
    public TFibermorphology findById(Long id) {
        Optional<TFibermorphology> tFibermorphologyOptional = tFibermorphologyRepository.findById(id);
        TFibermorphology tFibermorphology = new TFibermorphology();
        if (tFibermorphologyOptional.isPresent()) {
            tFibermorphology = tFibermorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tFibermorphology;
    }

    /**
     * 更新
     * @param tFibermorphology
     * @return
     */
    public TFibermorphology update(TFibermorphology tFibermorphology) {
        tFibermorphologyRepository.save(tFibermorphology);
        return tFibermorphology;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tFibermorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_纤维形态特征
     * @param tFibermorphology
     * @return
     */
    public TFibermorphology save(TFibermorphology tFibermorphology) {
        return tFibermorphologyRepository.save(tFibermorphology);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TFibermorphology> findTFibermorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tFibermorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TFibermorphology> findTFibermorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tFibermorphologyRepository.findAll((Specification<TFibermorphology>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("fmLengthUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmWidthUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmDwallThicknessUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmLetWidthRatio").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmCavityDeameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmWallCavityRatio").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmCavityDiameterRatio").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tFibermorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tFibermorphologyRepository.deleteByFmIdIn(ids);
    }
}
