package com.ahau.service.unit;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.unit.Unit;
import com.ahau.repository.unit.UnitRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@Transactional
@Service
public class UnitService {
    private final UnitRepository unitRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public UnitService(UnitRepository unitRepository) {this.unitRepository = unitRepository;}

    /**
     * 查询所有单位列表
     * @return
     */
    public List<Unit> findAll() {return unitRepository.findAll();}

    /**
     * 查询一个单位
     * @param id
     * @return
     */
    public Unit findById(Long id) {
        Optional<Unit> unitOptional = unitRepository.findById(id);
        Unit unit = new Unit();
        if (unitOptional.isPresent()) {
            unit = unitOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return unit;
    }

    /**
     * 更新
     * @param unit
     * @return
     */
    public Unit update(Unit unit) {
        unitRepository.save(unit);
        return unit;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        unitRepository.deleteById(id);
    }

    /**
     * 添加一个单位
     * @param unit
     * @return
     */
    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Unit> findUnitNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return unitRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Unit> findUnitQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return unitRepository.findAll((Specification<Unit>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("unitEnglish").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("unitSymbol").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("unitSymbolOther").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return unitRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        unitRepository.deleteByUnitIdIn(ids);
    }
}
