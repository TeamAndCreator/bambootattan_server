package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Flowerfruit;
import com.ahau.repository.bamboo.bambooforms.FlowerfruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
            System.out.println("no exit!");
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
     * @param flowerfruit
     * @return
     */
    public Page<Flowerfruit> findFlowerfruitQuery(Integer page, Integer size, final Flowerfruit flowerfruit) {
        Pageable pageable = PageRequest.of(page, size);
        return flowerfruitRepository.findAll((Specification<Flowerfruit>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != flowerfruit.getSpikeletShape() && !"".equals(flowerfruit.getSpikeletShape())) {
                list.add(criteriaBuilder.equal(root.get("spikeletShape").as(String.class), flowerfruit.getSpikeletShape()));
            }

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        },pageable);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        flowerfruitRepository.deleteByFloFruitIdIn(ids);
    }
}
