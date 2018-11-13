package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Leaf;
import com.ahau.repository.bamboo.bambooforms.LeafRepository;
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
 * 竹叶服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class LeafService {
    private final LeafRepository leafRepository;

    @Autowired
    public LeafService(LeafRepository leafRepository) {this.leafRepository = leafRepository;}

    /**
     * 查询所有竹叶列表
     * @return
     */
    public List<Leaf> findAll() {return leafRepository.findAll();}

    /**
     * 查询一个竹叶
     * @param id
     * @return
     */
    public Leaf findById(Long id) {
        Optional<Leaf> leafOptional = leafRepository.findById(id);
        Leaf leaf = new Leaf();
        if (leafOptional.isPresent()) {
            leaf = leafOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return leaf;
    }

    /**
     * 更新
     * @param leaf
     * @return
     */
    public Leaf update(Leaf leaf) {
        leafRepository.save(leaf);
        return leaf;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        leafRepository.deleteById(id);
    }

    /**
     * 添加一个种
     * @param leaf
     * @return
     */
    public Leaf save(Leaf leaf) {
        return leafRepository.save(leaf);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Leaf> findLeafNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return leafRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param leaf
     * @return
     */
    public Page<Leaf> findLeafQuery(Integer page, Integer size, final Leaf leaf) {
        Pageable pageable = PageRequest.of(page, size);
        return leafRepository.findAll((Specification<Leaf>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != leaf.getLeafShape() && !"".equals(leaf.getLeafShape())) {
                list.add(criteriaBuilder.equal(root.get("leafShape").as(String.class), leaf.getLeafShape()));
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
        leafRepository.deleteByLeafIdIn(ids);
    }
}
