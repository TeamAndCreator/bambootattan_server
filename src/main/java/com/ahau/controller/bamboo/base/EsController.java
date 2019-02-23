package com.ahau.controller.bamboo.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.base.EsService;
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
 * 描述：搜索引擎控制层
 * Created by: zhangli
 * 2019-2-17
 */
@RestController
@RequestMapping("/Elasticsearch")
@Api(description = "搜索引擎")
public class EsController {

    private static final Logger LOGGER = LogManager.getLogger(EsController.class);

    private final EsService esService;

    @Autowired
    public EsController(EsService esService) {
        this.esService = esService;
    }

    /**
     * 查询所有种列表
     * @return
     */
    @ApiOperation(value = "查找所有种列表", notes = "查找所有种列表")
    @GetMapping("search")
    public Result search() {
        LOGGER.info(esService.search().toString());
        return ResultUtil.success(esService.search());
    }
}
