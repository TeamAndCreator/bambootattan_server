package com.ahau.service.rattan.rattannature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattannature.TCathetermorphology;
import com.ahau.repository.rattan.rattannature.TCathetermorphologyRepository;
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
 * 藤解剖性质_导管形态特征服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TCathetermorphologyService {
    private final TCathetermorphologyRepository tCathetermorphologyRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TCathetermorphologyService(TCathetermorphologyRepository tCathetermorphologyRepository) {
        this.tCathetermorphologyRepository = tCathetermorphologyRepository;
    }

    /**
     * 查询所有解剖性质_导管形态特征列表
     *
     * @return
     */
    public List<TCathetermorphology> findAll() {
        return tCathetermorphologyRepository.findAll();
    }

    /**
     * 查询一个解剖性质_导管形态特征
     *
     * @param id
     * @return
     */
    public TCathetermorphology findById(Long id) {
        Optional<TCathetermorphology> tCathetermorphologyOptional = tCathetermorphologyRepository.findById(id);
        TCathetermorphology tCathetermorphology = new TCathetermorphology();
        if (tCathetermorphologyOptional.isPresent()) {
            tCathetermorphology = tCathetermorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tCathetermorphology;
    }

    /**
     * 更新
     *
     * @param tCathetermorphology
     * @return
     */
    public TCathetermorphology update(TCathetermorphology tCathetermorphology) {
        tCathetermorphologyRepository.save(tCathetermorphology);
        return tCathetermorphology;
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        tCathetermorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_导管形态特征
     *
     * @param tCathetermorphology
     * @return
     */
    public TCathetermorphology save(TCathetermorphology tCathetermorphology) {
        return tCathetermorphologyRepository.save(tCathetermorphology);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<TCathetermorphology> findTCathetermorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tCathetermorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TCathetermorphology> findTCathetermorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tCathetermorphologyRepository.findAll((Specification<TCathetermorphology>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return tCathetermorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        tCathetermorphologyRepository.deleteByChmIdIn(ids);
    }
}
