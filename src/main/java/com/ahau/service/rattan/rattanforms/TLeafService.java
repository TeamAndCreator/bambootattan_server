package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TLeaf;
import com.ahau.repository.rattan.rattanforms.TLeafRepository;
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
public class TLeafService {

    private final TLeafRepository tLeafRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TLeafService(TLeafRepository tLeafRepository) {this.tLeafRepository = tLeafRepository;}

    /**
     * 查询所有竹叶列表
     * @return
     */
    public List<TLeaf> findAll() {return tLeafRepository.findAll();}

    /**
     * 查询一个竹叶
     * @param id
     * @return
     */
    public TLeaf findById(Long id) {
        Optional<TLeaf> tLeafOptional = tLeafRepository.findById(id);
        TLeaf tLeaf = new TLeaf();
        if (tLeafOptional.isPresent()) {
            tLeaf = tLeafOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tLeaf;
    }

    /**
     * 更新
     * @param tLeaf
     * @return
     */
    public TLeaf update(TLeaf tLeaf) {
        tLeafRepository.save(tLeaf);
        return tLeaf;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tLeafRepository.deleteById(id);
    }

    /**
     * 添加一个竹叶
     * @param tLeaf
     * @return
     */
    public TLeaf save(TLeaf tLeaf) {
        return tLeafRepository.save(tLeaf);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TLeaf> findTLeafNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tLeafRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TLeaf> findTLeafQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tLeafRepository.findAll((Specification<TLeaf>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("leafShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafLength").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafWidth").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafNum").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder .like(root.get("leafBack").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafMargin").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafTongueShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafTongueHeight").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafStalkLength").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafBaseShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("leafTopShape").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tLeafRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tLeafRepository.deleteByLeafIdIn(ids);
    }
}
