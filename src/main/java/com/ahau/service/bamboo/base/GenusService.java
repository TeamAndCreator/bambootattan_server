package com.ahau.service.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.echart.Visit;
import com.ahau.repository.bamboo.base.GenusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 描述：竹属服务层接口
 *
 * @author 张理
 * 2018-11-3 19:22
 */
@Transactional
@Service
//@CacheConfig(cacheNames = "genus")
public class GenusService {

    private final GenusRepository genusRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public GenusService(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    /**
     * 查询所有属
     *
     * @return
     */

    public List<Genus> findAll() {
        return genusRepository.findAll();
    }

    /**
     * 查询一个属
     *
     * @param id
     * @return
     */
    //@Cacheable(value = "'findById'")
    public Genus findById(Long id) {

        Optional<Genus> genusOptional = genusRepository.findById(id);
        Genus genus = new Genus();
        if (genusOptional.isPresent()) {
            genus = genusOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return genus;
    }

//    /**
//     * 根据属的中文名查找属
//     * @param genusNameCh
//     * @return
//     */
//    public Genus findByGenusNameCh(String genusNameCh){
//        return genusRepository.findByGenusNameCh(genusNameCh);
//    }

    /**
     * 判断所有的数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh){
        return genusRepository.isNameChExisted(nameCh)>0;
    }

    /**
     * 判断不包括指定种的其他数据中是否已经存在该中文名称
     * @param nameCh 中文名称
     * @return true-存在，false-不存在
     */
    public Boolean IsNameChExisted(String nameCh,Long genusId){
        return genusRepository.isNameChExisted(nameCh,genusId)>0;
    }

    /**
     * 更新
     *
     * @param genus
     * @return
     */
    //@CachePut(key = "'genusCache'")
    public Genus update(Genus genus) {
        genusRepository.save(genus);
        return genus;
    }

    /**
     * 添加一个属
     *
     * @param genus
     * @return
     */
    public Genus save(Genus genus) {
        return genusRepository.save(genus);
    }

    /**
     * 删除
     *
     * @param id
     */
    //@CacheEvict(key = "'genusCache'")
    public void delete(Long id) {
        genusRepository.deleteById(id);
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    public Page<Genus> findGenusNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return genusRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Genus> findGenusQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return genusRepository.findAll((Specification<Genus>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("genusNameCh").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameEn").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameLd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusNameOth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("genusDesc").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return genusRepository.findAll(pageable);
        }

    }

    /**
     * 批量删除
     *
     * @param ids
     */
    public void deleteByIds(List<Long> ids) {
        genusRepository.deleteByGenusIdIn(ids);
    }

    public List<Visit> getGenus() {
        //return genusRepository.getGenus();

         return genusRepository.getGenus();
    }


//    public boolean insertOrUpdateAllColum(Genus genus) {
//        genusRepository.save(genus);
//        return false;
//    }


    }
