package com.ahau.service;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.repository.GenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 描述：服务层接口
 *
 * @author 张理
 * 2018-11-3 19:22
 */
@Transactional
@Service
public class GenusService {

    private final GenusRepository genusRepository;

    @Autowired
    public GenusService(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    /**
     * 查询所有属
     *
     * @return
     */
    public List<Genus> findAll() {
        return genusRepository.findAll();
    }

    /**
     * 查询一个属
     *
     * @param id
     * @return
     */
    public Genus findById(Long id) {

        Optional<Genus> genusOptional = genusRepository.findById(id);
        Genus genus = new Genus();
        if (genusOptional.isPresent()) {
            genus = genusOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return genus;
    }

    /**
     * 更新
     *
     * @param genus
     * @return
     */
    public Genus update(Genus genus) {
        genusRepository.save(genus);
        return genus;
    }

    /**
     * 添加一个属
     *
     * @param genus
     * @return
     */
    public Genus save(Genus genus) {
        return genusRepository.save(genus);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        genusRepository.deleteById(id);
    }


    public Page<Genus> findGenusNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);



        return genusRepository.findAll(pageable);


    }

    public Page<Genus> findGenusQuery(Integer page, Integer size, final Genus genus) {
        Pageable pageable = PageRequest.of(page, size);
        return genusRepository.findAll((Specification<Genus>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != genus.getGenusNameCh() && !"".equals(genus.getGenusNameCh())) {
                list.add(criteriaBuilder.equal(root.get("genusNameCh").as(String.class), genus.getGenusNameCh()));
            }

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        },pageable);
    }

}
