package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TCulm;
import com.ahau.repository.rattan.rattanforms.TCulmRepository;
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
public class TCulmService {
    private final TCulmRepository tCulmRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TCulmService(TCulmRepository tCulmRepository) {this.tCulmRepository = tCulmRepository;}

    /**
     * 查询所有藤秆列表
     * @return
     */
    public List<TCulm> findAll() {return tCulmRepository.findAll();}

    /**
     * 查询一个藤秆
     * @param id
     * @return
     */
    public TCulm findById(Long id) {
        Optional<TCulm> tCulmOptional = tCulmRepository.findById(id);
        TCulm tCulm = new TCulm();
        if (tCulmOptional.isPresent()) {
            tCulm = tCulmOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tCulm;
    }

    /**
     * 更新
     * @param tCulm
     * @return
     */
    public TCulm update(TCulm tCulm) {
        tCulmRepository.save(tCulm);
        return tCulm;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tCulmRepository.deleteById(id);
    }

    /**
     * 添加一个藤秆
     * @param tCulm
     * @return
     */
    public TCulm save(TCulm tCulm) {
        return tCulmRepository.save(tCulm);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TCulm> findTCulmNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tCulmRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TCulm> findTCulmQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tCulmRepository.findAll((Specification<TCulm>) (root, criteriaQuery, criteriaBuilder) -> {

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
            return tCulmRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public  void  deleteByIds(List<Long> ids){
        tCulmRepository.deleteByCulmIdIn(ids);
    }
}
