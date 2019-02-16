package com.ahau.service.system.log;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.log.Log;
import com.ahau.repository.system.log.LogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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

    public List<Log> findAll() { return logRepository.findAll();}
}
