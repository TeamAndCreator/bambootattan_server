package com.ahau.service.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import com.ahau.repository.bamboo.base.SpecRepository;
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
 * 竹种服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class SpecService {

    private final SpecRepository specRepository;

    @Autowired
    public SpecService(SpecRepository specRepository) {this.specRepository = specRepository;}

    /**
     * 查询所有种列表
     * @return
     */
    public List<Spec> findAll() {return specRepository.findAll();}

    /**
     * 查询一个种
     * @param id
     * @return
     */
    public Spec findById(Long id) {
        Optional<Spec> specOptional = specRepository.findById(id);
        Spec spec = new Spec();
        if (specOptional.isPresent()) {
            spec = specOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return spec;
    }

    /**
     * 更新
     * @param spec
     * @return
     */
    public Spec update(Spec spec) {
        specRepository.save(spec);
        return spec;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        specRepository.deleteById(id);
    }

    /**
     * 添加一个种
     * @param spec
     * @return
     */
    public Spec save(Spec spec) {
        return specRepository.save(spec);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Spec> findSpecNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return specRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param spec
     * @return
     */
    public Page<Spec> findSpecQuery(Integer page, Integer size, final Spec spec) {
        Pageable pageable = PageRequest.of(page, size);
        return specRepository.findAll((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != spec.getSpecNameCh() && !"".equals(spec.getSpecNameCh())) {
                list.add(criteriaBuilder.equal(root.get("genusNameCh").as(String.class), spec.getSpecNameCh()));
            }

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        },pageable);
    }

    /**
     * 批量删除
     * @param ids
     */
    public  void  deleteByIds(List<Long> ids){
        specRepository.deleteBySpecIdIn(ids);
    }
}
