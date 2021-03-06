package com.ahau.service.bamboo.bambooforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bambooforms.Leaf;
import com.ahau.repository.bamboo.bambooforms.LeafRepository;
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
 * 竹叶服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class LeafService {
    private final LeafRepository leafRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
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
            LOGGER.debug("no exit!");
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
     * 添加一个竹叶
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
     * @param search
     * @return
     */
    public Page<Leaf> findLeafQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
        return leafRepository.findAll((Specification<Leaf>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.like(root.get("leafShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafLength").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafWidth").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafNum").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder .like(root.get("leafBack").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafMargin").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafTongueShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafTongueHeight").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafStalkLength").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafBaseShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("leafTopShape").as(String.class), "%" + search + "%"));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.or(list.toArray(p));
        },pageable);
    } else {
        return leafRepository.findAll(pageable);
    }
}

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        leafRepository.deleteByLeafIdIn(ids);
    }
}
