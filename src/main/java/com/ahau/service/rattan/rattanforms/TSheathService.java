package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TSheath;
import com.ahau.repository.rattan.rattanforms.TSheathRepository;
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
public class TSheathService {
    private final TSheathRepository tSheathRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TSheathService(TSheathRepository tSheathRepository) {this.tSheathRepository = tSheathRepository;}

    /**
     * 查询所有箨鞘列表
     * @return
     */
    public List<TSheath> findAll() {return tSheathRepository.findAll();}

    /**
     * 查询一个箨鞘
     * @param id
     * @return
     */
    public TSheath findById(Long id) {
        Optional<TSheath> tSheathOptional = tSheathRepository.findById(id);
        TSheath tSheath = new TSheath();
        if (tSheathOptional.isPresent()) {
            tSheath = tSheathOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tSheath;
    }

    /**
     * 更新
     * @param tSheath
     * @return
     */
    public TSheath update(TSheath tSheath) {
        tSheathRepository.save(tSheath);
        return tSheath;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tSheathRepository.deleteById(id);
    }

    /**
     * 添加一个箨鞘
     * @param tSheath
     * @return
     */
    public TSheath save(TSheath tSheath) {
        return tSheathRepository.save(tSheath);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TSheath> findTSheathNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tSheathRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TSheath> findTSheathQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tSheathRepository.findAll((Specification<TSheath>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("sheathShedTime").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathChar").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathTopForm").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathBackPowder").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathMarginForm").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tSheathRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tSheathRepository.deleteBySheIdIn(ids);
    }
}
