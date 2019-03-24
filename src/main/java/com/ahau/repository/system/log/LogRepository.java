package com.ahau.repository.system.log;

import com.ahau.entity.system.log.Log;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 描述：日志Repository
 * Created by: zhangli
 * 2019-2-16
 */
public interface LogRepository extends JpaRepository<Log, Long> , JpaSpecificationExecutor<Log> {

//    void deleteByLogIdIn(List<Long> ids);
    // 保留7天内的日志记录（插入日志时自动删除7天前日志）
    @Query(value = "delete from log where TO_DAYS(NOW()) - TO_DAYS(opt_Time) > 1", nativeQuery = true)
    @Modifying
    void delSevenDayLogs();
}
