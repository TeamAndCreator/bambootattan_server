package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Culm;
import com.ahau.repository.bamboo.bambooforms.CulmRepository;
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
 * 竹秆服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class CulmService {
    private final CulmRepository culmRepository;

    @Autowired
    public CulmService(CulmRepository culmRepository) {this.culmRepository = culmRepository;}

    /**
     * 查询所有竹秆列表
     * @return
     */
    public List<Culm> findAll() {return culmRepository.findAll();}

    /**
     * 查询一个竹秆
     * @param id
     * @return
     */
    public Culm findById(Long id) {
        Optional<Culm> culmOptional = culmRepository.findById(id);
        Culm culm = new Culm();
        if (culmOptional.isPresent()) {
            culm = culmOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return culm;
    }

    /**
     * 更新
     * @param culm
     * @return
     */
    public Culm update(Culm culm) {
        culmRepository.save(culm);
        return culm;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        culmRepository.deleteById(id);
    }

    /**
     * 添加一个竹秆
     * @param culm
     * @return
     */
    public Culm save(Culm culm) {
        return culmRepository.save(culm);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Culm> findCulmNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return culmRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param culm
     * @return
     */
    public Page<Culm> findCulmQuery(Integer page, Integer size, final Culm culm) {
        Pageable pageable = PageRequest.of(page, size);
        return culmRepository.findAll((Specification<Culm>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != culm.getCulmHeight() && !"".equals(culm.getCulmHeight())) {
                list.add(criteriaBuilder.equal(root.get("culmHeight").as(String.class), culm.getCulmHeight()));
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
        culmRepository.deleteByCulmIdIn(ids);
    }
}
