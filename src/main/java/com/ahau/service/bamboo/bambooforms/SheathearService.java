package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathear;
import com.ahau.repository.bamboo.bambooforms.SheathearRepository;
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
 * 箨耳服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service
public class SheathearService {
    private final SheathearRepository sheathearRepository;

    @Autowired
    public SheathearService(SheathearRepository sheathearRepository) {this.sheathearRepository = sheathearRepository;}

    /**
     * 查询所有箨耳列表
     * @return
     */
    public List<Sheathear> findAll() {return sheathearRepository.findAll();}

    /**
     * 查询一个箨耳
     * @param id
     * @return
     */
    public Sheathear findById(Long id) {
        Optional<Sheathear> sheathearOptional = sheathearRepository.findById(id);
        Sheathear sheathear = new Sheathear();
        if (sheathearOptional.isPresent()) {
            sheathear = sheathearOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return sheathear;
    }

    /**
     * 更新
     * @param sheathear
     * @return
     */
    public Sheathear update(Sheathear sheathear) {
        sheathearRepository.save(sheathear);
        return sheathear;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        sheathearRepository.deleteById(id);
    }

    /**
     * 添加一个箨耳
     * @param sheathear
     * @return
     */
    public Sheathear save(Sheathear sheathear) {
        return sheathearRepository.save(sheathear);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Sheathear> findSheathearNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathearRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param sheathear
     * @return
     */
    public Page<Sheathear> findSheathearQuery(Integer page, Integer size, final Sheathear sheathear) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathearRepository.findAll((Specification<Sheathear>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != sheathear.getSheathEarDev() && !"".equals(sheathear.getSheathEarDev())) {
                list.add(criteriaBuilder.equal(root.get("sheathEarDev").as(String.class), sheathear.getSheathEarDev()));
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
        sheathearRepository.deleteBySheEarIdIn(ids);
    }
}
