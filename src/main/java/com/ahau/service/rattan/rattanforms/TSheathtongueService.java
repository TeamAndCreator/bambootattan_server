package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TSheathtongue;
import com.ahau.repository.rattan.rattanforms.TSheathtongueRepository;
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
public class TSheathtongueService {
    private final TSheathtongueRepository tSheathtongueRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TSheathtongueService(TSheathtongueRepository tSheathtongueRepository) {this.tSheathtongueRepository = tSheathtongueRepository;}

    /**
     * 查询所有箨舌列表
     * @return
     */
    public List<TSheathtongue> findAll() {return tSheathtongueRepository.findAll();}

    /**
     * 查询一个箨舌
     * @param id
     * @return
     */
    public TSheathtongue findById(Long id) {
        Optional<TSheathtongue> tSheathtongueOptional = tSheathtongueRepository.findById(id);
        TSheathtongue tSheathtongue = new TSheathtongue();
        if (tSheathtongueOptional.isPresent()) {
            tSheathtongue = tSheathtongueOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tSheathtongue;
    }

    /**
     * 更新
     * @param tSheathtongue
     * @return
     */
    public TSheathtongue update(TSheathtongue tSheathtongue) {
        tSheathtongueRepository.save(tSheathtongue);
        return tSheathtongue;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tSheathtongueRepository.deleteById(id);
    }

    /**
     * 添加一个箨舌
     * @param tSheathtongue
     * @return
     */
    public TSheathtongue save(TSheathtongue tSheathtongue) {
        return tSheathtongueRepository.save(tSheathtongue);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TSheathtongue> findTSheathtongueNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tSheathtongueRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TSheathtongue> findTSheathtongueQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tSheathtongueRepository.findAll((Specification<TSheathtongue>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("sheathTongueColor").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathTongueHeight").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathTongueMarginShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathTongueBackPowderv").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tSheathtongueRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tSheathtongueRepository.deleteBySheTogIdIn(ids);
    }
}
