package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TUnderstem;
import com.ahau.repository.rattan.rattanforms.TUnderstemRepository;
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
public class TUnderstemService {
    private final TUnderstemRepository tUnderstemRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TUnderstemService(TUnderstemRepository tUnderstemRepository) {this.tUnderstemRepository = tUnderstemRepository;}

    /**
     * 查询所有地下茎列表
     * @return
     */
    public List<TUnderstem> findAll() {return tUnderstemRepository.findAll();}

    /**
     * 查询一个地下茎
     * @param id
     * @return
     */
    public TUnderstem findById(Long id) {
        Optional<TUnderstem> tUnderstemOptional = tUnderstemRepository.findById(id);
        TUnderstem tUnderstem = new TUnderstem();
        if (tUnderstemOptional.isPresent()) {
            tUnderstem = tUnderstemOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tUnderstem;
    }

    /**
     * 更新
     * @param tUnderstem
     * @return
     */
    public TUnderstem update(TUnderstem tUnderstem) {
        tUnderstemRepository.save(tUnderstem);
        return tUnderstem;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tUnderstemRepository.deleteById(id);
    }

    /**
     * 添加一个地下茎
     * @param understem
     * @return
     */
    public TUnderstem save(TUnderstem understem) {
        return tUnderstemRepository.save(understem);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TUnderstem> findTUnderstemNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tUnderstemRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TUnderstem> findTUnderstemQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tUnderstemRepository.findAll((Specification<TUnderstem>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("underStem").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tUnderstemRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tUnderstemRepository.deleteByUnderStemIdIn(ids);
    }
}
