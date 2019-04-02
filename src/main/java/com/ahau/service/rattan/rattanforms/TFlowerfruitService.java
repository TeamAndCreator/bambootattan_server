package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TFlowerfruit;
import com.ahau.repository.rattan.rattanforms.TFlowerfruitRepository;
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

@Transactional
@Service
public class TFlowerfruitService {

    private final TFlowerfruitRepository tFlowerfruitRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public TFlowerfruitService(TFlowerfruitRepository tFlowerfruitRepository) {this.tFlowerfruitRepository = tFlowerfruitRepository;}

    /**
     * 查询所有花果形态列表
     * @return
     */
    public List<TFlowerfruit> findAll() {return tFlowerfruitRepository.findAll();}

    /**
     * 查询一个花果形态
     * @param id
     * @return
     */
    public TFlowerfruit findById(Long id) {
        Optional<TFlowerfruit> tFlowerfruitOptional = tFlowerfruitRepository.findById(id);
        TFlowerfruit tFlowerfruit = new TFlowerfruit();
        if (tFlowerfruitOptional.isPresent()) {
            tFlowerfruit = tFlowerfruitOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tFlowerfruit;
    }

    /**
     * 更新
     * @param tFlowerfruit
     * @return
     */
    public TFlowerfruit update(TFlowerfruit tFlowerfruit) {
        tFlowerfruitRepository.save(tFlowerfruit);
        return tFlowerfruit;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tFlowerfruitRepository.deleteById(id);
    }

    /**
     * 添加一个花果形态
     * @param tFlowerfruit
     * @return
     */
    public TFlowerfruit save(TFlowerfruit tFlowerfruit) {
        return tFlowerfruitRepository.save(tFlowerfruit);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TFlowerfruit> findTFlowerfruitNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tFlowerfruitRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TFlowerfruit> findTFlowerfruitQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tFlowerfruitRepository.findAll((Specification<TFlowerfruit>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return tFlowerfruitRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tFlowerfruitRepository.deleteByFloFruitIdIn(ids);
    }
}
