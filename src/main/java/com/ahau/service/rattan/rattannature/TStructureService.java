package com.ahau.service.rattan.rattannature;

import com.ahau.entity.rattan.rattannature.TStructure;
import com.ahau.repository.rattan.rattannature.TStructureRepository;
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
 * 藤结构性质服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class TStructureService {
    private final TStructureRepository tStructureRepository;

    @Autowired
    public TStructureService(TStructureRepository tStructureRepository) {this.tStructureRepository = tStructureRepository;}

    /**
     * 查询所有结构性质列表
     * @return
     */
    public List<TStructure> findAll() {return tStructureRepository.findAll();}

    /**
     * 查询一个结构性质
     * @param id
     * @return
     */
    public TStructure findById(Long id) {
        Optional<TStructure> tStructureOptional = tStructureRepository.findById(id);
        TStructure tStructure = new TStructure();
        if (tStructureOptional.isPresent()) {
            tStructure = tStructureOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return tStructure;
    }

    /**
     * 更新
     * @param tStructure
     * @return
     */
    public TStructure update(TStructure tStructure) {
        tStructureRepository.save(tStructure);
        return tStructure;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tStructureRepository.deleteById(id);
    }

    /**
     * 添加一个结构性质
     * @param tStructure
     * @return
     */
    public TStructure save(TStructure tStructure) {
        return tStructureRepository.save(tStructure);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TStructure> findTStructureNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tStructureRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TStructure> findTStructureQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tStructureRepository.findAll((Specification<TStructure>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return tStructureRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tStructureRepository.deleteByStIdIn(ids);
    }
}
