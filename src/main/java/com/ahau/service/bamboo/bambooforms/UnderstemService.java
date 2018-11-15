package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Understem;
import com.ahau.repository.bamboo.bambooforms.UnderstemRepository;
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
 * 地下茎服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service

public class UnderstemService {
    private final UnderstemRepository understemRepository;

    @Autowired
    public UnderstemService(UnderstemRepository understemRepository) {this.understemRepository = understemRepository;}

    /**
     * 查询所有地下茎列表
     * @return
     */
    public List<Understem> findAll() {return understemRepository.findAll();}

    /**
     * 查询一个地下茎
     * @param id
     * @return
     */
    public Understem findById(Long id) {
        Optional<Understem> understemOptional = understemRepository.findById(id);
        Understem understem = new Understem();
        if (understemOptional.isPresent()) {
            understem = understemOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return understem;
    }

    /**
     * 更新
     * @param understem
     * @return
     */
    public Understem update(Understem understem) {
        understemRepository.save(understem);
        return understem;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        understemRepository.deleteById(id);
    }

    /**
     * 添加一个地下茎
     * @param understem
     * @return
     */
    public Understem save(Understem understem) {
        return understemRepository.save(understem);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Understem> findUnderstemNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return understemRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param understem
     * @return
     */
    public Page<Understem> findUnderstemQuery(Integer page, Integer size, final Understem understem) {
        Pageable pageable = PageRequest.of(page, size);
        return understemRepository.findAll((Specification<Understem>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != understem.getUnderStem() && !"".equals(understem.getUnderStem())) {
                list.add(criteriaBuilder.equal(root.get("underStem").as(String.class),
                        understem.getUnderStem()));
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
        understemRepository.deleteByUnderStemIdIn(ids);
    }
}
