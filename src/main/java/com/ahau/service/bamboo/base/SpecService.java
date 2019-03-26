package com.ahau.service.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Spec;
import com.ahau.entity.file.Files;
import com.ahau.repository.bamboo.base.SpecRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springfox.documentation.annotations.Cacheable;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.*;

/**
 * 竹种服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
@CacheConfig(cacheNames = "spec")
public class SpecService {
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    private final SpecRepository specRepository;

    @Autowired
    public SpecService(SpecRepository specRepository) {
        this.specRepository = specRepository;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    //@Cacheable(value = "specCache")
    public List<Spec> findAll() {
        return specRepository.findAll();
    }

    /**
     * 查询一个种
     *
     * @param id
     * @return
     */
    public Spec findById(Long id) {
        Optional<Spec> specOptional = specRepository.findById(id);
        Spec spec = new Spec();
        if (specOptional.isPresent()) {
            spec = specOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return spec;
    }

    /**
     * 更新
     *
     * @param spec
     * @return
     */
    public Spec update(Spec spec) {
        specRepository.save(spec);
        return spec;
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id) {
        specRepository.deleteById(id);
    }

    /**
     * 添加一个种
     *
     * @param spec
     * @return
     */
    public Spec save(Spec spec) {
        return specRepository.save(spec);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<Spec> findSpecNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return specRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findSpecQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAll((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        specRepository.deleteBySpecIdIn(ids);
    }

    /**
     * 查找Spec中的文件
     * @param id
     * @return
     */
    public Set getFiles(Long id) {
        Set filesSet=new HashSet(specRepository.getFiles(id));
        return filesSet;
    }

    /**
     *  分页有条件查找（不包含已有地下茎的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutUnderstem(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutUnderstem((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutUnderstem(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有竹秆的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutCulm(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutCulm((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutCulm(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有花果形态的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutFlowerfruit(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutFlowerfruit((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutFlowerfruit(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有竹叶的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutLeaf(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutLeaf((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutLeaf(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有箨鞘的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutSheath(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutSheath((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutSheath(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有箨耳的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutSheathear(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutSheathear((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutSheathear(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有箨环的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutSheathnode(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutSheathnode((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutSheathnode(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有箨片的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutSheathshell(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutSheathshell((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutSheathshell(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有箨舌的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutSheathtongue(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutSheathtongue((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutSheathtongue(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有解剖性质_导管形态特征的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutCathermorphology(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutCathermorphology((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutCathermorphology(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有化学性质的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutChemistry(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutChemistry((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutChemistry(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有解剖性质_纤维形态特征的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutFibermorphology(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutFibermorphology((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutFibermorphology(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有力学性质的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutMechanics(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutMechanics((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutMechanics(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有物理性质的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutPhysics(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutPhysics((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutPhysics(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有结构性质的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutStructure(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutStructure((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutStructure(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有解剖性质_组织比量的数据）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutTissueproportion(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutTissueproportion((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutTissueproportion(pageable);
        }
    }

    /**
     * 分页有条件查找（不包含已有解剖性质_维管束形态特征）
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Spec> findAllQueryWithOutVascularbundelmorphology(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return specRepository.findAllQueryWithOutVascularbundelmorphology((Specification<Spec>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("specNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specBarCode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDna").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDomestic").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specForeign").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specVidio").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specImgs").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specDesc").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("specSortNum").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return specRepository.findAllQueryWithOutVascularbundelmorphology(pageable);
        }
    }

}
