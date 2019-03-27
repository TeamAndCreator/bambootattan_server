package com.ahau.service.bamboo.bambooforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.bambooforms.Culm;
import com.ahau.entity.bamboo.base.Spec;
import com.ahau.repository.bamboo.bambooforms.CulmRepository;
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
import java.util.*;

/**
 * 竹秆服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class CulmService {
    private final CulmRepository culmRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public CulmService(CulmRepository culmRepository) {this.culmRepository = culmRepository;}

    /**
     * 查询所有竹秆列表
     * @return
     */
    public List<Culm> findAll() {return culmRepository.findAll();}

    /**
     * 查询一个竹秆
     * @param id
     * @return
     */
    public Culm findById(Long id) {
        Optional<Culm> culmOptional = culmRepository.findById(id);
        Culm culm = new Culm();
        if (culmOptional.isPresent()) {
            culm = culmOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return culm;
    }

    /**
     * 更新
     * @param culm
     * @return
     */
    public Culm update(Culm culm) {
        culmRepository.save(culm);
        return culm;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        culmRepository.deleteById(id);
    }

    /**
     * 添加一个竹秆
     * @param culm
     * @return
     */
    public Culm save(Culm culm) {
        return culmRepository.save(culm);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Culm> findCulmNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return culmRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Culm> findCulmQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
        return culmRepository.findAll((Specification<Culm>) (root, criteriaQuery, criteriaBuilder) -> {

            //用于暂时存放查询条件的集合
            List<Predicate> list = new ArrayList<>();
            list.add(criteriaBuilder.like(root.get("culmHeight").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("culmDiameter").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("culmColor").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("culmTop").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder .like(root.get("culmStem").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("internodeLength").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("internodeShape").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("internodeAerialRoot").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("internodeBack").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("internodeCulmWall").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("youngStemBack").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("youngStemPowder").as(String.class), "%" + search + "%"));
            list.add(criteriaBuilder.like(root.get("culmNode").as(String.class), "%" + search + "%"));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.or(list.toArray(p));
        },pageable);
        } else {
            return culmRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public  void  deleteByIds(List<Long> ids){
        culmRepository.deleteByCulmIdIn(ids);
    }






//    public Culm findBySpecId(Long specId){
//        return culmRepository.findBySpecId(specId);
//    }
//    public Set findBySpec(Long id) {
//        Set specSet=new HashSet(culmRepository.findBySpec(id));
//        return specSet;
//    }
//    public Culm findBySpec(Long specId){
//        return culmRepository.findBySpec(specId);
//    }
//    /**
//     * 添加竹秆信息时查找种，判断是否重复
//     * @param spec
//     * @return
//     */
//    public Culm findBySpec(Spec spec){
//        return culmRepository.findBySpec(spec);
//    }
}
