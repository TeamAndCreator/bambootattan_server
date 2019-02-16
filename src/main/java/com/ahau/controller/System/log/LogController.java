package com.ahau.controller.System.log;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.system.log.LogService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：日志控制层接口
 * Created by: zhangli
 * 2019-2-16
 */
@RestController
@Api(description = "日志接口")
@RequestMapping(value = "/log")
public class LogController {
    private final LogService logService;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public LogController(LogService logService) {this.logService = logService;}

    /**
     * 查询所有日志
     * @return
     */
    @ApiOperation(value = "获取所有日志列表", notes = "获取所有日志列表")
    @GetMapping("findAll")
    public Result findAll() { return ResultUtil.success(logService.findAll()); }
}
