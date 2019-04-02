package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TSheathear;
import com.ahau.repository.rattan.rattanforms.TSheathearRepository;
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
public class TSheathearService {
    private final TSheathearRepository tSheathearRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TSheathearService(TSheathearRepository tSheathearRepository) {this.tSheathearRepository = tSheathearRepository;}

    /**
     * 查询所有箨耳列表
     * @return
     */
    public List<TSheathear> findAll() {return tSheathearRepository.findAll();}

    /**
     * 查询一个箨耳
     * @param id
     * @return
     */
    public TSheathear findById(Long id) {
        Optional<TSheathear> tSheathearOptional = tSheathearRepository.findById(id);
        TSheathear tSheathear = new TSheathear();
        if (tSheathearOptional.isPresent()) {
            tSheathear = tSheathearOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tSheathear;
    }

    /**
     * 更新
     * @param tSheathear
     * @return
     */
    public TSheathear update(TSheathear tSheathear) {
        tSheathearRepository.save(tSheathear);
        return tSheathear;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tSheathearRepository.deleteById(id);
    }

    /**
     * 添加一个箨耳
     * @param tSheathear
     * @return
     */
    public TSheathear save(TSheathear tSheathear) {
        return tSheathearRepository.save(tSheathear);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TSheathear> findTSheathearNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tSheathearRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TSheathear> findTSheathearQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tSheathearRepository.findAll((Specification<TSheathear>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("sheathEarDev").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathEarShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathEarMargin").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tSheathearRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tSheathearRepository.deleteBySheEarIdIn(ids);
    }
}
