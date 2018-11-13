package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathnode;
import com.ahau.repository.bamboo.bambooforms.SheathnodeRepository;
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
 * 箨环服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service
public class SheathnodeService {
    private final SheathnodeRepository sheathnodeRepository;

    @Autowired
    public SheathnodeService(SheathnodeRepository sheathnodeRepository) {this.sheathnodeRepository = sheathnodeRepository;}

    /**
     * 查询所有箨环列表
     * @return
     */
    public List<Sheathnode> findAll() {return sheathnodeRepository.findAll();}

    /**
     * 查询一个箨环
     * @param id
     * @return
     */
    public Sheathnode findById(Long id) {
        Optional<Sheathnode> sheathnodeOptional = sheathnodeRepository.findById(id);
        Sheathnode sheathnode = new Sheathnode();
        if (sheathnodeOptional.isPresent()) {
            sheathnode = sheathnodeOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return sheathnode;
    }

    /**
     * 更新
     * @param sheathnode
     * @return
     */
    public Sheathnode update(Sheathnode sheathnode) {
        sheathnodeRepository.save(sheathnode);
        return sheathnode;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        sheathnodeRepository.deleteById(id);
    }

    /**
     * 添加一个种
     * @param sheathnode
     * @return
     */
    public Sheathnode save(Sheathnode sheathnode) {
        return sheathnodeRepository.save(sheathnode);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Sheathnode> findSheathnodeNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathnodeRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param sheathnode
     * @return
     */
    public Page<Sheathnode> findSheathnodeQuery(Integer page, Integer size, final Sheathnode sheathnode) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathnodeRepository.findAll((Specification<Sheathnode>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != sheathnode.getSheathNode() && !"".equals(sheathnode.getSheathNode())) {
                list.add(criteriaBuilder.equal(root.get("sheathNode").as(String.class), sheathnode.getSheathNode()));
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
        sheathnodeRepository.deleteBySheNodeIdIn(ids);
    }
}
