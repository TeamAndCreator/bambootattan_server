package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Tissueproportion;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.TissueproportionService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 解剖性质_组织比量控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tissueproportion")
@Api(description = "解剖性质_组织比量")
@CacheConfig(cacheNames = "tissueproportion")
public class TissueproportionController {
    private final TissueproportionService tissueproportionService;

    @Autowired
    public TissueproportionController(TissueproportionService tissueproportionService) {this.tissueproportionService = tissueproportionService;}

    /**
     * 查询所有解剖性质_组织比量列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_组织比量列表", notes = "获取所有解剖性质_组织比量列表")
    @GetMapping("findAll")
    @Cacheable(value = "tissueproportion-findAll")
    public Result findAll() {
        return ResultUtil.success(tissueproportionService.findAll());
    }

    /**
     * 查询一个解剖性质_组织比量列表
     * @param tpId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_组织比量详细信息", notes = "根据url的id来获取解剖性质_组织比量详细信息")
    @GetMapping("findId/{tpId}")
    @Cacheable(value = "tissueproportion-findById",key = "#tpId")
    public Result findById(@ApiParam(name = "tpId", value = "需要查找的解剖性质_组织比量的id", required = true)
                           @PathVariable("tpId") Long tpId) {
        return ResultUtil.success(tissueproportionService.findById(tpId));
    }

    /**
     * 更新
     * @param tissueproportion
     * @return
     */
    @ApiOperation(value = "更新解剖性质_组织比量信息", notes = "根据url的id来指定更新解剖性质_组织比量信息")
    @PutMapping("update")
    @CacheEvict(value = "tissueproportion-findById", key = "#tissueproportion.tpId", allEntries = true)
    public Result update(@ApiParam(name = "tissueproportion",
            value = "要修改的属详细实体tissueproportion", required = true)
                         @RequestBody Tissueproportion tissueproportion) {
        return ResultUtil.success(tissueproportionService.update(tissueproportion));
    }

    /**
     * 删除
     * @param tpId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_组织比量", notes = "根据url的id来指定删除解剖性质_组织比量")
    @DeleteMapping("delete/{tpId}")
    @CacheEvict(value = "tissueproportion-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "tpId", value = "需删除解剖性质_组织比量的ID", required = true)
                         @PathVariable("tpId") Long tpId) {
        tissueproportionService.delete(tpId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_组织比量
     * @param tissueproportion
     * @return
     */
    @ApiOperation(value = "创建解剖性质_组织比量", notes = "根据Tissueproportion对象创建解剖性质_组织比量")
    @PostMapping("save")
    @CacheEvict(value = "tissueproportion-findAll", allEntries = true)
    public Result save(@ApiParam(name = "tissueproportion",
            value = "要添加的解剖性质_组织比量详细实体tissueproportion", required = true)
                       @RequestBody Tissueproportion tissueproportion) {
        return ResultUtil.success(tissueproportionService.save(tissueproportion));
    }

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
    @Cacheable(value = "tissueproportion-findTissueproportionNoQuery")
    public Result findTissueproportionNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Tissueproportion> tissueproportionPage = tissueproportionService.findTissueproportionNoQuery(page, size);

        return ResultUtil.success(tissueproportionPage);
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
    public Result findTissueproportionQuery(@RequestParam Integer page, @RequestParam Integer size,
                                     String search) {

        Page<Tissueproportion> tissueproportionPage = tissueproportionService.findTissueproportionQuery(page, size, search);

        return ResultUtil.success(tissueproportionPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_组织比量")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "tissueproportion-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_组织比量的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tissueproportionService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
