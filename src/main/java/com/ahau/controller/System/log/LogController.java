package com.ahau.controller.System.log;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.log.Log;
import com.ahau.service.system.log.LogService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页无条件查找", notes = "分页无条件查找")
    @GetMapping("findAllNoQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
    })
    public Result findLogNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Log> logPage = logService.findLogNoQuery(page, size);

        return ResultUtil.success(logPage);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找", notes = "分页有条件查找")
    @GetMapping("findAllQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findLogQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {
        Page<Log> logPage = logService.findLogQuery(page, size, search);
        return ResultUtil.success(logPage);
    }

    /**
     * 查询时间段内的日志
     * @param page
     * @param size
     * @param startTime
     * @param endTime
     * @return
     */
    @ApiOperation(value = "查询时间段内的日志", notes = "根据日期查询时间段内的日志")
    @GetMapping("findDateQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "查询时间上限", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "查询时间下限", paramType = "query")
    })
    public Result findLogDateQuery(@RequestParam Integer page, @RequestParam Integer size, String startTime, String endTime) {
        Page<Log> logPage = logService.findLogDateQuery(page, size, startTime, endTime);
        return ResultUtil.success(logPage);
    }

//    /**
//     * 查询所有日志
//     * @return
//     */
//    @ApiOperation(value = "获取所有日志列表", notes = "获取所有日志列表")
//    @GetMapping("findAll")
//    public Result findAll() { return ResultUtil.success(logService.findAll()); }


}
