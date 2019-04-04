package com.ahau.service.rattan.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.base.RattanSpec;
import com.ahau.repository.rattan.base.RattanSpecRepository;
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
import java.util.*;

/**
 *  藤种服务层接口
 *  Created by: 张理
 *  2018-11-18
 */
@Transactional
@Service
public class RattanSpecService {
    private final RattanSpecRepository rattanSpecRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public RattanSpecService(RattanSpecRepository rattanSpecRepository) {
        this.rattanSpecRepository = rattanSpecRepository;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    public List<RattanSpec> findAll() {
        return rattanSpecRepository.findAll();
    }

    /**
     * 查询一个种
     *
     * @param id
     * @return
     */
    public RattanSpec findById(Long id) {
        Optional<RattanSpec> rattanSpecOptional = rattanSpecRepository.findById(id);
        RattanSpec rattanSpec = new RattanSpec();
        if (rattanSpecOptional.isPresent()) {
            rattanSpec = rattanSpecOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return rattanSpec;
    }

    /**
     * 判断所有的数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh){
        return rattanSpecRepository.isNameChExisted(nameCh)>0;
    }

    /**
     * 判断不包括指定种的其他数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh,Long specId){
        return rattanSpecRepository.isNameChExisted(nameCh,specId)>0;
    }

    /**
     * 更新
     *
     * @param rattanSpec
     * @return
     */
    public RattanSpec update(RattanSpec rattanSpec) {
        rattanSpecRepository.save(rattanSpec);
        return rattanSpec;
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        rattanSpecRepository.deleteById(id);
    }

    /**
     * 添加一个种
     *
     * @param rattanSpec
     * @return
     */
    public RattanSpec save(RattanSpec rattanSpec) {
        return rattanSpecRepository.save(rattanSpec);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<RattanSpec> findRattanSpecNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return rattanSpecRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<RattanSpec> findRattanSpecQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return rattanSpecRepository.findAll((Specification<RattanSpec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specLocation").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("addTime").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return rattanSpecRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        rattanSpecRepository.deleteBySpecIdIn(ids);
    }

    /**
     * 查找RattanSpec中的文件
     * @param id
     * @return
     */
    public Set getFiles(Long id) {
        Set filesSet=new HashSet(rattanSpecRepository.getFiles(id));
        return filesSet;
    }
}
