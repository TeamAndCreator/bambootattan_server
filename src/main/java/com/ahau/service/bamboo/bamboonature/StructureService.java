package com.ahau.service.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Structure;
import com.ahau.repository.bamboo.bamboonature.StructureRepository;
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
 * 结构性质服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class StructureService {
    private final StructureRepository structureRepository;

    @Autowired
    public StructureService(StructureRepository structureRepository) {this.structureRepository = structureRepository;}

    /**
     * 查询所有结构性质列表
     * @return
     */
    public List<Structure> findAll() {return structureRepository.findAll();}

    /**
     * 查询一个结构性质
     * @param id
     * @return
     */
    public Structure findById(Long id) {
        Optional<Structure> structureOptional = structureRepository.findById(id);
        Structure structure = new Structure();
        if (structureOptional.isPresent()) {
            structure = structureOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return structure;
    }

    /**
     * 更新
     * @param structure
     * @return
     */
    public Structure update(Structure structure) {
        structureRepository.save(structure);
        return structure;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        structureRepository.deleteById(id);
    }

    /**
     * 添加一个结构性质
     * @param structure
     * @return
     */
    public Structure save(Structure structure) {
        return structureRepository.save(structure);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Structure> findStructureNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return structureRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Structure> findStructureQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return structureRepository.findAll((Specification<Structure>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("stStemDiameterUnitMm").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("stWallThicknessUnitMm").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("stMaximumInternodeLengthUnitCm").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("stRattanDiameterUnitMm").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return structureRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        structureRepository.deleteByStIdIn(ids);
    }
}
