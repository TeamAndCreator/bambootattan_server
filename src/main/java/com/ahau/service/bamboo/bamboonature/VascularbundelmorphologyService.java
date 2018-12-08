package com.ahau.service.bamboo.bamboonature;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bamboonature.Vascularbundelmorphology;
import com.ahau.repository.bamboo.bamboonature.VascularbundelmorphologyRepository;
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

/**
 * 解剖性质_维管束形态特征服务层接口
 * Created by: 张理
 * 2018-11-18
 */
@Transactional
@Service
public class VascularbundelmorphologyService {
    private final VascularbundelmorphologyRepository vascularbundelmorphologyRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public VascularbundelmorphologyService(VascularbundelmorphologyRepository vascularbundelmorphologyRepository) {this.vascularbundelmorphologyRepository = vascularbundelmorphologyRepository;}

    /**
     * 查询所有解剖性质_维管束形态特征列表
     * @return
     */
    public List<Vascularbundelmorphology> findAll() {return vascularbundelmorphologyRepository.findAll();}

    /**
     * 查询一个解剖性质_维管束形态特征
     * @param id
     * @return
     */
    public Vascularbundelmorphology findById(Long id) {
        Optional<Vascularbundelmorphology> vascularbundelmorphologyOptional = vascularbundelmorphologyRepository.findById(id);
        Vascularbundelmorphology vascularbundelmorphology = new Vascularbundelmorphology();
        if (vascularbundelmorphologyOptional.isPresent()) {
            vascularbundelmorphology = vascularbundelmorphologyOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return vascularbundelmorphology;
    }

    /**
     * 更新
     * @param vascularbundelmorphology
     * @return
     */
    public Vascularbundelmorphology update(Vascularbundelmorphology vascularbundelmorphology) {
        vascularbundelmorphologyRepository.save(vascularbundelmorphology);
        return vascularbundelmorphology;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        vascularbundelmorphologyRepository.deleteById(id);
    }

    /**
     * 添加一个解剖性质_维管束形态特征
     * @param vascularbundelmorphology
     * @return
     */
    public Vascularbundelmorphology save(Vascularbundelmorphology vascularbundelmorphology) {
        return vascularbundelmorphologyRepository.save(vascularbundelmorphology);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Vascularbundelmorphology> findVascularbundelmorphologyNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return vascularbundelmorphologyRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Vascularbundelmorphology> findVascularbundelmorphologyQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return vascularbundelmorphologyRepository.findAll((Specification<Vascularbundelmorphology>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("vbmRadialDiameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("vbmChordDiameterUnitMicrom").as(Double.class),Double.valueOf(search)));
                list.add(criteriaBuilder.equal(root.get("vbmDensityUnitVcmidu").as(Double.class),Double.valueOf(search)));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return vascularbundelmorphologyRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        vascularbundelmorphologyRepository.deleteByVbmIdIn(ids);
    }
}
