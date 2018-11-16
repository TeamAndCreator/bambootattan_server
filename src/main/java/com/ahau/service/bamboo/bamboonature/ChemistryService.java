package com.ahau.service.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Chemistry;
import com.ahau.repository.bamboo.bamboonature.ChemistryRepository;
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
 * 化学性质服务层接口
 * Created by: 张理
 * 2018-11-14
 */
@Transactional
@Service
public class ChemistryService {
    private final ChemistryRepository chemistryRepository;

    @Autowired
    public ChemistryService(ChemistryRepository chemistryRepository) {this.chemistryRepository = chemistryRepository;}

    /**
     * 查询所有化学性质列表
     * @return
     */
    public List<Chemistry> findAll() {return chemistryRepository.findAll();}

    /**
     * 查询一个化学性质
     * @param id
     * @return
     */
    public Chemistry findById(Long id) {
        Optional<Chemistry> chemistryOptional = chemistryRepository.findById(id);
        Chemistry chemistry = new Chemistry();
        if (chemistryOptional.isPresent()) {
            chemistry = chemistryOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return chemistry;
    }

    /**
     * 更新
     * @param chemistry
     * @return
     */
    public Chemistry update(Chemistry chemistry) {
        chemistryRepository.save(chemistry);
        return chemistry;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        chemistryRepository.deleteById(id);
    }

    /**
     * 添加一个化学性质
     * @param chemistry
     * @return
     */
    public Chemistry save(Chemistry chemistry) {
        return chemistryRepository.save(chemistry);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Chemistry> findChemistryNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return chemistryRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param chemistry
     * @return
     */
    public Page<Chemistry> findChemistryQuery(Integer page, Integer size, final Chemistry chemistry) {
        Pageable pageable = PageRequest.of(page, size);
        return chemistryRepository.findAll((Specification<Chemistry>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            if (null != chemistry.getChemHolocelluloseUnitPercent() && !"".equals(chemistry.getChemHolocelluloseUnitPercent())) {
                list.add(criteriaBuilder.equal(root.get("chemHolocelluloseUnitPercent").as(String.class),
                        chemistry.getChemHolocelluloseUnitPercent()));
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
        chemistryRepository.deleteByChemIdIn(ids);
    }
}
