package com.ahau.service.rattan.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.base.RattanGenus;
import com.ahau.repository.rattan.base.RattanGenusRepository;
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
 *  藤属服务层接口
 *  Created by: 张理
 *  2018-11-18
 */
@Transactional
@Service
public class RattanGenusService {
    private final RattanGenusRepository rattanGenusRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public RattanGenusService(RattanGenusRepository rattanGenusRepository) {
        this.rattanGenusRepository = rattanGenusRepository;
    }

    /**
     * 查询所有属
     *
     * @return
     */
    public List<RattanGenus> findAll() {
        return rattanGenusRepository.findAll();
    }

    /**
     * 查询一个属
     *
     * @param id
     * @return
     */
    public RattanGenus findById(Long id) {

        Optional<RattanGenus> rattanGenusOptional = rattanGenusRepository.findById(id);
        RattanGenus rattanGenus = new RattanGenus();
        if (rattanGenusOptional.isPresent()) {
            rattanGenus = rattanGenusOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return rattanGenus;
    }

    /**
     * 判断所有的数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh){
        return rattanGenusRepository.isNameChExisted(nameCh)>0;
    }

    /**
     * 判断不包括指定种的其他数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh,Long genusId){
        return rattanGenusRepository.isNameChExisted(nameCh,genusId)>0;
    }


    /**
     * 更新
     *
     * @param rattanGenus
     * @return
     */
    public RattanGenus update(RattanGenus rattanGenus) {
        rattanGenusRepository.save(rattanGenus);
        return rattanGenus;
    }

    /**
     * 添加一个属
     *
     * @param rattanGenus
     * @return
     */
    public RattanGenus save(RattanGenus rattanGenus) {
        return rattanGenusRepository.save(rattanGenus);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        rattanGenusRepository.deleteById(id);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<RattanGenus> findRattanGenusNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return rattanGenusRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<RattanGenus> findRattanGenusQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return rattanGenusRepository.findAll((Specification<RattanGenus>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("genusNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNotagDesc").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return rattanGenusRepository.findAll(pageable);
        }

    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        rattanGenusRepository.deleteByGenusIdIn(ids);
    }
}
