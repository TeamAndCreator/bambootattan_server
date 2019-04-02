package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TSheathnode;
import com.ahau.repository.rattan.rattanforms.TSheathnodeRepository;
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
public class TSheathnodeService {
    private final TSheathnodeRepository tSheathnodeRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    public TSheathnodeService(TSheathnodeRepository tSheathnodeRepository) {this.tSheathnodeRepository = tSheathnodeRepository;}

    /**
     * 查询所有箨环列表
     * @return
     */
    public List<TSheathnode> findAll() {return tSheathnodeRepository.findAll();}

    /**
     * 查询一个箨环
     * @param id
     * @return
     */
    public TSheathnode findById(Long id) {
        Optional<TSheathnode> tSheathnodeOptional = tSheathnodeRepository.findById(id);
        TSheathnode tSheathnode = new TSheathnode();
        if (tSheathnodeOptional.isPresent()) {
            tSheathnode = tSheathnodeOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tSheathnode;
    }

    /**
     * 更新
     * @param tSheathnode
     * @return
     */
    public TSheathnode update(TSheathnode tSheathnode) {
        tSheathnodeRepository.save(tSheathnode);
        return tSheathnode;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tSheathnodeRepository.deleteById(id);
    }

    /**
     * 添加一个箨环
     * @param tSheathnode
     * @return
     */
    public TSheathnode save(TSheathnode tSheathnode) {
        return tSheathnodeRepository.save(tSheathnode);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TSheathnode> findTSheathnodeNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tSheathnodeRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TSheathnode> findTSheathnodeQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tSheathnodeRepository.findAll((Specification<TSheathnode>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("sheathNode").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathNodeBack").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tSheathnodeRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tSheathnodeRepository.deleteBySheNodeIdIn(ids);
    }
}
