package com.ahau.service.system.log;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.log.Log;
import com.ahau.repository.system.log.LogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Sort sort = new Sort(Sort.Direction.DESC, "LogId")
                .and(new Sort(Sort.Direction.DESC, "optTime"));
        Pageable pageable = PageRequest.of(page, size, sort);
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

    /**
     * 查询时间段内的日志
     * @param page
     * @param size
     * @param startTime
     * @param endTime
     * @return
     */
    public Page<Log> findLogDateQuery(Integer page, Integer size, String startTime, String endTime) {
        Sort sort = new Sort(Sort.Direction.DESC, "LogId")
                .and(new Sort(Sort.Direction.DESC, "optTime"));
        Pageable pageable = PageRequest.of(page, size, sort);
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            return logRepository.findAll((Specification<Log>) (root, criteriaQuery, criteriaBuilder) -> {
                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.between(root.get("optTime").as(String.class),startTime,endTime));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            }, pageable);
        } else {
            return logRepository.findAll(pageable);
        }
    }


    /**
     * 添加一个日志
     * @param log
     * @return
     */
    public Log save(Log log) {
        return logRepository.save(log);
    }

//    public List<Map<String, Object>> findLogDateQuery(Map<String, Object> map) {
//        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT");
//        sql.append("'class_method', 'opt_ip', 'opt_time', 'opt_url', 'opt_user', 'request_param'");
//        sql.append("FROM 'log'");
//        sql.append("WHERE uid = :uid and status=2 and opt_time between :start_time and :end_time ");
//        List<Map<String, Object>> resultList = null;
//        return resultList;
//    }

//    /**
//     * 查询所有属
//     * @return
//     */
//    public List<Log> findAll() { return logRepository.findAll();}


}
