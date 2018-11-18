package com.ahau.service.rattan.base;

import com.ahau.entity.rattan.base.RattanGenus;
import com.ahau.repository.rattan.base.RattanGenusRepository;
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
            System.out.println("no exit!");
        }
        return rattanGenus;
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
                list.add(criteriaBuilder.like(root.get("rattanGenusNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("rattanGenusNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("rattanGenusNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("rattanGenusNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("rattanGenusDesc").as(String.class), "%" + search + "%"));
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
