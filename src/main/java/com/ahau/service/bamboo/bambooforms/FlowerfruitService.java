package com.ahau.service.bamboo.bambooforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bambooforms.Flowerfruit;
import com.ahau.repository.bamboo.bambooforms.FlowerfruitRepository;
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
 * 花果形态服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class FlowerfruitService {
    private final FlowerfruitRepository flowerfruitRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public FlowerfruitService(FlowerfruitRepository flowerfruitRepository) {this.flowerfruitRepository = flowerfruitRepository;}

    /**
     * 查询所有花果形态列表
     * @return
     */
    public List<Flowerfruit> findAll() {return flowerfruitRepository.findAll();}

    /**
     * 查询一个花果形态
     * @param id
     * @return
     */
    public Flowerfruit findById(Long id) {
        Optional<Flowerfruit> flowerfruitOptional = flowerfruitRepository.findById(id);
        Flowerfruit flowerfruit = new Flowerfruit();
        if (flowerfruitOptional.isPresent()) {
            flowerfruit = flowerfruitOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return flowerfruit;
    }

    /**
     * 更新
     * @param flowerfruit
     * @return
     */
    public Flowerfruit update(Flowerfruit flowerfruit) {
        flowerfruitRepository.save(flowerfruit);
        return flowerfruit;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        flowerfruitRepository.deleteById(id);
    }

    /**
     * 添加一个花果形态
     * @param flowerfruit
     * @return
     */
    public Flowerfruit save(Flowerfruit flowerfruit) {
        return flowerfruitRepository.save(flowerfruit);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Flowerfruit> findFlowerfruitNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return flowerfruitRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Flowerfruit> findFlowerfruitQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
        return flowerfruitRepository.findAll((Specification<Flowerfruit>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.like(root.get("spikeletShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("spikeletBack").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("spikeletFloret").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("stamenNum").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder .like(root.get("glume").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("lodicule").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("palea").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("lemma").as(String.class), "%" + search + "%"));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.or(list.toArray(p));
        },pageable);
        } else {
            return flowerfruitRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        flowerfruitRepository.deleteByFloFruitIdIn(ids);
    }
}
