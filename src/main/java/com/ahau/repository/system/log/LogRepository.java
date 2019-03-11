package com.ahau.repository.system.log;

import com.ahau.entity.system.log.Log;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 描述：日志Repository
 * Created by: zhangli
 * 2019-2-16
 */
public interface LogRepository extends JpaRepository<Log, Long> , JpaSpecificationExecutor<Log> {

}
