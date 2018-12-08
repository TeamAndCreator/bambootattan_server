package com.ahau.service.bamboo.bamboonature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bamboonature.Cathermorphology;
import com.ahau.repository.bamboo.bamboonature.CathermorphologyRepository;
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
 * 解剖性质_导管形态特征服务层接口
 * Created by: 张理
 * 2018-11-14
 */
@Transactional
@Service
public class CathermorphologyService {
    private final CathermorphologyRepository cathermorphologyRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public CathermorphologyService(CathermorphologyRepository cathermorphologyRepository) {
        this.cathermorphologyRepository = cathermorphologyRepository;
    }

    /**
     * 查询所有解剖性质_导管形态特征列表
     *
     * @return
     */
    public List<Cathermorphology> findAll() {
        return cathermorphologyRepository.findAll();
    }

    /**
     * 查询一个解剖性质_导管形态特征
     *
     * @param id
     * @return
     */
    public Cathermorphology findById(Long id) {
        Optional<Cathermorphology> cathermorphologyOptional = cathermorphologyRepository.findById(id);
        Cathermorphology cathermorphology = new Cathermorphology();
        if (cathermorphologyOptional.isPresent()) {
            cathermorphology = cathermorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return cathermorphology;
    }

    /**
     * 更新
     *
     * @param cathermorphology
     * @return
     */
    public Cathermorphology update(Cathermorphology cathermorphology) {
        cathermorphologyRepository.save(cathermorphology);
        return cathermorphology;
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        cathermorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_导管形态特征
     *
     * @param cathermorphology
     * @return
     */
    public Cathermorphology save(Cathermorphology cathermorphology) {
        return cathermorphologyRepository.save(cathermorphology);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<Cathermorphology> findCathermorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return cathermorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Cathermorphology> findCathermorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return cathermorphologyRepository.findAll((Specification<Cathermorphology>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("chmCatheterLenghtUnitMicrom").as(Double.class), Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chmCatheterDiameterUnitMicrom").as(Double.class), Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chmCatheterDensityUnitVcmidu").as(Double.class), Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("chmIndex").as(Double.class), Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return cathermorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        cathermorphologyRepository.deleteByChmIdIn(ids);
    }


}
