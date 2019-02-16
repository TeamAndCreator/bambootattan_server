package com.ahau.service.system.log;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.log.Log;
import com.ahau.repository.system.log.LogRepository;
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

/**
 * 描述：日志服务层接口
 * Created by: zhangli
 * 2019-2-16
 */
@Transactional
@Service
public class LogService {
    private final LogRepository logRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public LogService(LogRepository logRepository) {this.logRepository = logRepository;}

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Log> findLogNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return logRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Log> findLogQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return logRepository.findAll((Specification<Log>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("optUrl").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("optUser").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("optTime").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("optIp").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("requestParam").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("classMethod").as(String.class), "%" + search + "%"));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return logRepository.findAll(pageable);
        }

    }

//    /**
//     * 查询所有属
//     * @return
//     */
//    public List<Log> findAll() { return logRepository.findAll();}


}
