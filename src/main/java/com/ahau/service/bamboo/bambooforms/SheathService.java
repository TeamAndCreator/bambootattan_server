package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheath;
import com.ahau.repository.bamboo.bambooforms.SheathRepository;
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
 * 箨鞘服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service
public class SheathService {
    private final SheathRepository sheathRepository;

    @Autowired
    public SheathService(SheathRepository sheathRepository) {this.sheathRepository = sheathRepository;}

    /**
     * 查询所有箨鞘列表
     * @return
     */
    public List<Sheath> findAll() {return sheathRepository.findAll();}

    /**
     * 查询一个箨鞘
     * @param id
     * @return
     */
    public Sheath findById(Long id) {
        Optional<Sheath> sheathOptional = sheathRepository.findById(id);
        Sheath sheath = new Sheath();
        if (sheathOptional.isPresent()) {
            sheath = sheathOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return sheath;
    }

    /**
     * 更新
     * @param sheath
     * @return
     */
    public Sheath update(Sheath sheath) {
        sheathRepository.save(sheath);
        return sheath;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        sheathRepository.deleteById(id);
    }

    /**
     * 添加一个箨鞘
     * @param sheath
     * @return
     */
    public Sheath save(Sheath sheath) {
        return sheathRepository.save(sheath);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Sheath> findSheathNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Sheath> findSheathQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
        return sheathRepository.findAll((Specification<Sheath>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.like(root.get("sheathShedTime").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathChar").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathTopForm").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathBackPowder").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathMarginForm").as(String.class), "%" + search + "%"));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.or(list.toArray(p));
        },pageable);
        } else {
            return sheathRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        sheathRepository.deleteBySheIdIn(ids);
    }
}
