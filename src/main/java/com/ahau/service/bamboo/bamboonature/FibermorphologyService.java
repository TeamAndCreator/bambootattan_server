package com.ahau.service.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Fibermorphology;
import com.ahau.repository.bamboo.bamboonature.FibermorphologyRepository;
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
 * 解剖性质_纤维形态特征服务层接口
 * Created by: 张理
 * 2018-11-17
 */
@Transactional
@Service
public class FibermorphologyService {
    private final FibermorphologyRepository fibermorphologyRepository;

    @Autowired
    public FibermorphologyService(FibermorphologyRepository fibermorphologyRepository) {this.fibermorphologyRepository = fibermorphologyRepository;}

    /**
     * 查询所有解剖性质_纤维形态特征列表
     * @return
     */
    public List<Fibermorphology> findAll() {return fibermorphologyRepository.findAll();}

    /**
     * 查询一个解剖性质_纤维形态特征
     * @param id
     * @return
     */
    public Fibermorphology findById(Long id) {
        Optional<Fibermorphology> fibermorphologyOptional = fibermorphologyRepository.findById(id);
        Fibermorphology fibermorphology = new Fibermorphology();
        if (fibermorphologyOptional.isPresent()) {
            fibermorphology = fibermorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return fibermorphology;
    }

    /**
     * 更新
     * @param fibermorphology
     * @return
     */
    public Fibermorphology update(Fibermorphology fibermorphology) {
        fibermorphologyRepository.save(fibermorphology);
        return fibermorphology;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        fibermorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_纤维形态特征
     * @param fibermorphology
     * @return
     */
    public Fibermorphology save(Fibermorphology fibermorphology) {
        return fibermorphologyRepository.save(fibermorphology);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Fibermorphology> findFibermorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return fibermorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Fibermorphology> findFibermorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return fibermorphologyRepository.findAll((Specification<Fibermorphology>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("fmLengthUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmWidthUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmDwallThicknessUnitMicron").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmLetWidthRatio").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmCavityDeameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmWallCavityRatio").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("fmCavityDiameterRatio").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return fibermorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        fibermorphologyRepository.deleteByFmIdIn(ids);
    }
}
