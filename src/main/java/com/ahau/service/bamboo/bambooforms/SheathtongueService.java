package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathtongue;
import com.ahau.repository.bamboo.bambooforms.SheathtongueRepository;
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
 * 箨舌服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service
public class SheathtongueService {
    private final SheathtongueRepository sheathtongueRepository;

    @Autowired
    public SheathtongueService(SheathtongueRepository sheathtongueRepository) {this.sheathtongueRepository = sheathtongueRepository;}

    /**
     * 查询所有箨舌列表
     * @return
     */
    public List<Sheathtongue> findAll() {return sheathtongueRepository.findAll();}

    /**
     * 查询一个箨舌
     * @param id
     * @return
     */
    public Sheathtongue findById(Long id) {
        Optional<Sheathtongue> sheathtongueOptional = sheathtongueRepository.findById(id);
        Sheathtongue sheathtongue = new Sheathtongue();
        if (sheathtongueOptional.isPresent()) {
            sheathtongue = sheathtongueOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return sheathtongue;
    }

    /**
     * 更新
     * @param sheathtongue
     * @return
     */
    public Sheathtongue update(Sheathtongue sheathtongue) {
        sheathtongueRepository.save(sheathtongue);
        return sheathtongue;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        sheathtongueRepository.deleteById(id);
    }

    /**
     * 添加一个箨舌
     * @param sheathtongue
     * @return
     */
    public Sheathtongue save(Sheathtongue sheathtongue) {
        return sheathtongueRepository.save(sheathtongue);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Sheathtongue> findSheathtongueNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathtongueRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param sheathtongue
     * @return
     */
    public Page<Sheathtongue> findSheathtongueQuery(Integer page, Integer size, final Sheathtongue sheathtongue) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathtongueRepository.findAll((Specification<Sheathtongue>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != sheathtongue.getSheathTongueColor() && !"".equals(sheathtongue.getSheathTongueColor())) {
                list.add(criteriaBuilder.equal(root.get("sheathTongueColor").as(String.class),
                        sheathtongue.getSheathTongueColor()));
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
        sheathtongueRepository.deleteBySheTogIdIn(ids);
    }
}
