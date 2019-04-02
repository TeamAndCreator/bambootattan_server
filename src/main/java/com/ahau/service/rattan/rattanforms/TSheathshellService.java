package com.ahau.service.rattan.rattanforms;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.rattan.rattanforms.TSheathshell;
import com.ahau.repository.rattan.rattanforms.TSheathshellRepository;
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
public class TSheathshellService {
    private final TSheathshellRepository tSheathshellRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public TSheathshellService(TSheathshellRepository tSheathshellRepository) {this.tSheathshellRepository = tSheathshellRepository;}

    /**
     * 查询所有箨片列表
     * @return
     */
    public List<TSheathshell> findAll() {return tSheathshellRepository.findAll();}

    /**
     * 查询一个箨片
     * @param id
     * @return
     */
    public TSheathshell findById(Long id) {
        Optional<TSheathshell> tSheathshellOptional = tSheathshellRepository.findById(id);
        TSheathshell tSheathshell = new TSheathshell();
        if (tSheathshellOptional.isPresent()) {
            tSheathshell = tSheathshellOptional.get();
        } else {
            // handle not found, return null or throw
            LOGGER.debug("no exit!");
        }
        return tSheathshell;
    }

    /**
     * 更新
     * @param tSheathshell
     * @return
     */
    public TSheathshell update(TSheathshell tSheathshell) {
        tSheathshellRepository.save(tSheathshell);
        return tSheathshell;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        tSheathshellRepository.deleteById(id);
    }

    /**
     * 添加一个箨片
     * @param tSheathshell
     * @return
     */
    public TSheathshell save(TSheathshell tSheathshell) {
        return tSheathshellRepository.save(tSheathshell);
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<TSheathshell> findTSheathshellNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return tSheathshellRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<TSheathshell> findTSheathshellQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return tSheathshellRepository.findAll((Specification<TSheathshell>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("sheathShellShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathShellColor").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathShellTopShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathShellBaseShape").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathShellMargin").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathShellBackPowder").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sheathRatioOf").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return tSheathshellRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(List<Long> ids){
        tSheathshellRepository.deleteBySheShellIdIn(ids);
    }
}
