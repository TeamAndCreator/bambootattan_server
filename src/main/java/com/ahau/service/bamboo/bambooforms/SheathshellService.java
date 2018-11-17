package com.ahau.service.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathshell;
import com.ahau.repository.bamboo.bambooforms.SheathshellRepository;
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
 * 箨片服务层接口
 * Created by: 张理
 * 2018-11-13
 */
@Transactional
@Service
public class SheathshellService {
    private final SheathshellRepository sheathshellRepository;

    @Autowired
    public SheathshellService(SheathshellRepository sheathshellRepository) {this.sheathshellRepository = sheathshellRepository;}

    /**
     * 查询所有箨片列表
     * @return
     */
    public List<Sheathshell> findAll() {return sheathshellRepository.findAll();}

    /**
     * 查询一个箨片
     * @param id
     * @return
     */
    public Sheathshell findById(Long id) {
        Optional<Sheathshell> sheathshellOptional = sheathshellRepository.findById(id);
        Sheathshell sheathshell = new Sheathshell();
        if (sheathshellOptional.isPresent()) {
            sheathshell = sheathshellOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return sheathshell;
    }

    /**
     * 更新
     * @param sheathshell
     * @return
     */
    public Sheathshell update(Sheathshell sheathshell) {
        sheathshellRepository.save(sheathshell);
        return sheathshell;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        sheathshellRepository.deleteById(id);
    }

    /**
     * 添加一个箨片
     * @param sheathshell
     * @return
     */
    public Sheathshell save(Sheathshell sheathshell) {
        return sheathshellRepository.save(sheathshell);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Sheathshell> findSheathshellNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return sheathshellRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Sheathshell> findSheathshellQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
        return sheathshellRepository.findAll((Specification<Sheathshell>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.like(root.get("sheathShellShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathShellColor").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathShellTopShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathShellBaseShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathShellMargin").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathShellBackPowder").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("sheathRatioOf").as(String.class), "%" + search + "%"));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.or(list.toArray(p));
        },pageable);
        } else {
            return sheathshellRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        sheathshellRepository.deleteBySheShellIdIn(ids);
    }
}
